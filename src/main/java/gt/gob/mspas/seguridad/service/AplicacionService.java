/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gt.gob.mspas.seguridad.service;

import gt.gob.mspas.seguridad.entity.TcSaAplicacion;
import gt.gob.mspas.seguridad.entity.TtSaUsuarioAplicacionRol;
import java.util.List;
import java.util.Map;
import org.springframework.http.ResponseEntity;

/**
 *
 * @author Ottoniel RT
 */
public interface AplicacionService {

    public ResponseEntity<Map<String, Object>> saveOrUpdateAplicacion(TcSaAplicacion aplicacion);

    public ResponseEntity<Map<String, Object>> getAplicacionById(Integer id);

    public ResponseEntity<Map<String, Object>> getAplicacionListByString(String str);

    public ResponseEntity<Map<String, Object>> deleteAplicacion(TcSaAplicacion aplicacion);

    public ResponseEntity<Map<String, Object>> getAplicacionList();

    public ResponseEntity<Map<String, Object>> getAplicacionAignadaByIdUsuario(Integer idUsuario, Integer idAplicacion);

    public ResponseEntity<Map<String, Object>> getRolAplicacionByIdUsuario(Integer idUsuario, Integer idAplicacion);

    public ResponseEntity<Map<String, Object>> saveOrUpdateusuarioAplicacionRol(List<TtSaUsuarioAplicacionRol> usuarioAplicacionROl);
}
