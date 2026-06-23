package hospital.management.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import hospital.management.entity.Prescription;



public interface PrescriptionRepository extends JpaRepository<Prescription, Integer>{
	
	List<Prescription> findByMedicalRecordRecordId(Integer id);
	
	List<Prescription> findByMedicalRecordPatientPatientId(Integer id);

}
