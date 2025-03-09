/**
 * 
 */
package pet.store.service;

import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;

import pet.store.controller.model.PetStoreData;
import pet.store.controller.model.PetStoreData.PetStoreCustomer;
import pet.store.controller.model.PetStoreData.PetStoreEmployee;
import pet.store.dao.CustomerDao;
import pet.store.dao.EmployeeDao;
import pet.store.dao.PetStoreDao;
import pet.store.entity.Customer;
import pet.store.entity.Employee;
import pet.store.entity.PetStore;

@Service
public class PetStoreService {
	@Autowired
	private PetStoreDao petStoreDao;
	@Autowired
	private EmployeeDao employeeDao;
	@Autowired
	private CustomerDao customerDao;

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

		// Copy the fields from the request body to an Employee object
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
		Employee employee = employeeDao.findById(employeeId)
				.orElseThrow(() -> new NoSuchElementException("Employee with ID=" + employeeId + " not found."));

		if (employee.getPetStore().getPetStoreId() != petStoreId) {
			throw new IllegalArgumentException(
					"Employee with ID=" + employeeId + " was not found at pet store ID=" + petStoreId + ".");
		}

		return employee;
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

	/**
	 * @param petStoreId
	 * @param petStoreCustomer
	 * @return
	 */
	@Transactional(readOnly = false)
	public PetStoreCustomer saveCustomer(Long petStoreId, PetStoreCustomer petStoreCustomer) {
		PetStore petStore = findPetStoreById(petStoreId);
		Long customerId = petStoreCustomer.getCustomerId();
		Customer customer = findOrCreateCustomer(customerId, petStoreId);

		// Copy the fields from the request body to a PetStoreCustomer object
		copyCustomerFields(customer, petStoreCustomer);
		
		// Associate the customer with the store
		customer.getPetStores().add(petStore);
		// Associate the store with the customer
		petStore.getCustomers().add(customer);

		return new PetStoreCustomer(customerDao.save(customer));
	}

	/**
	 * Find an existing Customer using customer ID and pet store ID, otherwise
	 * create a new Customer
	 * 
	 * @param customerId
	 * @param petStoreId
	 * @return
	 */
	public Customer findOrCreateCustomer(Long customerId, Long petStoreId) {
		Customer customer;

		if (Objects.isNull(customerId)) {
			customer = new Customer();
		} else {
			customer = findCustomerById(customerId, petStoreId);
		}
		return customer;
	}

	/**
	 * Find a customer using a customer ID and pet store ID
	 * 
	 * @param customerId
	 * @param petStoreId
	 * @return
	 */
	public Customer findCustomerById(Long customerId, Long petStoreId) {
		Customer customer = customerDao.findById(customerId)
				.orElseThrow(() -> new NoSuchElementException("Customer with ID=" + customerId + " does not exist."));

		/**
		 * Check if the customer is associated with any pet stores that match the
		 * petStoreId that was passed as an argument
		 */
		for (PetStore petStore : customer.getPetStores()) {
			if (petStore.getPetStoreId() != petStoreId) {
				throw new IllegalArgumentException(
						"Customer with ID=" + customerId + " is not associated with store ID=" + petStoreId + ".");
			}
		}

		return customer;
	}

	private void copyCustomerFields(Customer customer, PetStoreCustomer petStoreCustomer) {
		customer.setCustomerId(petStoreCustomer.getCustomerId());
		customer.setCustomerFirstName(petStoreCustomer.getCustomerFirstName());
		customer.setCustomerLastName(petStoreCustomer.getCustomerLastName());
		customer.setCustomerEmail(petStoreCustomer.getCustomerEmail());
	}

	/**
	 * @return
	 */
	@Transactional(readOnly = true)
	public List<PetStoreData> retrieveAllPetStores() {
		List<PetStore> petStores = petStoreDao.findAll();

		List<PetStoreData> petStoreDataResults = new LinkedList<>();

		// Loop through PetStore entities and add them to the List of PetStoreData
		for (PetStore petStore : petStores) {
			PetStoreData petStoreData = new PetStoreData(petStore);

			// Remove customers from List of Pet Store Data
			petStoreData.getCustomers().clear();
			// Remove employees from List of Pet Store Data
			petStoreData.getEmployees().clear();

			// Add the store data to the List now that customer
			// and employee data has been removed
			petStoreDataResults.add(petStoreData);
		}

		return petStoreDataResults;
	}

	/**
	 * @param petStoreId
	 * @return
	 */
	@Transactional(readOnly = true)
	public PetStoreData retrievePetStoreById(Long petStoreId) {
		PetStoreData petStoreData = new PetStoreData(findPetStoreById(petStoreId));
		
		// Remove customer and employee data from results
		petStoreData.getCustomers().clear();
		petStoreData.getEmployees().clear();
		
		return petStoreData;
	}

	/**
	 * @param petStoreId
	 */
	public void deletePetStoreById(Long petStoreId) {
		petStoreDao.delete(findPetStoreById(petStoreId));
	}
	
}
