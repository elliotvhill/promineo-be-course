/**
 * 
 */
package pet.store.service;

import java.util.NoSuchElementException;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pet.store.controller.model.PetStoreData;
import pet.store.controller.model.PetStoreData.PetStoreEmployee;
import pet.store.dao.EmployeeDao;
import pet.store.dao.PetStoreDao;
import pet.store.entity.Employee;
import pet.store.entity.PetStore;

@Service
public class PetStoreService {
	@Autowired
	private PetStoreDao petStoreDao;
	@Autowired
	EmployeeDao employeeDao;

	@Transactional(readOnly = false)
	public PetStoreData savePetStore(PetStoreData petStoreData) {
		Long petStoreId = petStoreData.getPetStoreId();
		PetStore petStore = findOrCreatePetStore(petStoreId);

		copyPetStoreFields(petStore, petStoreData);

		return new PetStoreData(petStoreDao.save(petStore));
	}

	private PetStore findOrCreatePetStore(Long petStoreId) {
		if (Objects.isNull(petStoreId)) {
			// create a new PetStore object if petStoreId is null
			return new PetStore();
		} else {
			// Find and return the existing pet store by ID
			return findPetStoreById(petStoreId);
		}
	}

	private PetStore findPetStoreById(Long petStoreId) {
		return petStoreDao.findById(petStoreId)
				.orElseThrow(() -> new NoSuchElementException("Pet store with ID=" + petStoreId + " does not exist."));
	}

	private void copyPetStoreFields(PetStore petStore, PetStoreData petStoreData) {
		petStore.setPetStoreId(petStoreData.getPetStoreId());
		petStore.setPetStoreName(petStoreData.getPetStoreName());
		petStore.setPetStoreAddress(petStoreData.getPetStoreAddress());
		petStore.setPetStoreCity(petStoreData.getPetStoreCity());
		petStore.setPetStoreState(petStoreData.getPetStoreState());
		petStore.setPetStoreZip(petStoreData.getPetStoreZip());
		petStore.setPetStorePhone(petStoreData.getPetStorePhone());
	}

	/**
	 * @param petStoreEmployee
	 * @return
	 */
	@Transactional(readOnly = false)
	public PetStoreEmployee saveEmployee(Long petStoreId, PetStoreEmployee petStoreEmployee) {
		PetStore petStore = findPetStoreById(petStoreId);
		Long employeeId = petStoreEmployee.getEmployeeId();
		Employee employee = findOrCreateEmployee(employeeId, petStoreId);

		// Convert PetStoreEmployee object from request body to an Employee object
		copyEmployeeFields(employee, petStoreEmployee);

		// Set the employee's store to petStore
		employee.setPetStore(petStore);

		// Add the employee to the petStore's Set of employees
		petStore.getEmployees().add(employee);

		// Save the employee and convert Employee object to PetStoreEmployee object
		return new PetStoreEmployee(employeeDao.save(employee));
	}

	/**
	 * Find an Employee object if one exists, otherwise create a new Employee
	 * 
	 * @param employeeId
	 * @param petStoreId
	 * @return
	 */
	public Employee findOrCreateEmployee(Long employeeId, Long petStoreId) {

		Employee employee;

		if (Objects.isNull(employeeId)) {
			employee = new Employee();
		} else {
			employee = findEmployeeById(petStoreId, employeeId);
		}

		return employee;
	}

	/**
	 * Lookup an employee by ID, throw no such element exception if not found
	 * 
	 * @param petStoreId
	 * @param employeeId
	 * @return
	 */
	public Employee findEmployeeById(Long petStoreId, Long employeeId) {
		return employeeDao.findById(employeeId)
				.orElseThrow(() -> new NoSuchElementException("Employee with ID=" + employeeId + " not found."));
	}

	/**
	 * Convert the PetStoreEmployee object to an Employee object by copying all of
	 * the fields
	 * 
	 * @param employee
	 * @param petStoreEmployee
	 */
	private void copyEmployeeFields(Employee employee, PetStoreEmployee petStoreEmployee) {
		employee.setEmployeeId(petStoreEmployee.getEmployeeId());
		employee.setEmployeeFirstName(petStoreEmployee.getEmployeeFirstName());
		employee.setEmployeeLastName(petStoreEmployee.getEmployeeLastName());
		employee.setEmployeePhone(petStoreEmployee.getEmployeePhone());
		employee.setEmployeeJobTitle(petStoreEmployee.getEmployeeJobTitle());
	}
}
