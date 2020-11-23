package net.javaguides.SpringBoot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import net.javaguides.SpringBoot.model.Unidad;

@Repository
public interface EmployeeRepository extends JpaRepository<Unidad, Long> {
	
}
