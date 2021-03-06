/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gt.gob.mspas.seguridad.service;

import gt.gob.mspas.seguridad.entity.TcSaAplicacion;
import gt.gob.mspas.seguridad.entity.TtSaComponente;
import java.util.Map;
import org.springframework.http.ResponseEntity;

/**
 *
 * @author Ottoniel RT
 */
public interface ComponenteService {

    public ResponseEntity<Map<String, Object>> saveOrUpdate(TtSaComponente componente);

    public ResponseEntity<Map<String, Object>> getById(Integer id);

    public ResponseEntity<Map<String, Object>> getListByString(String str);

    public ResponseEntity<Map<String, Object>> delete(TtSaComponente componente);
    
    public ResponseEntity<Map<String, Object>> getListByIdAplicacion(TcSaAplicacion aplicacion);
    
    public ResponseEntity<Map<String, Object>> getListComponentesPadre (Integer id);

}
