package dog.rescue.controller;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.jdbc.JdbcTestUtils;

import dog.rescue.controller.model.LocationData;
import dog.rescue.entity.Location;

public class RescueServiceTestSupport {

	private static final String LOCATION_TABLE = "location";

	// @formatter:off
	private LocationData insertAddress1 = new LocationData(
			1L,
			"North Hills Dog Rescue Society",
			"52 Pine Street",
			"Abdingdon",
			"Maryland",
			"21009",
			"(410) 459-3200"
	);
	
	private LocationData insertAddress2 = new LocationData(
			2L,
			"Navarre Rescue",
			"42 Valley Farms Street",
			"Navarre",
			"Florida",
			"32556",
			"(850) 204-9485"
	);
	
	private LocationData updateAddress1 = new LocationData(
			1L,
			"Glenlake Dog Rescue Society",
			"8 East Glenlake Drive",
			"Wadsworth",
			"Ohio",
			"83241",
			"(330) 336-2105"
			);
	
	// @formatter:on

	@Autowired
	private JdbcTemplate jdbcTemplate;
	/**
	 * JdbcTemplate is one way of using JDBC to get information about the tables;
	 * we'll use it to see how many rows are in a table after doing an INSERT
	 */

	@Autowired
	private RescueController rescueController;

	protected LocationData buildInsertLocation(int which) {
		return which == 1 ? insertAddress1 : insertAddress2;
	}

	protected LocationData insertLocation(LocationData locationData) {
		/**
		 * Create a Location object, then convert it to a LocationData object (i.e.
		 * "clone") and then back to a Location object so we can unset the location ID
		 * without changing the value for the instance variable (insertAddress1) (bc it
		 * will have a different reference)
		 */
		Location location = locationData.toLocation();
		LocationData clone = new LocationData(location);

		clone.setLocationId(null); // PK ID is null because we're INSERTing
		return rescueController.createLocation(clone);
	}

	protected int rowsInLocationTable() {
		/**
		 * call a static method on a utility class JdbcTestUtils
		 */
		return JdbcTestUtils.countRowsInTable(jdbcTemplate, LOCATION_TABLE);
	}

	protected LocationData retrieveLocation(Long locationId) {
		return rescueController.retrieveLocation(locationId);
	}

	protected List<LocationData> insertTwoLocations() {
		LocationData location1 = insertLocation(buildInsertLocation(1));
		LocationData location2 = insertLocation(buildInsertLocation(2));

		return List.of(location1, location2);
	}

	protected List<LocationData> retrieveAllLocations() {
		return rescueController.retrieveAllLocations();
	}

	/**
	 * Sort both expected and actual test results from retrieveAllLocations for
	 * accurate test comparison
	 * 
	 * @param actual
	 * @return
	 */
	protected List<LocationData> sorted(List<LocationData> list) {
		// Turn the immutable list (result of .toList() method) into a mutable list
		List<LocationData> data = new LinkedList<>(list);

		/**
		 * Compare location IDs to sort, casting as int (bc that's how the IDs were
		 * defined)
		 */
		data.sort((loc1, loc2) -> (int) (loc1.getLocationId() - loc2.getLocationId()));
		return data;
	}
	
	/**
	 * @param expected
	 * @return
	 */
	protected LocationData updateLocation(LocationData locationData) {
		return rescueController.updateLocation(locationData.getLocationId(), locationData); // pass in the ID and the response body i.e. locationData
	}

	/**
	 * @return
	 */
	protected LocationData buildUpdateLocation() {
		return updateAddress1;
	}
}
