/**
 * 
 */
package pet.park.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;
import pet.park.controller.model.ContributorData;
import pet.park.service.ParkService;

@RestController
/*
 * says that every method will return a 200 status by default and we are
 * expecting JSON coming into the method and JSON returning from the method
 */

// How to map the URIs into the method:
@RequestMapping("/pet_park")
@Slf4j // Logger from Lombok
public class ParkController {

	// We want Spring to manage this object for us -> managed being
	@Autowired
	private ParkService parkService;
	
	@PostMapping("/contributor") // This method is going to get a POST request to "/pet_park/contributor"
	@ResponseStatus(code = HttpStatus.CREATED)
	public ContributorData insertContributor(@RequestBody ContributorData contributorData) {
		// @RequestBody tells Spring Boot the JSON will be in the request payload/body

		log.info("Creating contributor ()", contributorData); // () is the parameter placeholder syntax
		return parkService.saveContributor(contributorData);
	}
	
	@PutMapping("/contributor/{contributorId}")
	public ContributorData updateContributor(@PathVariable Long contributorId, @RequestBody ContributorData contributorData) {
		contributorData.setContributorId(contributorId);
		log.info("Updating contributor {}", contributorData);
		return parkService.saveContributor(contributorData);
	}
	
	@GetMapping("/contributor")
	public List<ContributorData> retrieveAllContributors() {
		// Log the GET request
		log.info("Retrieve all contributors called.");
		// Call ParkService and return the results of the method
		return parkService.retrieveAllContributors();
	}
	
	@GetMapping("/contributor/{contributorId}")
	public ContributorData retrieveContributorById(@PathVariable Long contributorId) { // PathVariable tells Spring we expect the id from the url and to pass it to the method as contributorId
		log.info("Retrieving contributor with ID={}", contributorId);
		return parkService.retrieveContributorById(contributorId);
	}
	
	@DeleteMapping("/contributor")
	public void deleteAllContributors() {
		log.info("Attempting to delete all contributors.");
		throw new UnsupportedOperationException("Deleting all contributors is not allowed.");
	}
	
	@DeleteMapping("/contributor/{contributorId}")
	public Map<String, String> deleteContributorById(@PathVariable Long contributorId) {
		log.info("Deleting contributor with ID={}", contributorId);
		
		parkService.deleteContributorById(contributorId);
		
		return Map.of("message", "Deletion of contributor with ID=" + contributorId + " was successful.");
	}
	
}
