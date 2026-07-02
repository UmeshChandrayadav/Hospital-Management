package hospital.management.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hospital.management.dto.ResponseStructure;
import hospital.management.entity.Patient;
import hospital.management.service.PatientService;



@RestController
@RequestMapping("/patient")
public class PatientController {
	
	@Autowired
	private PatientService patientService;
	
	@PostMapping
	public ResponseEntity<ResponseStructure<Patient>> savePatient(@RequestBody Patient patient){
		return new ResponseEntity<ResponseStructure<Patient>>(patientService.savePatient(patient),HttpStatus.CREATED);
	}
	
	@GetMapping
	public ResponseEntity<ResponseStructure<List<Patient>>> getAllPatient(){
		return new ResponseEntity<ResponseStructure<List<Patient>>>(patientService.getAllPatient(),HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<ResponseStructure<Patient>> findPatientById(@PathVariable Integer id){
		return new ResponseEntity<ResponseStructure<Patient>>(patientService.findPatientById(id),HttpStatus.OK);
	}
	
	@GetMapping("/phone/{phno}")
	public ResponseEntity<ResponseStructure<Patient>> findPatientByPhone(@PathVariable Long phno){
		return new ResponseEntity<ResponseStructure<Patient>>(patientService.findPatientByPhone(phno),HttpStatus.OK);
	}
	
	@GetMapping("/age/{age}")
	public ResponseEntity<ResponseStructure<List<Patient>>> findPatientByAgeGreaterThan(@PathVariable Integer age){
		return new ResponseEntity<ResponseStructure<List<Patient>>>(patientService.findPatientByAgeGreaterThan(age),HttpStatus.OK);
	}
	
	@GetMapping("/appointment/{id}")
	public ResponseEntity<ResponseStructure<List<Patient>>> findPatientByAppointmentId(@PathVariable Integer id){
		return new ResponseEntity<ResponseStructure<List<Patient>>>(patientService.findPatientByAppointmentId(id),HttpStatus.OK);
	}
	
	@GetMapping("/medicalRecord/{id}")
	public ResponseEntity<ResponseStructure<List<Patient>>> findPatientByRecordId(@PathVariable Integer id){
		return new ResponseEntity<ResponseStructure<List<Patient>>>(patientService.findPatientByRecordId(id),HttpStatus.OK);
	}
	
	@PutMapping
	public ResponseEntity<ResponseStructure<Patient>> updatePatient(@RequestBody Patient patient){
		return new ResponseEntity<ResponseStructure<Patient>>(patientService.updatePatient(patient),HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<ResponseStructure<String>> deletePatient(@PathVariable Integer id){
		return new ResponseEntity<ResponseStructure<String>>(patientService.deletePatientById(id),HttpStatus.OK);
	}

}
