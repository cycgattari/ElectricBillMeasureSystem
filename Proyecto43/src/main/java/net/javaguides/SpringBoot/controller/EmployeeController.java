package net.javaguides.SpringBoot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import net.javaguides.SpringBoot.model.Unidad;
import net.javaguides.SpringBoot.service.EmployeeService;

@Controller
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;
	
	// display list of employees
	@GetMapping("/")
	public String viewHomePage(Model model) { // en el model cargas la lista de empleados
		return findPaginated(1, "nroDeUnidad", "asc", model);	
	}
	
	@GetMapping("/showNewEmployeeForm") // si se pide shownewemployeeform
	public String showNewEmployeeForm(Model model) {
		Unidad employee = new Unidad(); // creas un nuevo objeto
		model.addAttribute("employee", employee); // agregas al modelo un atributo con value y key para usar en save employee 
		return "new_employee"; // el return es el formulario para cargar uno nuevo
	}
	
	@PostMapping("/saveEmployee") // cuando viene un metodo POST con saveemployee
	public String saveEmployee(@ModelAttribute("employee") Unidad employee) { // traes el model atraibuto de arriba valor employee y objeto employee
		employeeService.saveEmployee(employee); // con el service lo salvas en la base de datos
		return "redirect:/showNewEmployeeForm"; // y volver a la pagina ppial
	}
	
	@PostMapping("/saveEmployeeUpt") // cuando viene un metodo POST con saveemployee
	public String saveEmployeeUpt(@ModelAttribute("employee") Unidad employee) { // traes el model atraibuto de arriba valor employee y objeto employee
		employeeService.saveEmployee(employee); // con el service lo salvas en la base de datos
		return "redirect:/"; // y volver a la pagina ppial
	}

	@GetMapping("/showFormForUpdate/{id}")
	public String showFormforUpdate(@PathVariable (value = "id") long id, Model model) {
		Unidad employee = employeeService.getEmployeeById(id);
		model.addAttribute("employee", employee);
		return "update_employee";		
	}
	
	@GetMapping("/deleteEmployee/{id}")
	public String deleteEmployee(@PathVariable (value = "id") long id) {
		employeeService.deleteEmployeeById(id);
		return "redirect:/";
	}
	
	@GetMapping("/page/{pageNo}")
	public String findPaginated(@PathVariable (value = "pageNo") int pageNo,
			@RequestParam("sortField") String sortField,
			@RequestParam("sortDir") String sortDir,
			Model model) {
		
		int pageSize = 5;
		Page<Unidad> page = employeeService.findPaginated(pageNo, pageSize, sortField, sortDir); 
		List<Unidad> listEmployees = page.getContent();
		
		model.addAttribute("currentPage", pageNo);
		model.addAttribute("totalPages", page.getTotalPages());
		model.addAttribute("totalItems", page.getTotalElements());
		
		model.addAttribute("sortField", sortField);
		model.addAttribute("sortDir", sortDir);
		model.addAttribute("reverseSortDir", sortDir.equals("asc") ? "desc" : "asc");	
		
		model.addAttribute("listEmployees", listEmployees);
		return "index";
	}
}
