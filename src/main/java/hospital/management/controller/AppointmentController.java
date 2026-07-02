package hospital.management.controller;

import java.time.LocalDateTime;
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
import hospital.management.entity.Appointment;
import hospital.management.service.AppointmentService;
import hospital.management.enums.Status;


@RestController
@RequestMapping("/appointment")
public class AppointmentController {
	
	@Autowired
	private AppointmentService appointmentService;
	
	@PostMapping
	public ResponseEntity<ResponseStructure<Appointment>> saveAppointment(@RequestBody Appointment appointment){
		return new ResponseEntity<ResponseStructure<Appointment>>(appointmentService.saveAppointment(appointment),HttpStatus.CREATED);
	}
	
	@GetMapping
	public ResponseEntity<ResponseStructure<List<Appointment>>> getAllAppointment(){
		return new ResponseEntity<ResponseStructure<List<Appointment>>>(appointmentService.getAllAppointments(),HttpStatus.OK);
	}
	
	@GetMapping("/id/{id}")
	public ResponseEntity<ResponseStructure<Appointment>> findByAppointmentId(@PathVariable Integer id){
		return new ResponseEntity<ResponseStructure<Appointment>>(appointmentService.findByAppointmentId(id),HttpStatus.OK);
	}
	
	@GetMapping("/dateTime/{dateTime}")
	public ResponseEntity<ResponseStructure<List<Appointment>>> findByAppointmentDateTime(@PathVariable LocalDateTime dateTime){
		return new ResponseEntity<ResponseStructure<List<Appointment>>>(appointmentService.findByAppointmentDateTime(dateTime),HttpStatus.OK);
	}
	
	@GetMapping("/doctorId/{id}")
	public ResponseEntity<ResponseStructure<List<Appointment>>> findByAppointmentDoctorId(@PathVariable Integer id){
		return new ResponseEntity<ResponseStructure<List<Appointment>>>(appointmentService.findByAppointmentDoctorId(id),HttpStatus.OK);
	}
	
	@GetMapping("/patientId/{id}")
	public ResponseEntity<ResponseStructure<List<Appointment>>> findByAppointmentPatientId(@PathVariable Integer id){
		return new ResponseEntity<ResponseStructure<List<Appointment>>>(appointmentService.findByAppointmentPatientId(id),HttpStatus.OK);
	}
	
	@GetMapping("/status/{status}")
	public ResponseEntity<ResponseStructure<List<Appointment>>> findByAppointmentStatus(@PathVariable Status status){
		return new ResponseEntity<ResponseStructure<List<Appointment>>>(appointmentService.findByAppointmentStatus(status),HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<ResponseStructure<String>> deleteByAppointmentId(@PathVariable Integer id){
		return new ResponseEntity<ResponseStructure<String>>(appointmentService.deleteByAppointmentId(id),HttpStatus.OK);
	}
	
	@PutMapping
	public ResponseEntity<ResponseStructure<Appointment>> updateAppointment(@RequestBody Appointment appointment){
		return new ResponseEntity<ResponseStructure<Appointment>>(appointmentService.updateAppointment(appointment),HttpStatus.OK);
	}

}
