package hospital.management.repository;


import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import hospital.management.entity.Appointment;

import hospital.management.enums.Status;

public interface AppointmentRepository extends JpaRepository<Appointment,Integer>{
	
	List<Appointment> findByDateTime(LocalDateTime dateTime);
	
	List<Appointment> findByDoctorDoctorId(Integer doctid);
	
	List<Appointment> findByPatientPatientId(Integer patientId);
	
	List<Appointment> findByStatus(Status status);

}
