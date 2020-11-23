package net.javaguides.SpringBoot.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import net.javaguides.SpringBoot.model.Unidad;

@Service
public interface EmployeeService {
	
	List<Unidad> getAllEmployees();
	void saveEmployee(Unidad unidad);
	Unidad getEmployeeById(long id);	
	void deleteEmployeeById(Long id);
	Page<Unidad> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection);
	
}
