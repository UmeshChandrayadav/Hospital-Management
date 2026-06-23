package hospital.management.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import hospital.management.dao.PatientDao;
import hospital.management.dto.ResponseStructure;
import hospital.management.entity.Patient;
import hospital.management.exception.IdNotFoundException;
import hospital.management.exception.NoRecordAvailableException;



@Service
public class PatientService {
	
	@Autowired
	private PatientDao patientDao;
	
	public ResponseStructure<Patient> savePatient(Patient patient){
		ResponseStructure<Patient> response=new ResponseStructure();
		response.setStatusCode(HttpStatus.CREATED.value());
		response.setMessage("patient record saved");
		response.setData(patientDao.savePatient(patient));
		return response;
	}
	

	public ResponseStructure<List<Patient>> getAllPatient(){
		ResponseStructure<List<Patient>> response=new ResponseStructure();
		response.setStatusCode(HttpStatus.OK.value());
		response.setMessage("patients records fetched");
		response.setData(patientDao.getAllPatient());
		return response;
	}
	
	public ResponseStructure<Patient> findPatientById(Integer id){
		ResponseStructure<Patient> response=new ResponseStructure();
		Optional<Patient> opt=patientDao.findPatientById(id);
		if(!opt.isEmpty()) {
			response.setStatusCode(HttpStatus.OK.value());
			response.setMessage("patients records fetched by id");
			response.setData(opt.get());
			return response;
		}else {
			throw new IdNotFoundException("id not found");
		}
	}
	
	public ResponseStructure<Patient> findPatientByPhone(Long phno){
		ResponseStructure<Patient> response=new ResponseStructure();
		Optional<Patient> opt=patientDao.findPatientByPhone(phno);
		if(!opt.isEmpty()) {
			response.setStatusCode(HttpStatus.OK.value());
			response.setMessage("patients records fetched by phone number");
			response.setData(opt.get());
			return response;
		}else {
			throw new NoRecordAvailableException("record not found");
		}
	}
	
	public ResponseStructure<List<Patient>> findPatientByAgeGreaterThan(Integer age){
		ResponseStructure<List<Patient>> response=new ResponseStructure();
		List<Patient> patients=patientDao.findPatientByAgeGreaterThan(age);
		if(!patients.isEmpty()) {
			response.setStatusCode(HttpStatus.OK.value());
			response.setMessage("patients records fetched by phone number");
			response.setData(patients);
			return response;
		}else {
			throw new NoRecordAvailableException("record not found");
		}
	}
	
	public ResponseStructure<List<Patient>> findPatientByAppointmentId(Integer id){
		ResponseStructure<List<Patient>> response=new ResponseStructure();
		List<Patient> patients=patientDao.findPatientByAppointmentId(id);
		if(!patients.isEmpty()) {
			response.setStatusCode(HttpStatus.OK.value());
			response.setMessage("patients records fetched by phone number");
			response.setData(patients);
			return response;
		}else {
			throw new NoRecordAvailableException("record not found");
		}
	}
	
	public ResponseStructure<List<Patient>> findPatientByRecordId(Integer id){
		ResponseStructure<List<Patient>> response=new ResponseStructure();
		List<Patient> patients=patientDao.findPatientByRecordId(id);
		if(!patients.isEmpty()) {
			response.setStatusCode(HttpStatus.OK.value());
			response.setMessage("patients records fetched by phone number");
			response.setData(patients);
			return response;
		}else {
			throw new NoRecordAvailableException("record not found");
		}
	}
	
	public ResponseStructure<Patient> updatePatient(Patient patient){
		ResponseStructure<Patient> response=new ResponseStructure();
		if(patient.getPatientId()==null) {
			throw new IdNotFoundException("enter the id");
		}
		
		Optional<Patient> opt=patientDao.findPatientById(patient.getPatientId());
		if(!opt.isEmpty()) {
			response.setStatusCode(HttpStatus.OK.value());
			response.setMessage("updated the patient record");
			response.setData(patientDao.savePatient(patient));
			return response;
		}else {
			throw new IdNotFoundException("id not found");
		}
	}
	
	public ResponseStructure<String> deletePatientById(Integer id){
		ResponseStructure<String> response=new ResponseStructure();
		
		Optional<Patient> opt=patientDao.findPatientById(id);
		if(!opt.isEmpty()) {
			patientDao.deletePatientById(id);
			response.setStatusCode(HttpStatus.OK.value());
			response.setMessage("deleted the patient record by id");
			response.setData("success");
			return response;
		}else {
			throw new IdNotFoundException("id not found");
		}
	}

}
