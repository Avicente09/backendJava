/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gt.gob.mspas.seguridad.controller;

import gt.gob.mspas.seguridad.entity.TcSaAplicacion;
import gt.gob.mspas.seguridad.entity.TtSaUsuarioAplicacionRol;
import gt.gob.mspas.seguridad.service.AplicacionService;
import java.util.ArrayList;
import java.util.List;
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
@RequestMapping("/aplicacion")
public class AplicacionController {

    @Autowired
    AplicacionService aplicacionService;

    @RequestMapping(value = "/", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Map<String, Object>> saveAplicacion(@RequestBody TcSaAplicacion aplicacion) {
        return aplicacionService.saveOrUpdateAplicacion(aplicacion);
    }

    @RequestMapping(value = "/{idAplicacion}", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    public ResponseEntity<Map<String, Object>> getAplicacionById(@PathVariable("idAplicacion") Integer id) {
        return aplicacionService.getAplicacionById(id);
    }

    @RequestMapping(value = "/consulta/{str}", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    public @ResponseBody
    ResponseEntity<Map<String, Object>> getAplicacionListByString(@PathVariable("str") String str) {
        return aplicacionService.getAplicacionListByString(str);
    }

    @RequestMapping(value = "/", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    ResponseEntity<Map<String, Object>> deleteAplicacion(@RequestBody TcSaAplicacion aplicacion) {
        return aplicacionService.deleteAplicacion(aplicacion);
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public @ResponseBody
    ResponseEntity<Map<String, Object>> getAplicacionList() {
        return aplicacionService.getAplicacionList();
    }

    @RequestMapping(value = "aplicacionAsignada/{id}/{idAplicacion}", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    public ResponseEntity<Map<String, Object>> getAplicacionesAsiganadasByIdUsuario(@PathVariable("id") Integer id, @PathVariable("idAplicacion") Integer idAplicacion) {
        return aplicacionService.getAplicacionAignadaByIdUsuario(id, idAplicacion);
    }

    @RequestMapping(value = "/rolAplicaciones/{id}/{idAplicacion}", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    public ResponseEntity<Map<String, Object>> getRolAplicacionesByIdUsuario(@PathVariable("id") Integer id, @PathVariable("idAplicacion") Integer idAplicacion) {
        return aplicacionService.getRolAplicacionByIdUsuario(id, idAplicacion);
    }

    @RequestMapping(value = "usuarioAplicacionRol/", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Map<String, Object>> saveUsuarioAplicacionRol(@RequestBody ArrayList<TtSaUsuarioAplicacionRol> usuarioAplicacionRol) {
        return aplicacionService.saveOrUpdateusuarioAplicacionRol(usuarioAplicacionRol);
    }

}
