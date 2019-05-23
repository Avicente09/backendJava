/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gt.gob.mspas.seguridad.controller;

import gt.gob.mspas.seguridad.entity.TcSaAplicacion;
import gt.gob.mspas.seguridad.entity.TcSaRol;
import gt.gob.mspas.seguridad.entity.TtSaAplicacionRol;
import gt.gob.mspas.seguridad.entity.TtSaComponente;
import gt.gob.mspas.seguridad.service.ComponenteService;
import gt.gob.mspas.seguridad.service.RolService;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author Ottoniel RT
 */
@Controller
@CrossOrigin
@RequestMapping("/rol")
public class RolController {

    @Autowired
    RolService service;

    @RequestMapping(value = "/", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Map<String, Object>> save(@RequestBody TtSaAplicacionRol aplicacionRol) {
        return service.saveOrUpdate(aplicacionRol);
    }

    @RequestMapping(value = "/{idRol}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Map<String, Object>> getById(@PathVariable("idRol") Integer id) {
        return service.getById(id);
    }

    @RequestMapping(value = "/consulta/{str}", method = RequestMethod.GET)
    public @ResponseBody
    ResponseEntity<Map<String, Object>> getListByString(@PathVariable("str") String str) {
        return service.getListByString(str);
    }

    @RequestMapping(value = "/", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    ResponseEntity<Map<String, Object>> delete(@RequestBody TtSaAplicacionRol aplicacionRol) {
        return service.delete(aplicacionRol);
    }

    @RequestMapping(value = "/lista", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Map<String, Object>> getListComponenteByAplicacion(@RequestBody TcSaAplicacion aplicacion) {
        return service.getListByIdAplicacion(aplicacion);
    }

}
