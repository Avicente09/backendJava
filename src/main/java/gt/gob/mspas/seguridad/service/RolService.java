/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gt.gob.mspas.seguridad.service;

import gt.gob.mspas.seguridad.entity.TcSaAplicacion;
import gt.gob.mspas.seguridad.entity.TcSaRol;
import gt.gob.mspas.seguridad.entity.TtSaAplicacionRol;
import java.util.Map;
import org.springframework.http.ResponseEntity;

/**
 *
 * @author Ottoniel RT
 */
public interface RolService {

    public ResponseEntity<Map<String, Object>> saveOrUpdate(TtSaAplicacionRol aplicacionRol );

    public ResponseEntity<Map<String, Object>> getById(Integer id);

    public ResponseEntity<Map<String, Object>> getListByString(String str);

    public ResponseEntity<Map<String, Object>> delete(TtSaAplicacionRol aplicacionRol);

    public ResponseEntity<Map<String, Object>> getListByIdAplicacion(TcSaAplicacion aplicacion);
    
    public ResponseEntity<Map<String, Object>> getListRolComponentesList(TcSaRol rol);
}
