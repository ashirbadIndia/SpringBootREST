package ashirbad.india.employeerest.controller.helper;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class ResponseHandler{
    public static ResponseEntity<Object> generateResponse(String message, HttpStatus status, Object responseObj) {
        Map<String, Object> map = new HashMap<String, Object>();
            map.put("message", message);
            map.put("status", status.value());
            map.put("data", responseObj);

            return new ResponseEntity<Object>(map,status);
    }
}

/*
public class ResponseWrapper extends ResponseEntity<Object>{
    
    public ResponseWrapper(String message, HttpStatus status, Object responseObj){
        super(new HashMap<String, Object>(
            Map.of("message",message,
                    "status",status.value(),
                    "data",responseObj
            )
        ),status);
    }
}*/
