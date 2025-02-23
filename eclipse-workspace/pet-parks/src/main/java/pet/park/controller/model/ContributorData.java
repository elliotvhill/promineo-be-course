/**
 * 
 */
package pet.park.controller.model;

import java.util.HashSet;
import java.util.Set;

import lombok.Data;
import lombok.NoArgsConstructor;
import pet.park.entity.Amenity;
import pet.park.entity.Contributor;
import pet.park.entity.GeoLocation;
import pet.park.entity.PetPark;

@Data
@NoArgsConstructor // tells Lombok to keep a constructor without args in addition to the one we create below with args
public class ContributorData {
	private Long contributorId;
	private String contributorName;
	private String contributorEmail;
	private Set<PetParkResponse> petParks = new HashSet<>();
	
	/**
	 * Convert the Contributor object into a ContributorData object for Jackson to
	 * use
	 * 
	 * @param contributor
	 */
	public ContributorData(Contributor contributor) {
		contributorId = contributor.getContributorId();
		contributorName = contributor.getContributorName();
		contributorEmail = contributor.getContributorEmail();
		
		for (PetPark petPark : contributor.getPetParks()) {
			petParks.add(new PetParkResponse(petPark));
		}
	}

	@Data
	@NoArgsConstructor
	static class PetParkResponse {
		private Long petParkId;
		private String parkName;
		private String directions;
		private String stateOrProvince;
		private String country;
		private GeoLocation geoLocation;
		private Set<String> amenities = new HashSet<>();
		
		PetParkResponse (PetPark petPark) {
			petParkId = petPark.getPetParkId();
			parkName = petPark.getParkName();
			directions = petPark.getDirections();
			stateOrProvince = petPark.getStateOrProvince();
			country = petPark.getCountry();
			geoLocation = new GeoLocation(petPark.getGeoLocation());
			
			for (Amenity amenity : petPark.getAmenities()) {
				amenities.add(amenity.getAmenity());
			}
		}
	}
}
