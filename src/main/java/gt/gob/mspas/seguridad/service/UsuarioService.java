/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gt.gob.mspas.seguridad.service;

import gt.gob.mspas.seguridad.entity.TcSaAplicacion;
import gt.gob.mspas.seguridad.entity.TtSaUsuario;
import java.util.List;
import java.util.Map;
import org.springframework.http.ResponseEntity;

/**
 *
 * @author Ottoniel RT
 */
public interface UsuarioService {

    public ResponseEntity<Map<String, Object>> saveOrUpdateUsuario(TtSaUsuario usuario);

    public ResponseEntity<Map<String, Object>> getUsuarioById(Integer id);

    public ResponseEntity<Map<String, Object>> getUsuarioListByString(String str);

    public ResponseEntity<Map<String, Object>> deleteUsuario(TtSaUsuario usuario);

    public ResponseEntity<Map<String, Object>> getLoginUsuario(TtSaUsuario usuario, String str);

    public ResponseEntity<Map<String, Object>> getUsuarioPermisos(Integer idUsuario, String str);
}
