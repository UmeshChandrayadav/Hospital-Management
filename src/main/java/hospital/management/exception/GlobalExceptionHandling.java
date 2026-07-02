package hospital.management.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import hospital.management.dto.ResponseStructure;





@ControllerAdvice
public class GlobalExceptionHandling {
	@ExceptionHandler(IdNotFoundException.class)
	public ResponseEntity<ResponseStructure<String>> handleNotFoundException(IdNotFoundException exception){
		ResponseStructure<String> response=new ResponseStructure();
		response.setStatusCode(HttpStatus.NOT_FOUND.value());
		response.setMessage(exception.getMessage());
		response.setData("Failure");
		
		return new ResponseEntity<ResponseStructure<String>>(response,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(NoRecordAvailableException.class)
	public ResponseEntity<ResponseStructure<String>> handleNoRecordException(NoRecordAvailableException exception){
		ResponseStructure<String> response=new ResponseStructure();
		response.setStatusCode(HttpStatus.NOT_FOUND.value());
		response.setMessage(exception.getMessage());
		response.setData("Failure");
		
		return new ResponseEntity<ResponseStructure<String>>(response,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(SlotUnavailableException.class)
	public ResponseEntity<ResponseStructure<String>> handleSlotUnavailableException(SlotUnavailableException exception){
		ResponseStructure<String> response=new ResponseStructure();
		response.setStatusCode(HttpStatus.BAD_REQUEST.value());
		response.setMessage(exception.getMessage());
		response.setData("Failure");
		
		return new ResponseEntity<ResponseStructure<String>>(response,HttpStatus.BAD_REQUEST);
	}

}
