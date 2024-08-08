package za.co.dearx.apiserver;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class APIController {

    @GetMapping(name = "echo", produces = "text/plain", consumes = "text/plain")
    public String foo(@RequestBody String body) {
        return "DeARX API Echo: " + body;
    }

    @GetMapping("/listHeaders")
    public ResponseEntity<String> listAllHeaders(@RequestHeader Map<String, String> headers) {
    	List<String> response = new ArrayList<String>(headers.size());
    	headers.forEach((key, value) -> {
            response.add(String.format("Header '%s' = %s", key, value));
        });

        return new ResponseEntity<String>(
          String.format("Received %d headers:\r\n%s", headers.size(), String.join(";\r\n", response)), HttpStatus.OK);
    }
}
