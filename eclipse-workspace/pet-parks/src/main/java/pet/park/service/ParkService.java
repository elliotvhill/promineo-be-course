/**
 * 
 */
package pet.park.service;

import java.util.NoSuchElementException;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pet.park.controller.model.ContributorData;
import pet.park.dao.ContributorDao;
import pet.park.entity.Contributor;

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
		Contributor contributor = findOrCreateContributor(contributorId);
		
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
	private Contributor findOrCreateContributor(Long contributorId) {
		Contributor contributor;

		if (Objects.isNull(contributorId)) {
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

}
