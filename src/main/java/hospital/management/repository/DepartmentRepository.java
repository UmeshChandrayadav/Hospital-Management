package hospital.management.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import hospital.management.entity.Department;



public interface DepartmentRepository extends JpaRepository<Department,Integer>{
	
	Optional<Department> findByDeptName(String name);

}
