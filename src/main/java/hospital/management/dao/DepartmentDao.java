package hospital.management.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import hospital.management.entity.Department;
import hospital.management.repository.DepartmentRepository;



@Repository
public class DepartmentDao {
	
	@Autowired
	private DepartmentRepository deptRepository;
	
	public Department saveDept(Department dept) {
		return deptRepository.save(dept);
	}
	
	public List<Department> getAllDept(){
		return deptRepository.findAll();
	}
	
	public Optional<Department> findDeptById(Integer id) {
		return deptRepository.findById(id);
	}
	
	public void deleteDept(Integer id) {
		deptRepository.deleteById(id);
	}
	
	public Optional<Department> findBydeptName(String name) {
		return deptRepository.findByDeptName(name);
	}

}
