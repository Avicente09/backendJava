/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gt.gob.mspas.seguridad.impl;

import gt.gob.mspas.seguridad.config.CustomErrorType;
import gt.gob.mspas.seguridad.config.ResponseBuilder;
import gt.gob.mspas.seguridad.entity.TcSaAplicacion;
import gt.gob.mspas.seguridad.entity.TtSaComponente;
import gt.gob.mspas.seguridad.service.ComponenteService;
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
public class ComponenteImpl implements ComponenteService {

    @Autowired
    SessionFactory sessionFactory;

    Session session = null;
    Transaction tx = null;

    @Override
    public ResponseEntity<Map<String, Object>> saveOrUpdate(TtSaComponente componente) {
        String message = "";
        Date fechaHoy = new Date();

        if (componente.getIdComponente() != null) {
            componente.setFechaModificacion(fechaHoy);
        } else {
            componente.setActivo(true);
            componente.setNodoPadre(null);
            componente.setUsuarioCreacion(1);
            componente.setFechaCreacion(fechaHoy);

        }

        try {
            session = sessionFactory.openSession();
            tx = session.beginTransaction();
            session.saveOrUpdate(componente);
            tx.commit();
            session.close();

        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            session.close();
            System.out.println("Ocurrio un error al guardar :" + e);
            message = e.toString();
            return ResponseBuilder.response(message, false);
        }

        message = "Componente guardado con exito!";

        return ResponseBuilder.response(message);
    }

    @Override
    public ResponseEntity<Map<String, Object>> getById(Integer id) {
        TtSaComponente componente = new TtSaComponente();
        String message;

        try {
            session = sessionFactory.openSession();
         //   tx = session.beginTransaction();
            Query query = session.createQuery("from TtSaComponente tm where tm.idComponente =:idComponente AND tm.activo=true");
            query.setParameter("idComponente", id);
            componente = (TtSaComponente) query.list().get(0);
         //   tx.commit();
         //   session.close();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            session.close();
            System.out.println("Ocurrio un error al obtener por ID:" + id + " " + e.toString());
            message = "Ocurrio un error al obtener por ID:" + id + " " + e.toString();
            return ResponseBuilder.response(message, false);
        }

        message = "La consulta se realizo con exito!";

        return ResponseBuilder.response(componente, message, true);
    }

    @Override
    public ResponseEntity<Map<String, Object>> getListByString(String str) {
        List<TtSaComponente> aplicacionList = new ArrayList<>();
        String message;
        try {
            session = sessionFactory.openSession();
        //    tx = session.beginTransaction();
            Query query = session.createQuery("FROM TtSaComponente md WHERE md.activo =:paramEstado  AND lower(md.nombreComponente) LIKE lower(:str) ");
            query.setParameter("paramEstado", true);
            query.setParameter("str", "%" + str + "%");
//            query.setFirstResult(0);
//            query.setMaxResults(50);
            aplicacionList = query.list();
          //  tx.commit();
          //  session.close();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            session.close();
            System.out.println("Ocurrio un error al obtener resultado por string:" + str + " " + e.toString());
            message = "Ocurrio un error al obtener  por string:" + str + " " + e.toString();
            return ResponseBuilder.response(message, false);
        }

        message = "La consulta se realizo con exito!";

        return ResponseBuilder.response(aplicacionList, message, true);
    }

    @Override
    public ResponseEntity<Map<String, Object>> delete(TtSaComponente componente) {
        String message;
        componente.setActivo(false);

        try {
            session = sessionFactory.openSession();
            tx = session.beginTransaction();
            session.update(componente);
            tx.commit();

        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            session.close();
            System.out.println("Ocurrio un error al eliminar por ID:" + componente + " " + e.toString());
            message = "Ocurrio un error al eliminar por ID:" + componente + " " + e.toString();
            return ResponseBuilder.response(message, false);
        }
        session.close();

        message = "El registro fue eliminado!";

        return ResponseBuilder.response(message, true);
    }

    @Override
    public ResponseEntity<Map<String, Object>> getListByIdAplicacion(TcSaAplicacion aplicacion) {

        String message;
        List<TtSaComponente> componenteList = new ArrayList<>();

        try {
            session = sessionFactory.openSession();
         //   tx = session.beginTransaction();
            Criteria c2 = session.createCriteria(TtSaComponente.class);
            c2.add(Restrictions.eq("activo", true));
            c2.add(Restrictions.eq("idAplicacion", aplicacion.getIdAplicacion()));
            componenteList = c2.list();
         //   tx.commit();
          //  session.close();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            session.close();
            System.out.println("Ocurrio un error al obtener por IdAplicacion:" + e.toString());
            message = "Ocurrio un error al obtener por listado :" + e.toString();
            return ResponseBuilder.response(message, false);
        }

        message = "La consulta se realizo con exito!";

        return ResponseBuilder.response(componenteList, message, true);
    }

    @Override
    public ResponseEntity<Map<String, Object>> getListComponentesPadre(Integer id) {
        List<TtSaComponente> aplicacionList = new ArrayList<>();
        String message;
        try {
            session = sessionFactory.openSession();
        //    tx = session.beginTransaction();
            Query query = session.createQuery("FROM TtSaComponente md WHERE md.activo =:paramEstado  "
                    + " AND md.nodoPadre = null "
                    + " AND md.idAplicacion =:id");
            query.setParameter("paramEstado", true);
            query.setParameter("id", id);
            aplicacionList = query.list();
          //  tx.commit();
        //    session.close();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            session.close();
            System.out.println("Ocurrio un error al obtener resultado por string:" + e.toString());
            message = "Ocurrio un error al obtener  por string:" + e.toString();
            return ResponseBuilder.response(message, false);
        }

        message = "La consulta se realizo con exito!";

        return ResponseBuilder.response(aplicacionList, message, true);
    }

}
