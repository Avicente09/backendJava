/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gt.gob.mspas.seguridad.impl;

import gt.gob.mspas.seguridad.config.CustomErrorType;
import gt.gob.mspas.seguridad.config.ResponseBuilder;
import gt.gob.mspas.seguridad.entity.TcSaAplicacion;
import gt.gob.mspas.seguridad.entity.TcSaRol;
import gt.gob.mspas.seguridad.entity.TtSaUsuarioAplicacionRol;
import gt.gob.mspas.seguridad.entity.TtSaAplicacionRol;
import gt.gob.mspas.seguridad.entity.TtSaComponente;

import gt.gob.mspas.seguridad.service.RolService;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

/**
 *
 * @author Ottoniel RT
 */
public class RolImpl implements RolService {
    
    @Autowired
    SessionFactory sessionFactory;
    
    Session session = null;
    Transaction tx = null;
    
    @Override
    public ResponseEntity<Map<String, Object>> saveOrUpdate(TtSaAplicacionRol aplicacionRol) {

        //TtSaAplicacionRol aplicacionRol = new TtSaAplicacionRol();
        TcSaRol rol = new TcSaRol();
        Boolean rolEdita;
        Date fechaHoy = new Date();
        
        if (aplicacionRol.getIdRol().getIdRol() == null) {
            rolEdita = false;
            rol.setActivo(true);
            rol.setNombreRol(aplicacionRol.getIdRol().getNombreRol());
            rol.setDescripcion(aplicacionRol.getIdRol().getDescripcion());
            rol.setUsuarioCreacion(1);
            rol.setUsuarioModificacion(1);
            rol.setFechaCreacion(fechaHoy);
            //rol.setFechaModificacion(new Date());

            aplicacionRol.setActivo(true);
            aplicacionRol.setUsuarioCreacion(1);
            aplicacionRol.setUsuarioModificacion(1);
            aplicacionRol.setFechaCreacion(new Date());
            aplicacionRol.setFechaModificacion(new Date());
            //aplicacionRol.setIdAplicacion(aplicacion);
            aplicacionRol.setIdRol(rol);
        } else {
            rolEdita = true;
            rol = aplicacionRol.getIdRol();
            rol.setFechaModificacion(fechaHoy);
            
        }
        
        try {
            session = sessionFactory.openSession();
            tx = session.beginTransaction();
            
            if (rolEdita == true) {
                session.saveOrUpdate(rol);
                
            } else {
                session.saveOrUpdate(rol);
                session.saveOrUpdate(aplicacionRol);
            }
            
            tx.commit();
            
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            session.close();
            System.out.println("Ocurrio un error al guardar :" + e);
            return new ResponseEntity(new CustomErrorType("Ocurrio un error al guardar :" + e), HttpStatus.BAD_REQUEST);
        }
        session.close();
        
        String message = "Guardado con exito!";
        
        return ResponseBuilder.response(message);
    }
    
    @Override
    public ResponseEntity<Map<String, Object>> getById(Integer id) {
        TcSaRol rol = new TcSaRol();
        String message;
        
        try {
            session = sessionFactory.openSession();
            
            Query query = session.createQuery("from TcSaRol tm where tm.idRol =:parametro ");
            query.setParameter("parametro", id);
            rol = (TcSaRol) query.list().get(0);
            
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            session.close();
            System.out.println("Ocurrio un error al obtener por ID:" + id + " " + e.toString());
            message = "Ocurrio un error al obtener por ID:" + id + " " + e.toString();
            return ResponseBuilder.response(message, false);
        }
        session.close();
        
        message = "La consulta se realizo con exito!";
        
        return ResponseBuilder.response(rol, message, true);
    }
    
    @Override
    public ResponseEntity<Map<String, Object>> getListByString(String str) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public ResponseEntity<Map<String, Object>> delete(TtSaAplicacionRol aplicacionRol) {
        TcSaRol rol = new TcSaRol();
        String message;
        Date fechaHoy = new Date();
        aplicacionRol.setActivo(false);
        rol = aplicacionRol.getIdRol();
        rol.setActivo(false);
        rol.setFechaModificacion(fechaHoy);
        aplicacionRol.setFechaModificacion(fechaHoy);
        
        
        
        try {
            session = sessionFactory.openSession();
            tx = session.beginTransaction();
            session.update(rol);
            session.update(aplicacionRol);
            tx.commit();
            session.close();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            session.close();
            System.out.println("Ocurrio un error al eliminar por ID:" + rol + " " + e.toString());
            message = "Ocurrio un error al eliminar por ID:" + rol + " " + e.toString();
            return ResponseBuilder.response(message, false);
        }
        
        
        message = "El registro fue eliminado!";
        
        return ResponseBuilder.response(message, true);
    }
    
    @Override
    public ResponseEntity<Map<String, Object>> getListByIdAplicacion(TcSaAplicacion aplicacion) {
        
        String message;
        List<TtSaAplicacionRol> rolList = new ArrayList<>();
        
        try {
            session = sessionFactory.openSession();
            
            Criteria c2 = session.createCriteria(TtSaAplicacionRol.class).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);;
            Criteria c3 = c2.createCriteria("idAplicacion");
            Criteria c4 = c2.createCriteria("idRol");
            c2.add(Restrictions.eq("activo", true));
            c4.add(Restrictions.eq("activo", true));
            c3.add(Restrictions.eq("idAplicacion", aplicacion.getIdAplicacion()));
            rolList = c2.list();
            
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            session.close();
            System.out.println("Ocurrio un error al obtener el Rol: " + aplicacion.getIdAplicacion() + " " + e.toString());
            message = "Ocurrio un error al obtener el Rol: " + e.toString();
            return ResponseBuilder.response(message, false);
        }
        session.close();
        
        message = "La consulta se realizo con exito!";
        
        return ResponseBuilder.response(rolList, message, true);
    }

    @Override
    public ResponseEntity<Map<String, Object>> getListRolComponentesList(TcSaRol rol) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
