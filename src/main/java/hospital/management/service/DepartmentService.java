package hospital.management.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import hospital.management.dao.DepartmentDao;
import hospital.management.dto.ResponseStructure;
import hospital.management.entity.Department;
import hospital.management.exception.IdNotFoundException;
import hospital.management.exception.NoRecordAvailableException;



@Service
public class DepartmentService {
	
	@Autowired
	private DepartmentDao deptDao;
	
	public ResponseStructure<Department> saveDept(Department dept){
		ResponseStructure<Department> response=new ResponseStructure();
		response.setStatusCode(HttpStatus.CREATED.value());
		response.setMessage("department record is inserted");
		response.setData(deptDao.saveDept(dept));
		return response;
	}
	
	public ResponseStructure<List<Department>> getAllDept(){
		ResponseStructure<List<Department>> response=new ResponseStructure();
		response.setStatusCode(HttpStatus.OK.value());
		response.setMessage("department records is fetched");
		response.setData(deptDao.getAllDept());
		return response;
	}
	
	public ResponseStructure<Department> findDeptById(Integer id){
		ResponseStructure<Department> response=new ResponseStructure();
		Optional<Department> dept=deptDao.findDeptById(id);
		if(!dept.isEmpty()) {
			response.setStatusCode(HttpStatus.OK.value());
			response.setMessage("department record is fetched by id");
			response.setData(dept.get());
			return response;
		}else {
			throw new IdNotFoundException("id not found");
		}	
	}
	
	public ResponseStructure<Department> updateDept(Department dept){
		ResponseStructure<Department> response=new ResponseStructure();
		if(dept.getDeptId()==null) {
			throw new IdNotFoundException("enter the id");
		}
		
		Optional<Department> opt=deptDao.findDeptById(dept.getDeptId());
		if(!opt.isEmpty()) {
			response.setStatusCode(HttpStatus.OK.value());
			response.setMessage("department record is updated");
			response.setData(deptDao.saveDept(dept));
			return response;
		}else {
			throw new IdNotFoundException("id not found");
		}	
	}
	
	public ResponseStructure<String> deleteDeptById(Integer id){
		ResponseStructure<String> response=new ResponseStructure();
		Optional<Department> opt=deptDao.findDeptById(id);
		if(!opt.isEmpty()) {
			deptDao.deleteDept(id);
			response.setStatusCode(HttpStatus.OK.value());
			response.setMessage("department record is deleted");
			response.setData("success");
			return response;
		}else {
			throw new IdNotFoundException("id not found");
		}	
	}
	
	public ResponseStructure<Department> findByDeptName(String name){
		ResponseStructure<Department> response=new ResponseStructure();
		Optional<Department> opt=deptDao.findBydeptName(name);
		if(!opt.isEmpty()) {
			response.setStatusCode(HttpStatus.OK.value());
			response.setMessage("department record is fetched by name");
			response.setData(opt.get());
			return response;
		}else {
			throw new NoRecordAvailableException("no record found");
		}	
	}

}
