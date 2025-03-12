package dog.rescue.service;

import java.util.LinkedList;
import java.util.List;
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
				.orElseThrow(() -> new NoSuchElementException("Location with ID=" + locationId + " was not found."));
	}

	@Transactional(readOnly = true)
	public List<LocationData> retrieveAllLocations() {
		// One approach: use enhanced for loop
//		List<Location> locationEntities = locationDao.findAll();
//		List<LocationData> locationDtos = new LinkedList<>();
//		
//		// loop to convert Location entities into LocationData objects
//		for (Location location : locationEntities) {
//			LocationData locationData = new LocationData(location);
//			locationDtos.add(locationData);
//		}
//		
//		return locationDtos;

		// Alternate approach: Use Streams and Lambda expression
		// @formatter:off
		return locationDao.findAll()
				// turn into a Stream of Location entities
				.stream()
				// use map to turn it into a Stream of LocationData objects
				.map(loc -> new LocationData(loc)) // can be further simplified using a method reference operator ("::") to just .map(LocationData::new)
				// return it as a List
				.toList();
		// @formatter:on
	}

}
