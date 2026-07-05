🏥 Hospital Management System

A RESTful Hospital Management System built using Spring Boot, Spring Data JPA, Hibernate, and PostgreSQL. The application provides APIs to manage hospital operations such as Patients, Doctors, Departments, Appointments, Medical Records, and Prescriptions.

🚀 Live Demo

API Base URL
https://hospital-management-bsw9.onrender.com/

Swagger API Documentation
https://hospital-management-bsw9.onrender.com/swagger-ui/index.html

---

📌 Features

- Manage Patients
- Manage Doctors
- Manage Departments
- Manage Appointments
- Manage Medical Records
- Manage Prescriptions
- CRUD Operations
- Entity Relationships using JPA/Hibernate
- PostgreSQL Database Integration
- RESTful API Design
- Swagger/OpenAPI Documentation
- Live Deployment on Render
- Environment Variable Configuration
- CORS Configuration

---

🛠 Tech Stack

Backend
- Java 21
- Spring Boot 3
- Spring Data JPA
- Hibernate
- Maven

Database
- PostgreSQL

Documentation
- Swagger UI (OpenAPI 3)

Deployment
- Docker
- Render

---

📂 Project Structure

```
src
├── controller
├── service
├── repository
├── entity
├── dto (optional)
├── config
├── exception
└── HospitalManagementApplication.java
```

---

🗄 Database Entities

- Department
- Doctor
- Patient
- Appointment
- MedicalRecord
- Prescription

Relationships

- Department → One-to-Many → Doctor
- Doctor → One-to-Many → Appointment
- Doctor → One-to-Many → MedicalRecord
- Patient → One-to-Many → Appointment
- Patient → One-to-Many → MedicalRecord
- MedicalRecord → One-to-One → Prescription

---

⚙ API Endpoints

Department
- POST /department
- GET /department
- GET /department/{id}
- PUT /department
- DELETE /department/{id}

Doctor
- POST /doctor
- GET /doctor
- GET /doctor/{id}
- PUT /doctor
- DELETE /doctor/{id}

Patient
- POST /patient
- GET /patient
- GET /patient/{id}
- PUT /patient
- DELETE /patient/{id}

Appointment
- POST /appointment
- GET /appointment
- GET /appointment/{id}
- PUT /appointment
- DELETE /appointment/{id}

Medical Record
- POST /medicalRecord
- GET /medicalRecord
- GET /medicalRecord/{id}
- PUT /medicalRecord
- DELETE /medicalRecord/{id}

Prescription
- POST /prescription
- GET /prescription
- GET /prescription/{id}
- PUT /prescription
- DELETE /prescription/{id}

Complete API documentation is available through Swagger UI.

---

▶ Running Locally

Clone Repository

```bash
git clone https://github.com/UmeshChandrayadav/Hospital-Management.git
```

Navigate

```bash
cd Hospital-Management
```

Configure Database

Set the following environment variables:

```
SPRING_DATASOURCE_URL
SPRING_DATASOURCE_USERNAME
SPRING_DATASOURCE_PASSWORD
```

Example

```
SPRING_DATASOURCE_URL=jdbc:postgresql://localhost:5432/HospitalManagementDB
SPRING_DATASOURCE_USERNAME=postgres
SPRING_DATASOURCE_PASSWORD=your_password
```

Run

```bash
./mvnw spring-boot:run
```

or

```bash
mvn spring-boot:run
```

---

🌐 Deployment

The application is deployed on Render using Docker.

Deployment includes:

- Dockerized Spring Boot application
- PostgreSQL Database on Render
- Environment Variables
- Automatic GitHub Deployment

---

📸 API Documentation

Swagger UI

https://hospital-management-bsw9.onrender.com/swagger-ui/index.html

---

📈 Future Enhancements

- Spring Security with JWT Authentication
- Role-Based Access Control (Admin, Doctor, Receptionist)
- DTO Layer
- Validation using Bean Validation
- Pagination & Sorting
- Search & Filtering
- Unit Testing
- Global Exception Handling Improvements
- Logging
- Email Notifications

---

👨‍💻 Author

Umesh Chandra Yadav

Email:
umeshpchandra12@gmail.com

GitHub:
https://github.com/UmeshChandrayadav

LinkedIn:
https://www.linkedin.com/in/umesh-chandra-p

---

## ⭐ If you like this project

Give this repository a ⭐ on GitHub.
