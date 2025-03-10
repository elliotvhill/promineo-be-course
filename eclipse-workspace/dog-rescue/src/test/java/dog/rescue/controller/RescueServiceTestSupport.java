package dog.rescue.controller;

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

}
