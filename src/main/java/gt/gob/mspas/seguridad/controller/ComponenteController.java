/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gt.gob.mspas.seguridad.controller;

import gt.gob.mspas.seguridad.entity.TcSaAplicacion;
import gt.gob.mspas.seguridad.entity.TtSaComponente;
import gt.gob.mspas.seguridad.service.AplicacionService;
import gt.gob.mspas.seguridad.service.ComponenteService;
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
@RequestMapping("/componente")
public class ComponenteController {

    @Autowired
    ComponenteService service;

    @RequestMapping(value = "/", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Map<String, Object>> save(@RequestBody TtSaComponente componente) {
        return service.saveOrUpdate(componente);
    }

    @RequestMapping(value = "/{idComponente}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Map<String, Object>> getById(@PathVariable("idComponente") Integer id) {
        return service.getById(id);
    }

    @RequestMapping(value = "/consulta/{str}", method = RequestMethod.GET)
    public @ResponseBody
    ResponseEntity<Map<String, Object>> getListByString(@PathVariable("str") String str) {
        return service.getListByString(str);
    }

    @RequestMapping(value = "/", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    ResponseEntity<Map<String, Object>> delete(@RequestBody TtSaComponente componente) {
        return service.delete(componente);
    }

    @RequestMapping(value = "/lista", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Map<String, Object>> getListComponenteByAplicacion(@RequestBody TcSaAplicacion aplicacion) {
        return service.getListByIdAplicacion(aplicacion);
    }
    
    @RequestMapping(value = "/listaNodos/{id}", method = RequestMethod.GET)
    public @ResponseBody
    ResponseEntity<Map<String, Object>> getListComponentePadreByIdAplicacion(@PathVariable("id") Integer id) {
        return service.getListComponentesPadre(id);
    }

}
