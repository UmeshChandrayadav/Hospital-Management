package hospital.management.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import hospital.management.entity.Patient;



public interface PatientRepository extends JpaRepository<Patient,Integer>{
	
	Optional<Patient> findPatientByPhone(Long phno);
	
	List<Patient> findPatientByAgeGreaterThan(Integer age);
	
	List<Patient> findByAppointmentsAppointmentId(Integer id);
	
	List<Patient> findByRecordsRecordId(Integer id);

}
