package hospital.management.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import hospital.management.dao.MedicalRecordDao;
import hospital.management.dao.PrescriptionDao;
import hospital.management.dto.ResponseStructure;
import hospital.management.entity.MedicalRecord;
import hospital.management.entity.Prescription;
import hospital.management.exception.IdNotFoundException;
import hospital.management.exception.NoRecordAvailableException;



@Service
public class PrescriptionService {
	
	@Autowired
	private PrescriptionDao prescriptionDao;
	@Autowired
	private MedicalRecordDao medicalRecordDao;
	
	public ResponseStructure<Prescription> savePrescription(Prescription prescription){
		ResponseStructure<Prescription> response=new ResponseStructure();
		
		Optional<MedicalRecord> prescriptions=medicalRecordDao.findByRecordId(prescription.getMedicalRecord().getRecordId());
		
		if(!prescriptions.isEmpty()) {
			response.setStatusCode(HttpStatus.CREATED.value());
			response.setMessage("prescription is inserted");
			response.setData(prescriptionDao.savePrescription(prescription));
			return response;
		}else {
			throw new NoRecordAvailableException("record is not exist");
		}
	}
	
	public ResponseStructure<List<Prescription>> getAllPrescription(){
		ResponseStructure<List<Prescription>> response=new ResponseStructure();
		response.setStatusCode(HttpStatus.OK.value());
		response.setMessage("fetched all the records");
		response.setData(prescriptionDao.getAllPrescription());
		return response;
	}
	
	public ResponseStructure<Prescription> findByPrescriptionId(Integer id){
		ResponseStructure<Prescription> response=new ResponseStructure();
		
		Optional<Prescription> opt=prescriptionDao.findByPrescriptionId(id);
		if(opt.isPresent()) {
			response.setStatusCode(HttpStatus.OK.value());
			response.setMessage("fetched all the records");
			response.setData(opt.get());
			return response;
		}else {
			throw new IdNotFoundException("id not found");
		}
	}
	
	public ResponseStructure<List<Prescription>> findByMedicalRecordId(Integer id){
		ResponseStructure<List<Prescription>> response=new ResponseStructure();
		
		List<Prescription> opt=prescriptionDao.findByMedicalRecordId(id);
		if(!opt.isEmpty()) {
			response.setStatusCode(HttpStatus.OK.value());
			response.setMessage("fetched all the records");
			response.setData(opt);
			return response;
		}else {
			throw new IdNotFoundException("id not found");
		}
	}
	
	public ResponseStructure<List<Prescription>> findByPrescriptionPatientId(Integer id){
		ResponseStructure<List<Prescription>> response=new ResponseStructure();
		
		List<Prescription> opt=prescriptionDao.findByPrescriptionPatientId(id);
		if(!opt.isEmpty()) {
			response.setStatusCode(HttpStatus.OK.value());
			response.setMessage("fetched all the records");
			response.setData(opt);
			return response;
		}else {
			throw new IdNotFoundException("id not found");
		}
	}

}
