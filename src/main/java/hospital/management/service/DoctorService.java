package hospital.management.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import hospital.management.dao.DoctorDao;
import hospital.management.dto.ResponseStructure;
import hospital.management.entity.Doctor;
import hospital.management.exception.IdNotFoundException;
import hospital.management.exception.NoRecordAvailableException;



@Service
public class DoctorService {
	
	@Autowired
	private DoctorDao doctorDao;
	
	public ResponseStructure<Doctor> saveDoctor(Doctor doctor){
		ResponseStructure<Doctor> response=new ResponseStructure();
		response.setStatusCode(HttpStatus.CREATED.value());
		response.setMessage("doctor record is inserted");
		response.setData(doctorDao.saveDoctor(doctor));
		return response;
	}
	
	public ResponseStructure<List<Doctor>> getAllDoctors(){
		ResponseStructure<List<Doctor>> response=new ResponseStructure();
		response.setStatusCode(HttpStatus.OK.value());
		response.setMessage("doctor records is fetched");
		response.setData(doctorDao.getAllDoctors());
		return response;
	}
	
	public ResponseStructure<Doctor> findDoctorById(Integer id){
		ResponseStructure<Doctor> response=new ResponseStructure();
		
		Optional<Doctor> doctor=doctorDao.findDoctorById(id);
		if(!doctor.isEmpty()) {
			response.setStatusCode(HttpStatus.OK.value());
			response.setMessage("doctor records is fetched id");
			response.setData(doctor.get());
			return response;
		}else {
			throw new IdNotFoundException("id not found");
		}
	}
	
	public ResponseStructure<List<Doctor>> findDoctorBySpecialization(String specialization){
		ResponseStructure<List<Doctor>> response=new ResponseStructure();
		
		List<Doctor> doctors=doctorDao.findDoctorBySpecialization(specialization);
		if(doctors.size()>0) {
			response.setStatusCode(HttpStatus.OK.value());
			response.setMessage("doctor records is fetched by specialization");
			response.setData(doctors);
			return response;
		}else {
			throw new NoRecordAvailableException("records not found");
		}
	}
	
	public ResponseStructure<List<Doctor>> findDoctorByDepartmentDeptId(Integer deptId){
		ResponseStructure<List<Doctor>> response=new ResponseStructure();
		
		List<Doctor> doctors=doctorDao.findDoctorByDepartmentDeptId(deptId);
		if(doctors.size()>0) {
			response.setStatusCode(HttpStatus.OK.value());
			response.setMessage("doctor records is fetched by department");
			response.setData(doctors);
			return response;
		}else {
			throw new NoRecordAvailableException("records not found");
		}
	}
	
	public ResponseStructure<List<Doctor>> findDoctorByPatientId(Integer Id){
		ResponseStructure<List<Doctor>> response=new ResponseStructure();
		
		List<Doctor> doctors=doctorDao.findByDoctorPatientId(Id);
		if(!doctors.isEmpty()) {
			response.setStatusCode(HttpStatus.OK.value());
			response.setMessage("doctor records is fetched by department");
			response.setData(doctors);
			return response;
		}else {
			throw new NoRecordAvailableException("records not found");
		}
	}
	
	public ResponseStructure<List<Doctor>> findDoctorByAppointmentId(Integer Id){
		ResponseStructure<List<Doctor>> response=new ResponseStructure();
		
		List<Doctor> doctors=doctorDao.findByDoctorAppointmentId(Id);
		if(!doctors.isEmpty()) {
			response.setStatusCode(HttpStatus.OK.value());
			response.setMessage("doctor records is fetched by department");
			response.setData(doctors);
			return response;
		}else {
			throw new NoRecordAvailableException("records not found");
		}
	}
	
	public ResponseStructure<List<Doctor>> findDoctorByAvailableDays(String availableDays){
		ResponseStructure<List<Doctor>> response=new ResponseStructure();
		
		List<Doctor> doctors=doctorDao.findDoctorByAvailableDays(availableDays);
		if(doctors.size()>0) {
			response.setStatusCode(HttpStatus.OK.value());
			response.setMessage("doctor records is fetched by availableDays");
			response.setData(doctors);
			return response;
		}else {
			throw new NoRecordAvailableException("records not found");
		}
	}
	
	public ResponseStructure<Doctor> updateDoctorInfo(Doctor doctor){
		ResponseStructure<Doctor> response=new ResponseStructure();
		if(doctor.getDoctorId()==null) {
			throw new IdNotFoundException("enter the id");
		}
		
		Optional<Doctor> opt=doctorDao.findDoctorById(doctor.getDoctorId());
		if(!opt.isEmpty()) {
			response.setStatusCode(HttpStatus.OK.value());
			response.setMessage("doctor record is updated");
			response.setData(doctorDao.saveDoctor(doctor));
			return response;
		}else {
			throw new IdNotFoundException("id not found");
		}
	}
	
	public ResponseStructure<String> deleteDoctorById(Integer doctId){
		ResponseStructure<String> response=new ResponseStructure();
		
		Optional<Doctor> opt=doctorDao.findDoctorById(doctId);
		if(!opt.isEmpty()) {
			doctorDao.deleteDoctorById(doctId);
			response.setStatusCode(HttpStatus.OK.value());
			response.setMessage("doctor record is deleted");
			response.setData("success");
			return response;
		}else {
			throw new IdNotFoundException("id not found");
		}
	}

}
