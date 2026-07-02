package hospital.management.repository;



import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import hospital.management.entity.MedicalRecord;



public interface MedicalRecordRepository extends JpaRepository<MedicalRecord, Integer>{
	
	List<MedicalRecord> findByPatientPatientId(Integer patientId);
	
	List<MedicalRecord> findByDoctorDoctorId(Integer doctorId);
	
	List<MedicalRecord> findByPatientAppointmentsAppointmentId(Integer appointmentId);
	
	List<MedicalRecord> findByVisitDate(LocalDate date);

}
