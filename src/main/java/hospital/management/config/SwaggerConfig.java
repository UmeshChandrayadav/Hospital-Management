package hospital.management.config;

import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;

@Configuration
@OpenAPIDefinition(
	    info = @Info(
	        title = "Hospital Management System API",
	        version = "1.0",
	        description = "REST API for managing Patients, Doctors, Departments, Appointments, Medical Records and Prescriptions.",
	        contact = @Contact(
	            name = "Umesh Chandra Yadav",
	            email = "umeshpchandra12@gmail.com"
	        )
	    )
	)
public class SwaggerConfig {

}
