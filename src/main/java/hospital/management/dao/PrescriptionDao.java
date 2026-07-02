package hospital.management.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import hospital.management.entity.Prescription;
import hospital.management.repository.PrescriptionRepository;



@Repository
public class PrescriptionDao {
	
	@Autowired
	private PrescriptionRepository prescriptionRepository;
	
	public Prescription savePrescription(Prescription prescription) {
		return prescriptionRepository.save(prescription);
	}
	
	public List<Prescription> getAllPrescription(){
		return prescriptionRepository.findAll();
	}
	
	public Optional<Prescription> findByPrescriptionId(Integer id){
		return prescriptionRepository.findById(id);
	}
	
	public List<Prescription> findByMedicalRecordId(Integer id){
		return prescriptionRepository.findByMedicalRecordRecordId(id);
	}
	
	public List<Prescription> findByPrescriptionPatientId(Integer id){
		return prescriptionRepository.findByMedicalRecordPatientPatientId(id);
	}


}
