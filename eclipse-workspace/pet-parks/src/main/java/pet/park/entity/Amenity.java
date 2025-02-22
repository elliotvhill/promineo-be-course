/**
 * 
 */
package pet.park.entity;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Entity
@Data
public class Amenity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // Sets up PK field
	// Fields:
	private Long amenityId;
	
	private String amenity;
	
	@EqualsAndHashCode.Exclude
	@ToString.Exclude
	@ManyToMany(mappedBy = "amenities") // mappedBy the JAVA field name
	private Set<PetPark> petParks = new HashSet<>();
}
