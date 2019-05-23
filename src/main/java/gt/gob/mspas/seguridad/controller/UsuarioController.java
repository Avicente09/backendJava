/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gt.gob.mspas.seguridad.controller;

import gt.gob.mspas.seguridad.entity.TcSaAplicacion;
import gt.gob.mspas.seguridad.entity.TcSaRol;
import gt.gob.mspas.seguridad.entity.TtSaAplicacionRol;
import gt.gob.mspas.seguridad.entity.TtSaPersona;
import gt.gob.mspas.seguridad.entity.TtSaUsuario;
import gt.gob.mspas.seguridad.service.RolService;
import gt.gob.mspas.seguridad.service.UsuarioService;
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
 * @author erodriguez
 */
@Controller
@CrossOrigin
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    UsuarioService service;

    @RequestMapping(value = {"/"}, method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Map<String, Object>> save(@RequestBody TtSaUsuario usuarioPersona) {
        return service.saveOrUpdateUsuario(usuarioPersona);
    }

    @RequestMapping(value = "/{idRol}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Map<String, Object>> getById(@PathVariable("idRol") Integer id) {
        return service.getUsuarioById(id);
    }

    @RequestMapping(value = "/consulta/{str}", method = RequestMethod.GET)
    public @ResponseBody
    ResponseEntity<Map<String, Object>> getListByString(@PathVariable("str") String str) {
        return service.getUsuarioListByString(str);
    }

    @RequestMapping(value = {"/login", "/login/{str}"}, method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Map<String, Object>> verificarLogin(@RequestBody TtSaUsuario datosLogin, @PathVariable(value = "str", required = false) String str) {
        return service.getLoginUsuario(datosLogin, str);
    }

}
