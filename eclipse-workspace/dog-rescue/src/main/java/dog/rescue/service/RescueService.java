package dog.rescue.service;

import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dog.rescue.controller.model.LocationData;
import dog.rescue.dao.LocationDao;
import dog.rescue.entity.Location;

@Service
public class RescueService {

	@Autowired
	private LocationDao locationDao;

	/**
	 * @param locationData
	 * @return
	 */
	@Transactional(readOnly = false)
	public LocationData saveLocation(LocationData locationData) {
		// Convert back to a Location entity
		Location location = locationData.toLocation(); // comes in without a PK
		Location dbLocation = locationDao.save(location); // is saved with a PK that is then returned below

		return new LocationData(dbLocation);
	}

	/**
	 * @param locationId
	 * @return
	 */
	@Transactional(readOnly = true)
	public LocationData retrieveLocationById(Long locationId) {
		Location location = findLocationById(locationId);
		return new LocationData(location);
	}

	/**
	 * @param locationId
	 * @return
	 */
	private Location findLocationById(Long locationId) {
		return locationDao.findById(locationId)
				.orElseThrow(() -> new NoSuchElementException(
						"Location with ID=" + locationId + " was not found."));
	}

}
