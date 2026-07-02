package hospital.management.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import hospital.management.entity.Doctor;



public interface DoctorRepository extends JpaRepository<Doctor,Integer>{
	
	List<Doctor> findDoctorBySpecialization(String specialization);
	
	List<Doctor> findDoctorByDepartmentDeptId(Integer deptId);
	
	List<Doctor> findByAppointmentsPatientPatientId(Integer id);
	
	List<Doctor> findByAppointmentsAppointmentId(Integer id);
	
	@Query(value="select * from doctor d where :day=ANY(string_to_array(d.available_days,','))",nativeQuery=true)
	List<Doctor> findDoctorByAvailableDays(@Param("day") String availableDays);

}
