package hospital.management.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import hospital.management.enums.Gender;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;


@Entity
public class Patient {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer patientId;
	private String patientName;
	private Integer age;
	@Enumerated(EnumType.STRING)
	private Gender gender;
	@Column(unique=true)
	private Long phone;
	@Column(unique=true)
	private String email;
	
	@OneToMany(mappedBy="patient",cascade=CascadeType.ALL)
	@JsonIgnore
	private List<Appointment> appointments;
	
	@OneToMany(mappedBy="patient",cascade=CascadeType.ALL)
	@JsonIgnore
	private List<MedicalRecord> records;

	public List<MedicalRecord> getRecords() {
		return records;
	}
	public void setRecords(List<MedicalRecord> records) {
		this.records = records;
	}
	public List<Appointment> getAppointments() {
		return appointments;
	}
	public void setAppointments(List<Appointment> appointments) {
		this.appointments = appointments;
	}
	public Integer getPatientId() {
		return patientId;
	}
	public void setPatientId(Integer patientId) {
		this.patientId = patientId;
	}
	public String getPatientName() {
		return patientName;
	}
	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public Gender getGender() {
		return gender;
	}
	public void setGender(Gender gender) {
		this.gender = gender;
	}
	public Long getPhone() {
		return phone;
	}
	public void setPhone(Long phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	

}
