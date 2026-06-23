package hospital.management.controller;

import java.time.LocalDate;
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
import hospital.management.entity.MedicalRecord;
import hospital.management.service.MedicalRecordService;



@RestController
@RequestMapping("/medicalRecord")
public class MedicalRecordController {
	
	@Autowired
	private MedicalRecordService medicalRecordService;
	
	@PostMapping
	public ResponseEntity<ResponseStructure<MedicalRecord>> saveMedicalRecord(@RequestBody MedicalRecord medicalRecord){
		return new ResponseEntity<ResponseStructure<MedicalRecord>>(medicalRecordService.saveRecord(medicalRecord),HttpStatus.CREATED);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<ResponseStructure<MedicalRecord>> findByRecordId(@PathVariable Integer id){
		return new ResponseEntity<ResponseStructure<MedicalRecord>>(medicalRecordService.findByRecordId(id),HttpStatus.OK);
	}
	
	@GetMapping("/patient/{id}")
	public ResponseEntity<ResponseStructure<List<MedicalRecord>>> findByRecordPatientId(@PathVariable Integer id){
		return new ResponseEntity<ResponseStructure<List<MedicalRecord>>>(medicalRecordService.findByRecordPatientId(id),HttpStatus.OK);
	}
	
	@GetMapping("/doctor/{id}")
	public ResponseEntity<ResponseStructure<List<MedicalRecord>>> findByRecordDoctorId(@PathVariable Integer id){
		return new ResponseEntity<ResponseStructure<List<MedicalRecord>>>(medicalRecordService.findByRecordDoctorId(id),HttpStatus.OK);
	}
	
	@GetMapping("/appointment/{id}")
	public ResponseEntity<ResponseStructure<List<MedicalRecord>>> findByRecordAppointmentId(@PathVariable Integer id){
		return new ResponseEntity<ResponseStructure<List<MedicalRecord>>>(medicalRecordService.findByRecordAppointmentId(id),HttpStatus.OK);
	}
	
	@GetMapping("/visitDate/{date}")
	public ResponseEntity<ResponseStructure<List<MedicalRecord>>> findByRecordVisitDate(@PathVariable LocalDate date){
		return new ResponseEntity<ResponseStructure<List<MedicalRecord>>>(medicalRecordService.findByRecordVisitDate(date),HttpStatus.OK);
	}

}
