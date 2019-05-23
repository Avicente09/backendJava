/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gt.gob.mspas.seguridad.config;

import java.util.HashMap;
import java.util.Map;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

/**
 *
 * @author Ottoniel RT
 */
public class ResponseBuilder {

    public static ResponseEntity<Map<String, Object>> response(Object object, String message, boolean success) {

        if (object == null) {
            object = "";
        }
        if (message.isEmpty()) {
            message = "Por defecto";
        }

        Map<String, Object> json = new HashMap<String, Object>();
        json.put("success", success);
        json.put("message", message);
        json.put("object", object);

        if (success == false) {
            return new ResponseEntity<Map<String, Object>>(json, HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<Map<String, Object>>(json, HttpStatus.OK);
    }

    public static ResponseEntity<Map<String, Object>> response(Object object) {
        return response(object, "", true);
    }

    public static ResponseEntity<Map<String, Object>> response(String message) {
        return response(null, message, true);
    }
    public static ResponseEntity<Map<String, Object>> response(String message, boolean succes) {
        return response(null, message, succes);
    }
}
