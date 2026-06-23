package hospital.management.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hospital.management.dto.ResponseStructure;
import hospital.management.entity.Department;
import hospital.management.service.DepartmentService;



@RestController
@RequestMapping("/department")
public class DepartmentController {
	
	@Autowired
	private DepartmentService deptService;
	
	@PostMapping
	public ResponseEntity<ResponseStructure<Department>> saveDept(@RequestBody Department dept){
		return new ResponseEntity<ResponseStructure<Department>>(deptService.saveDept(dept), HttpStatus.CREATED);
	}
	
	@GetMapping
	public ResponseEntity<ResponseStructure<List<Department>>> getAllDept(){
		return new ResponseEntity<ResponseStructure<List<Department>>>(deptService.getAllDept(), HttpStatus.CREATED);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<ResponseStructure<Department>> findDeptById(@PathVariable Integer id){
		return new ResponseEntity<ResponseStructure<Department>>(deptService.findDeptById(id), HttpStatus.CREATED);
	}
	
	@PutMapping()
	public ResponseEntity<ResponseStructure<Department>> updateDept(@RequestBody Department dept){
		return new ResponseEntity<ResponseStructure<Department>>(deptService.updateDept(dept), HttpStatus.CREATED);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<ResponseStructure<String>> DeleteDeptById(@PathVariable Integer id){
		return new ResponseEntity<ResponseStructure<String>>(deptService.deleteDeptById(id), HttpStatus.CREATED);
	}
	
	@GetMapping("/name/{name}")
	public ResponseEntity<ResponseStructure<Department>> findByDeptName(@PathVariable String name){
		return new ResponseEntity<ResponseStructure<Department>>(deptService.findByDeptName(name), HttpStatus.CREATED);
	}

}
