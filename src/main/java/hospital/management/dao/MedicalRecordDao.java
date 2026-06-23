package hospital.management.dao;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import hospital.management.entity.MedicalRecord;
import hospital.management.repository.MedicalRecordRepository;



@Repository
public class MedicalRecordDao {
	
	@Autowired
	private MedicalRecordRepository medicalRecordRepository;
	
	public MedicalRecord saveRecord(MedicalRecord medicalRecord) {
		return medicalRecordRepository.save(medicalRecord);
	}
	
	public Optional<MedicalRecord> findByRecordId(Integer id){
		return medicalRecordRepository.findById(id);
	}
	
	public List<MedicalRecord> findByRecordPatientId(Integer id){
		return medicalRecordRepository.findByPatientPatientId(id);
	}
	
	public List<MedicalRecord> findByRecordDoctorId(Integer id){
		return medicalRecordRepository.findByDoctorDoctorId(id);
	}
	
	public List<MedicalRecord> findByRecordAppointmentId(Integer id){
		return medicalRecordRepository.findByPatientAppointmentsAppointmentId(id);
	}
	
	public List<MedicalRecord> findByRecordVisitDate(LocalDate date){
		return medicalRecordRepository.findByVisitDate(date);
	}

}
