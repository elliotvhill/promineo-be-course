/**
 * 
 */
package pet.park.entity;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Entity
@Data
public class Contributor {
	@Id // tells JPA this is the identity column or PK
	@GeneratedValue(strategy = GenerationType.IDENTITY) // tells JPA how the PK is managed
	// Fields from ERD
	private Long contributorId; // will be used for the join column; JPA will convert the name to "contributor_id" (snake case)
	
	private String contributorName;
	
	@Column(unique = true) // JPA will create an index (unique key) on contributor_email
	private String contributorEmail;
	
	@EqualsAndHashCode.Exclude
	@ToString.Exclude
	@OneToMany(mappedBy = "contributor", cascade = CascadeType.ALL) // name of the Java variable from the PetPark class; specify cascade behavior
	private Set<PetPark> petParks = new HashSet<>();
}
