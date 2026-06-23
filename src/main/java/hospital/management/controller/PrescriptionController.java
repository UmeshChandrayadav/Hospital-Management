package hospital.management.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hospital.management.dto.ResponseStructure;
import hospital.management.entity.Prescription;
import hospital.management.service.PrescriptionService;



@RestController
@RequestMapping("/prescription")
public class PrescriptionController {
	
	@Autowired
	private PrescriptionService prescriptionService;
	
	@PostMapping
	public ResponseEntity<ResponseStructure<Prescription>> savePrescription(@RequestBody Prescription prescription){
		return new ResponseEntity<ResponseStructure<Prescription>>(prescriptionService.savePrescription(prescription),HttpStatus.CREATED);
	}
	
	@GetMapping
	public ResponseEntity<ResponseStructure<List<Prescription>>> getAllPrescription(){
		return new ResponseEntity<ResponseStructure<List<Prescription>>>(prescriptionService.getAllPrescription(),HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<ResponseStructure<Prescription>> findByPrescriptionId(@PathVariable Integer id){
		return new ResponseEntity<ResponseStructure<Prescription>>(prescriptionService.findByPrescriptionId(id),HttpStatus.OK);
	}
	
	@GetMapping("/medicalRecord/{id}")
	public ResponseEntity<ResponseStructure<List<Prescription>>> findByMedicalRecordId(@PathVariable Integer id){
		return new ResponseEntity<ResponseStructure<List<Prescription>>>(prescriptionService.findByMedicalRecordId(id),HttpStatus.OK);
	}
	
	@GetMapping("/patient/{id}")
	public ResponseEntity<ResponseStructure<List<Prescription>>> findByPrescriptionPatientId(@PathVariable Integer id){
		return new ResponseEntity<ResponseStructure<List<Prescription>>>(prescriptionService.findByPrescriptionPatientId(id),HttpStatus.OK);
	}

}
