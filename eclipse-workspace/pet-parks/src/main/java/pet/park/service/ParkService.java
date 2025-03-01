/**
 * 
 */
package pet.park.service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pet.park.controller.model.ContributorData;
import pet.park.controller.model.PetParkData;
import pet.park.dao.AmenityDao;
import pet.park.dao.ContributorDao;
import pet.park.dao.PetParkDao;
import pet.park.entity.Amenity;
import pet.park.entity.Contributor;
import pet.park.entity.PetPark;

@SuppressWarnings("unused")
@Service
public class ParkService {

	@Autowired
	private ContributorDao contributorDao;
	
	@Autowired
	private AmenityDao amenityDao;
	
	@Autowired PetParkDao petParkDao;

	/**
	 * @param contributorData
	 * @return
	 */
	@Transactional(readOnly = false) // Start a transaction
	public ContributorData saveContributor(ContributorData contributorData) {
		Long contributorId = contributorData.getContributorId();
		Contributor contributor = findOrCreateContributor(contributorId, contributorData.getContributorEmail());

		setFieldsInContributor(contributor, contributorData);
		return new ContributorData(contributorDao.save(contributor));

	}

	/**
	 * @param contributor
	 * @param contributorData
	 */
	private void setFieldsInContributor(Contributor contributor, ContributorData contributorData) {
		contributor.setContributorEmail(contributorData.getContributorEmail());
		contributor.setContributorName(contributorData.getContributorName());
	}

	/**
	 * @param contributorId
	 */
	private Contributor findOrCreateContributor(Long contributorId, String contributorEmail) {
		Contributor contributor;

		if (Objects.isNull(contributorId)) {
			// use ContributorDao to find whether the email exists
			Optional<Contributor> opContrib = contributorDao.findByContributorEmail(contributorEmail);

			if (opContrib.isPresent()) {
				throw new DuplicateKeyException("Contributor with email " + contributorEmail + " already exists.");
			}

			// Create a new contributor
			contributor = new Contributor();
		} else {
			// Find the existing contributor
			contributor = findContributorById(contributorId);
		}

		return contributor;
	}

	/**
	 * @param contributorId
	 * @return
	 */
	private Contributor findContributorById(Long contributorId) {
		return contributorDao.findById(contributorId).orElseThrow(
				() -> new NoSuchElementException("Contributor with ID=" + contributorId + " was not found."));
	}

	/**
	 * @return
	 */
	@Transactional(readOnly = true)
	public List<ContributorData> retrieveAllContributors() {
		// Method 1:
//		List<Contributor> contributors = contributorDao.findAll();
//		List<ContributorData> response = new LinkedList<>();
//		
//		// Turn the list of Contributor entities into a list of ContributorData
//		for (Contributor contributor : contributors) {
//			response.add(new ContributorData(contributor));
//		}
//		
//		return response;

		// Method 2 - using Strings: // new since Java 1.8

		// @formatter:off
		return contributorDao.findAll()
			.stream()
//			.map(cont -> new ContributorData(cont)) // this Lambda can be simplified by using a method reference
			.map(ContributorData::new) // method reference
			.toList();
		// @formatter:on
	}

	/**
	 * @param contributorId
	 * @return
	 */
	@Transactional(readOnly = true)
	public ContributorData retrieveContributorById(Long contributorId) {
		Contributor contributor = findContributorById(contributorId);
		return new ContributorData(contributor);
	}

	/**
	 * @param contributorId
	 */
	@Transactional(readOnly = false)
	public void deleteContributorById(Long contributorId) {
		Contributor contributor = findContributorById(contributorId);
		contributorDao.delete(contributor);
	}

	/**
	 * @param contributorId
	 * @param petParkData
	 * @return
	 */
	@Transactional(readOnly = false)
	public PetParkData savePetPark(Long contributorId, 
			PetParkData petParkData) {
		Contributor contributor = findContributorById(contributorId);
		
		Set<Amenity> amenities = amenityDao.findAllByAmenityIn(petParkData.getAmenities());
		
		PetPark petPark = findOrCreatePetPark(petParkData.getPetParkId());
		setPetParkFields(petPark, petParkData);
		
		petPark.setContributor(contributor);
		contributor.getPetParks().add(petPark);
		
		for (Amenity amenity : amenities) {
			amenity.getPetParks().add(petPark);
			petPark.getAmenities().add(amenity);
		}
		
		PetPark dbPetPark = petParkDao.save(petPark);
		return new PetParkData(dbPetPark);
	}

	/**
	 * @param petPark
	 * @param petParkData
	 */
	private void setPetParkFields(PetPark petPark, PetParkData petParkData) {
		petPark.setCountry(petParkData.getCountry());
		petPark.setDirections(petParkData.getDirections());
		petPark.setGeoLocation(petParkData.getGeoLocation());
		petPark.setParkName(petParkData.getParkName());
		petPark.setPetParkId(petParkData.getPetParkId());
		petPark.setStateOrProvince(petParkData.getStateOrProvince());
	}

	/**
	 * @param petParkId
	 * @return
	 */
	private PetPark findOrCreatePetPark(Long petParkId) {
		PetPark petPark;
		
		if (Objects.isNull(petParkId)) {
			petPark = new PetPark();
		}
		else {
			petPark = findPetParkById(petParkId);
		}
		
		return petPark;
	}

	/**
	 * @param petParkId
	 * @return
	 */
	private PetPark findPetParkById(Long petParkId) {
		return petParkDao.findById(petParkId)
				.orElseThrow(() -> new NoSuchElementException(
						"Pet park with ID=" + petParkId + " does not exist."));
	}

	/**
	 * @param contributorId
	 * @param parkId
	 * @return
	 */
	@Transactional(readOnly = true)
	public PetParkData retrievePetParkById(Long contributorId, Long parkId) {
		// validate that contributor ID exists
		findContributorById(contributorId);
		PetPark petPark = findPetParkById(parkId);
		
		if (petPark.getContributor().getContributorId() != contributorId) {
			throw new IllegalStateException("Pet park with ID=" + parkId + " is not owned by contributor with ID=" + contributorId);
		}
		
		return new PetParkData(petPark);
	}

}
