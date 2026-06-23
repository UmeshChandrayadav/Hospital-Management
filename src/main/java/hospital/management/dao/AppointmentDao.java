package hospital.management.dao;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import hospital.management.entity.Appointment;
import hospital.management.repository.AppointmentRepository;
import hospital.management.enums.Status;


@Repository
public class AppointmentDao {
	
	@Autowired
	private AppointmentRepository appointmentRepository;
	
	public Appointment saveAppointment(Appointment appointment) {
		return appointmentRepository.save(appointment);
	}
	
	public List<Appointment> getAllAppointment(){
		return appointmentRepository.findAll();
	}
	
	public Optional<Appointment> findByAppointmentId(Integer id){
		return appointmentRepository.findById(id);
	}
	
	public List<Appointment> findByAppointmentDateTime(LocalDateTime dateTime){
		return appointmentRepository.findByDateTime(dateTime);
	}
	
	public List<Appointment> findByAppointmentDoctorId(Integer id){
		return appointmentRepository.findByDoctorDoctorId(id);
	}
	
	public List<Appointment> findByAppointmentPatientId(Integer id){
		return appointmentRepository.findByPatientPatientId(id);
	}
	
	public List<Appointment> findByAppointmentStatus(Status status){
		return appointmentRepository.findByStatus(status);
	}
	
	public void deleteByAppointmentId(Integer id){
		appointmentRepository.deleteById(id);
	}

}
