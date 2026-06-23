package hospital.management.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import hospital.management.entity.Doctor;
import hospital.management.repository.DoctorRepository;



@Repository
public class DoctorDao {
	
	@Autowired
	private DoctorRepository doctorRepository;
	
	public Doctor saveDoctor(Doctor doctor) {
		return doctorRepository.save(doctor);
	}
	
	public List<Doctor> getAllDoctors() {
		return doctorRepository.findAll();
	}
	
	public Optional<Doctor> findDoctorById(Integer id){
		return doctorRepository.findById(id);
	}
	
	public List<Doctor> findDoctorBySpecialization(String specialization){
		return doctorRepository.findDoctorBySpecialization(specialization);
	}
	
	public List<Doctor> findDoctorByDepartmentDeptId(Integer deptId){
		return doctorRepository.findDoctorByDepartmentDeptId(deptId);
	}
	
	public List<Doctor> findByDoctorPatientId(Integer Id){
		return doctorRepository.findByAppointmentsPatientPatientId(Id);
	}
	
	public List<Doctor> findByDoctorAppointmentId(Integer Id){
		return doctorRepository.findByAppointmentsAppointmentId(Id);
	}
	
	public List<Doctor> findDoctorByAvailableDays(String availableDays){
		return doctorRepository.findDoctorByAvailableDays(availableDays);
	}
	
	public void deleteDoctorById(Integer doctId) {
		doctorRepository.deleteById(doctId);
	}

}
