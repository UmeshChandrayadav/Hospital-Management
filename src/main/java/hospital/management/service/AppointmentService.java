package hospital.management.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import hospital.management.dao.AppointmentDao;
import hospital.management.dto.ResponseStructure;
import hospital.management.entity.Appointment;
import hospital.management.exception.IdNotFoundException;
import hospital.management.exception.NoRecordAvailableException;
import hospital.management.exception.SlotUnavailableException;
import hospital.management.enums.Status;



@Service
public class AppointmentService {
	
	@Autowired
	private AppointmentDao appointmentDao;
	
	public ResponseStructure<Appointment> saveAppointment(Appointment appointment){
		ResponseStructure<Appointment> response=new ResponseStructure();
		
		List<Appointment> appointments=appointmentDao.getAllAppointment();
		boolean flag=true;
		for(Appointment a:appointments) {
			if(a.getPatient().getPatientId().equals(appointment.getPatient().getPatientId())) {
				if(a.getDateTime().toLocalDate().equals(appointment.getDateTime().toLocalDate())) {
					flag=false;
					break;
				}
			}
			if(a.getDoctor().getDoctorId().equals(appointment.getDoctor().getDoctorId())) {
				if(a.getDateTime().equals(appointment.getDateTime())) {
					flag=false;
					break;
				}
			}
		}
		if(flag==true) {
			response.setStatusCode(HttpStatus.CREATED.value());
			response.setMessage("appointment is booked");
			response.setData(appointmentDao.saveAppointment(appointment));
			return response;
		}else {
			throw new SlotUnavailableException("this time not available, it is filled change your time slot");
		}
	}
	
	public ResponseStructure<List<Appointment>> getAllAppointments(){
		ResponseStructure<List<Appointment>> response=new ResponseStructure();
		response.setStatusCode(HttpStatus.OK.value());
		response.setMessage("all appointment records fetched");
		response.setData(appointmentDao.getAllAppointment());
		return response;
	}
	
	public ResponseStructure<Appointment> findByAppointmentId(Integer id){
		ResponseStructure<Appointment> response=new ResponseStructure();
		Optional<Appointment> opt=appointmentDao.findByAppointmentId(id);
		if(!opt.isEmpty()) {
			response.setStatusCode(HttpStatus.OK.value());
			response.setMessage("appointment record fetched by id");
			response.setData(opt.get());
			return response;
		}else {
			throw new IdNotFoundException("id not found");
		}
		
	}
	
	public ResponseStructure<List<Appointment>> findByAppointmentDateTime(LocalDateTime dateTime){
		ResponseStructure<List<Appointment>> response=new ResponseStructure();
		List<Appointment> appointment=appointmentDao.findByAppointmentDateTime(dateTime);
		if(!appointment.isEmpty()) {
			response.setStatusCode(HttpStatus.OK.value());
			response.setMessage("all appointment records fetched by dateTime");
			response.setData(appointment);
			return response;
		}else {
			throw new NoRecordAvailableException("record not found");
		}
		
	}
	
	public ResponseStructure<List<Appointment>> findByAppointmentDoctorId(Integer id){
		ResponseStructure<List<Appointment>> response=new ResponseStructure();
		List<Appointment> appointment=appointmentDao.findByAppointmentDoctorId(id);
		if(!appointment.isEmpty()) {
			response.setStatusCode(HttpStatus.OK.value());
			response.setMessage("all appointment records fetched by doctor id");
			response.setData(appointment);
			return response;
		}else {
			throw new NoRecordAvailableException("record not found");
		}
		
	}
	
	public ResponseStructure<List<Appointment>> findByAppointmentPatientId(Integer id){
		ResponseStructure<List<Appointment>> response=new ResponseStructure();
		List<Appointment> appointment=appointmentDao.findByAppointmentPatientId(id);
		if(!appointment.isEmpty()) {
			response.setStatusCode(HttpStatus.OK.value());
			response.setMessage("all appointment records fetched by patient id");
			response.setData(appointment);
			return response;
		}else {
			throw new NoRecordAvailableException("record not found");
		}
		
	}
	
	public ResponseStructure<List<Appointment>> findByAppointmentStatus(Status status){
		ResponseStructure<List<Appointment>> response=new ResponseStructure();
		List<Appointment> appointment=appointmentDao.findByAppointmentStatus(status);
		if(!appointment.isEmpty()) {
			response.setStatusCode(HttpStatus.OK.value());
			response.setMessage("all appointment records fetched by status");
			response.setData(appointment);
			return response;
		}else {
			throw new NoRecordAvailableException("record not found");
		}
		
	}
	
	public ResponseStructure<String> deleteByAppointmentId(Integer id){
		ResponseStructure<String> response=new ResponseStructure();
		Optional<Appointment> appointment=appointmentDao.findByAppointmentId(id);
		if(!appointment.isEmpty()) {
			appointmentDao.deleteByAppointmentId(id);
			response.setStatusCode(HttpStatus.OK.value());
			response.setMessage("appointment records deleted by id");
			response.setData("success");
			return response;
		}else {
			throw new NoRecordAvailableException("record not found");
		}
		
	}
	
	public ResponseStructure<Appointment> updateAppointment(Appointment appointment){
		ResponseStructure<Appointment> response=new ResponseStructure();
		if(appointment.getAppointmentId()==null) {
			throw new IdNotFoundException("enter the id");
		}
		
		Optional<Appointment> opt=appointmentDao.findByAppointmentId(appointment.getAppointmentId());
		List<Appointment> appointments=appointmentDao.getAllAppointment();
		boolean flag=true;
		if(!opt.isEmpty()) {
			for(Appointment a:appointments) {
				if(!a.getAppointmentId().equals(appointment.getAppointmentId())) {
					if(a.getPatient().getPatientId().equals(appointment.getPatient().getPatientId())) {
						if(a.getDateTime().toLocalDate().equals(appointment.getDateTime().toLocalDate())) {
							flag=false;
							break;
						}
					}
					if(a.getDoctor().getDoctorId().equals(appointment.getDoctor().getDoctorId())) {
						if(a.getDateTime().equals(appointment.getDateTime())) {
							flag=false;
							break;
						}
					}
				}
			}
			if(flag==true) {
				response.setStatusCode(HttpStatus.OK.value());
				response.setMessage("appointment is booked");
				response.setData(appointmentDao.saveAppointment(appointment));
				return response;
			}else {
				throw new SlotUnavailableException("this time not available, it is filled change your time slot");
			}
		}else {
			throw new IdNotFoundException("id not found");
		}
	}

}
