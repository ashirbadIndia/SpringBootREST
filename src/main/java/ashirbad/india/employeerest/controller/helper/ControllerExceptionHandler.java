package ashirbad.india.employeerest.controller.helper;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.dao.DataIntegrityViolationException;

@ControllerAdvice
public class ControllerExceptionHandler {
    
    private String recordNotFoundMsg = "Record Not found";
    private String constraintViolationMsg = "Data Constraint violation";
    private String integrityViolation = "Data Integrity violation";

    @ExceptionHandler(value = EmptyResultDataAccessException.class)
    public ResponseEntity<Object> recordNotFoundException(EmptyResultDataAccessException e) {
        return ResponseHandler.generateResponse(recordNotFoundMsg, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value = DataIntegrityViolationException.class)
    public ResponseEntity<Object> dataIntegrityViolationException(DataIntegrityViolationException e) {
        if(e.getCause()!=null && e.getCause().getClass() == org.hibernate.exception.ConstraintViolationException.class){
            return ResponseHandler.generateResponse(constraintViolationMsg, HttpStatus.CONFLICT);
        }
        return ResponseHandler.generateResponse(integrityViolation, HttpStatus.CONFLICT);
    }
   @ExceptionHandler(value = Exception.class)
    public ResponseEntity<Object> databaseConnectionFailsException(Exception exception) {
        return ResponseHandler.generateResponse(exception.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
