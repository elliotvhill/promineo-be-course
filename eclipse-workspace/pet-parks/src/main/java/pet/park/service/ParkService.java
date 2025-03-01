/**
 * 
 */
package pet.park.service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pet.park.controller.model.ContributorData;
import pet.park.dao.ContributorDao;
import pet.park.entity.Contributor;

@SuppressWarnings("unused")
@Service
public class ParkService {

	@Autowired
	private ContributorDao contributorDao;

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

}
