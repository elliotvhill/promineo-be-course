/**
 * 
 */
package pet.park.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
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
}
