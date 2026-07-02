package hospital.management.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import hospital.management.dao.AppointmentDao;
import hospital.management.dao.MedicalRecordDao;
import hospital.management.dao.PatientDao;
import hospital.management.dto.ResponseStructure;
import hospital.management.entity.Appointment;
import hospital.management.entity.MedicalRecord;
import hospital.management.entity.Patient;
import hospital.management.enums.Status;
import hospital.management.exception.IdNotFoundException;
import hospital.management.exception.NoRecordAvailableException;


@Service
public class MedicalRecordService {
	
	@Autowired
	private MedicalRecordDao medicalRecordDao;
	@Autowired
	private PatientDao patientDao;
	@Autowired
	private AppointmentDao appointmentDao;
	
	public ResponseStructure<MedicalRecord> saveRecord(MedicalRecord medicalRecord){
		ResponseStructure<MedicalRecord> response=new ResponseStructure();
		
		Optional<Patient> opt=patientDao.findPatientById(medicalRecord.getPatient().getPatientId());

		
		if(!opt.isEmpty()) {
			List<Appointment> appointments=appointmentDao.findByAppointmentPatientId(opt.get().getPatientId());
			if(!appointments.isEmpty()) {
				boolean flag=false;
				for(Appointment a:appointments) {
					if(a.getStatus()==Status.COMPLETED) {
						flag=true;
						break;
					}
				}
				if(flag==true) {
					response.setStatusCode(HttpStatus.CREATED.value());
					response.setMessage("medical record inserted");
					response.setData(medicalRecordDao.saveRecord(medicalRecord));
					return response;
				}else {
					throw new NoRecordAvailableException("no record status is completed ");
				}
			}else {
				throw new NoRecordAvailableException("records not available");
			}
		}else {
			throw new IdNotFoundException("id not found");
		}
	}
	
	public ResponseStructure<MedicalRecord> findByRecordId(Integer id){
		ResponseStructure<MedicalRecord> response=new ResponseStructure();
		
		Optional<MedicalRecord> opt=medicalRecordDao.findByRecordId(id);
		if(!opt.isEmpty()) {
			response.setStatusCode(HttpStatus.OK.value());
			response.setMessage("record fetched by id");
			response.setData(opt.get());
			return response;
		}else {
			throw new IdNotFoundException("id not found");
		}
	}
	
	public ResponseStructure<List<MedicalRecord>> findByRecordPatientId(Integer id){
		ResponseStructure<List<MedicalRecord>> response=new ResponseStructure();
		
		List<MedicalRecord> records=medicalRecordDao.findByRecordPatientId(id);
		if(!records.isEmpty()) {
			response.setStatusCode(HttpStatus.OK.value());
			response.setMessage("record fetched by id");
			response.setData(records);
			return response;
		}else {
			throw new IdNotFoundException("id not found");
		}
	}
	
	public ResponseStructure<List<MedicalRecord>> findByRecordDoctorId(Integer id){
		ResponseStructure<List<MedicalRecord>> response=new ResponseStructure();
		
		List<MedicalRecord> records=medicalRecordDao.findByRecordDoctorId(id);
		if(!records.isEmpty()) {
			response.setStatusCode(HttpStatus.OK.value());
			response.setMessage("record fetched by id");
			response.setData(records);
			return response;
		}else {
			throw new IdNotFoundException("id not found");
		}
	}
	
	public ResponseStructure<List<MedicalRecord>> findByRecordAppointmentId(Integer id){
		ResponseStructure<List<MedicalRecord>> response=new ResponseStructure();
		
		List<MedicalRecord> records=medicalRecordDao.findByRecordAppointmentId(id);
		if(!records.isEmpty()) {
			response.setStatusCode(HttpStatus.OK.value());
			response.setMessage("record fetched by id");
			response.setData(records);
			return response;
		}else {
			throw new IdNotFoundException("id not found");
		}
	}
	
	public ResponseStructure<List<MedicalRecord>> findByRecordVisitDate(LocalDate date){
		ResponseStructure<List<MedicalRecord>> response=new ResponseStructure();
		
		List<MedicalRecord> records=medicalRecordDao.findByRecordVisitDate(date);
		if(!records.isEmpty()) {
			response.setStatusCode(HttpStatus.OK.value());
			response.setMessage("record fetched by id");
			response.setData(records);
			return response;
		}else {
			throw new NoRecordAvailableException("records not found");
		}
	}

}
