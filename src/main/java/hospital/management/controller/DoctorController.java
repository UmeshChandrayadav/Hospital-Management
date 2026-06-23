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
import hospital.management.entity.Doctor;
import hospital.management.service.DoctorService;



@RestController
@RequestMapping("/doctor")
public class DoctorController {
	
	@Autowired
	private DoctorService doctService;
	
	@PostMapping
	public ResponseEntity<ResponseStructure<Doctor>> saveDoctor(@RequestBody Doctor doctor){
		return new ResponseEntity<ResponseStructure<Doctor>>(doctService.saveDoctor(doctor),HttpStatus.CREATED);
	}
	
	@GetMapping
	public ResponseEntity<ResponseStructure<List<Doctor>>> getAllDoctors(){
		return new ResponseEntity<ResponseStructure<List<Doctor>>>(doctService.getAllDoctors(),HttpStatus.OK);
	}
	
	@GetMapping("/id/{id}")
	public ResponseEntity<ResponseStructure<Doctor>> findDoctorById(@PathVariable Integer id){
		return new ResponseEntity<ResponseStructure<Doctor>>(doctService.findDoctorById(id),HttpStatus.OK);
	}
	
	@GetMapping("/specialization/{specialization}")
	public ResponseEntity<ResponseStructure<List<Doctor>>> findDoctorBySpecialization(@PathVariable String specialization){
		return new ResponseEntity<ResponseStructure<List<Doctor>>>(doctService.findDoctorBySpecialization(specialization),HttpStatus.OK);
	}
	
	@GetMapping("department/{deptId}")
	public ResponseEntity<ResponseStructure<List<Doctor>>> findDoctorByDepartmentDeptId(@PathVariable Integer deptId){
		return new ResponseEntity<ResponseStructure<List<Doctor>>>(doctService.findDoctorByDepartmentDeptId(deptId),HttpStatus.OK);
	}
	
	@GetMapping("patient/{id}")
	public ResponseEntity<ResponseStructure<List<Doctor>>> findDoctorByPatientId(@PathVariable Integer id){
		return new ResponseEntity<ResponseStructure<List<Doctor>>>(doctService.findDoctorByPatientId(id),HttpStatus.OK);
	}
	
	@GetMapping("appointment/{id}")
	public ResponseEntity<ResponseStructure<List<Doctor>>> findDoctorByAppointmentId(@PathVariable Integer id){
		return new ResponseEntity<ResponseStructure<List<Doctor>>>(doctService.findDoctorByAppointmentId(id),HttpStatus.OK);
	}
	
	@GetMapping("availableDays/{availableDays}")
	public ResponseEntity<ResponseStructure<List<Doctor>>> findDoctorByAvailableDays(@PathVariable String availableDays){
		return new ResponseEntity<ResponseStructure<List<Doctor>>>(doctService.findDoctorByAvailableDays(availableDays),HttpStatus.OK);
	}
	
	@PutMapping
	public ResponseEntity<ResponseStructure<Doctor>> updateDoctorInfo(@RequestBody Doctor doctor){
		return new ResponseEntity<ResponseStructure<Doctor>>(doctService.updateDoctorInfo(doctor),HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{doctId}")
	public ResponseEntity<ResponseStructure<String>> deleteDoctorById(@PathVariable Integer doctId){
		return new ResponseEntity<ResponseStructure<String>>(doctService.deleteDoctorById(doctId),HttpStatus.OK);
	}

}
