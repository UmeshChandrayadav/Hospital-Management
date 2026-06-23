package hospital.management.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import hospital.management.entity.Patient;
import hospital.management.repository.*;

@Repository
public class PatientDao {
	
	@Autowired
	private PatientRepository patientRepository;
	
	public Patient savePatient(Patient patient) {
		return patientRepository.save(patient);
	}
	
	public List<Patient> getAllPatient() {
		return patientRepository.findAll();
	}
	
	public Optional<Patient> findPatientById(Integer id){
		return patientRepository.findById(id);
	}
	
	public Optional<Patient> findPatientByPhone(Long phno){
		return patientRepository.findPatientByPhone(phno);
	}
	
	public List<Patient> findPatientByAgeGreaterThan(Integer age){
		return patientRepository.findPatientByAgeGreaterThan(age);
	}
	
	public List<Patient> findPatientByAppointmentId(Integer id){
		return patientRepository.findByAppointmentsAppointmentId(id);
	}
	
	public List<Patient> findPatientByRecordId(Integer id){
		return patientRepository.findByRecordsRecordId(id);
	}
	
	public void deletePatientById(Integer id){
		patientRepository.deleteById(id);
	}

}
