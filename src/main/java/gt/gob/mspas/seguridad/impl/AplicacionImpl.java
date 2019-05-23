/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gt.gob.mspas.seguridad.impl;

import gt.gob.mspas.seguridad.config.CustomErrorType;
import gt.gob.mspas.seguridad.config.ResponseBuilder;
import gt.gob.mspas.seguridad.entity.TcSaAplicacion;
import gt.gob.mspas.seguridad.entity.TtSaUsuarioAplicacionRol;
import gt.gob.mspas.seguridad.entity.TtSaUsuario;
import gt.gob.mspas.seguridad.service.AplicacionService;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

/**
 *
 * @author Ottoniel RT
 */
public class AplicacionImpl implements AplicacionService {

    @Autowired
    SessionFactory sessionFactory;

    Session session = null;
    Transaction tx = null;

    @Override
    public ResponseEntity<Map<String, Object>> saveOrUpdateAplicacion(TcSaAplicacion aplicacion) {

        aplicacion.setActivo(true);
        aplicacion.setFechaCreacion(new Date());
        aplicacion.setUsuarioCreacion(1);

        try {
            session = sessionFactory.openSession();
            tx = session.beginTransaction();
            session.saveOrUpdate(aplicacion);
            tx.commit();

        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            session.close();
            System.out.println("Ocurrio un error al registrar la aplicación :" + e);
            return new ResponseEntity(new CustomErrorType("Ocurrio un error al registrar la aplicación :" + e), HttpStatus.BAD_REQUEST);
        }
        session.close();

        String message = "La aplicación se registro con exito!";

        return ResponseBuilder.response(message);
    }

    @Override
    public ResponseEntity<Map<String, Object>> getAplicacionById(Integer id) {

        TcSaAplicacion aplicacion = new TcSaAplicacion();
        String message;

        try {
            session = sessionFactory.openSession();

            Query query = session.createQuery("from TcSaAplicacion tm where tm.idAplicacion =:idAplicacion ");
            query.setParameter("idAplicacion", id);
            aplicacion = (TcSaAplicacion) query.list().get(0);

        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            //session.close();
            System.out.println("Ocurrio un error al obtener aplicacion por ID:" + id + " " + e.toString());
            message = "Ocurrio un error al obtener aplicacion por ID:" + id + " " + e.toString();
            return ResponseBuilder.response(message, false);
        }
        // session.close();

        message = "La consulta se realizo con exito!";

        return ResponseBuilder.response(aplicacion, message, true);
    }

    @Override
    public ResponseEntity<Map<String, Object>> getAplicacionListByString(String str) {
        List<TcSaAplicacion> aplicacionList = new ArrayList<>();
        String message;
        try {
//            sessionFactory = DBUtils.getSessionFactory();
            session = sessionFactory.openSession();

            Query query = session.createQuery("FROM TcSaAplicacion md WHERE md.activo =:paramEstado  AND lower(md.nombreAplicacion) LIKE lower(:str) ");
            query.setParameter("paramEstado", true);
            query.setParameter("str", "%" + str + "%");
//            query.setFirstResult(0);
//            query.setMaxResults(50);
            aplicacionList = query.list();

        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            session.close();
            System.out.println("Ocurrio un error al obtener aplicacion por string:" + str + " " + e.toString());
            message = "Ocurrio un error al obtener aplicacion por string:" + str + " " + e.toString();
            return ResponseBuilder.response(message, false);
        }
        //  session.close();

        message = "La consulta se realizo con exito!";

        return ResponseBuilder.response(aplicacionList, message, true);
    }

    @Override
    public ResponseEntity<Map<String, Object>> deleteAplicacion(TcSaAplicacion aplicacion) {

        String message;
        aplicacion.setActivo(false);

        try {
            session = sessionFactory.openSession();
            tx = session.beginTransaction();
            session.update(aplicacion);
            tx.commit();

        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            session.close();
            System.out.println("Ocurrio un error al eliminar aplicacion por ID:" + aplicacion + " " + e.toString());
            message = "Ocurrio un error al eliminar aplicacion por ID:" + aplicacion + " " + e.toString();
            return ResponseBuilder.response(message, false);
        }
        session.close();

        message = "El registro fue eliminado!";

        return ResponseBuilder.response(message, true);
    }

    @Override
    public ResponseEntity<Map<String, Object>> getAplicacionList() {
        List<TcSaAplicacion> aplicacionList = new ArrayList<>();
        String message;
        try {
            session = sessionFactory.openSession();

            Query query = session.createQuery("FROM TcSaAplicacion md WHERE md.activo =:paramEstado");
            query.setParameter("paramEstado", true);
            aplicacionList = query.list();

        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            session.close();
            System.out.println("Ocurrio un error al obtener lista aplicacion: " + e.toString());
            message = "Ocurrio un error al obtener lista aplicacion: " + e.toString();
            return ResponseBuilder.response(message, false);
        }
        //  session.close();

        message = "La consulta se realizo con exito!";

        return ResponseBuilder.response(aplicacionList, message, true);
    }

    @Override
    public ResponseEntity<Map<String, Object>> getAplicacionAignadaByIdUsuario(Integer usuario, Integer aplicacion) {
        List<TtSaUsuarioAplicacionRol> aplicacionList = new ArrayList<>();

        String message;
        try {
            session = sessionFactory.openSession();

            Query query = session.createQuery("FROM TtSaUsuarioAplicacionRol md WHERE md.activo =:paramEstado "
                    + " AND md.idUsuario.idUsuario =:idUsuario "
                    + " AND md.idAplicacionRol.idAplicacion.idAplicacion =:idAplicacion");
            query.setParameter("paramEstado", true);
            query.setParameter("idUsuario", usuario);
            query.setParameter("idAplicacion", aplicacion);
            aplicacionList = query.list();

        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            session.close();
            System.out.println("Ocurrio un error al obtener lista aplicacion: " + e.toString());
            message = "Ocurrio un error al obtener lista aplicacion: " + e.toString();
            return ResponseBuilder.response(message, false);
        }
        //  session.close();

        message = "La consulta se realizo con exito!";

        return ResponseBuilder.response(aplicacionList, message, true);
    }

    @Override
    public ResponseEntity<Map<String, Object>> getRolAplicacionByIdUsuario(Integer usuario, Integer aplicacion) {
        List<TtSaUsuarioAplicacionRol> aplicacionList = new ArrayList<>();

        String message;
        try {
            session = sessionFactory.openSession();

            Query query = session.createQuery("SELECT md.idAplicacionRol.idRol.ttSaRolComponenteList FROM TtSaUsuarioAplicacionRol md WHERE md.activo =:paramEstado "
                    + " AND md.idUsuario.idUsuario =:idUsuario "
                    + " AND md.idAplicacionRol.idAplicacion.idAplicacion =:idAplicacion");

            query.setParameter("paramEstado", true);
            query.setParameter("idUsuario", usuario);
            query.setParameter("idAplicacion", aplicacion);
            //query.setParameter("paramActivo", true);

            aplicacionList = query.list();

        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            session.close();
            System.out.println("Ocurrio un error al obtener lista aplicacion: " + e.toString());
            message = "Ocurrio un error al obtener lista aplicacion: " + e.toString();
            return ResponseBuilder.response(message, false);
        }
        //  session.close();

        message = "La consulta se realizo con exito!";

        return ResponseBuilder.response(aplicacionList, message, true);
    }

    @Override
    public ResponseEntity<Map<String, Object>> saveOrUpdateusuarioAplicacionRol(List<TtSaUsuarioAplicacionRol> usuarioAplicacionRolList) {

        Date fechaHoy = new Date();

        try {
            session = sessionFactory.openSession();
            tx = session.beginTransaction();

            for (TtSaUsuarioAplicacionRol item : usuarioAplicacionRolList) {

                if (item.getIdAplicacionRol().getIdAplicacionRol() != null) {
                    item.setFechaModificacion(fechaHoy);
                } else {
                    item.setFechaCreacion(fechaHoy);
                }

                session.saveOrUpdate(item);
            }

            tx.commit();

        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            session.close();
            System.out.println("Ocurrio un error al registrar la aplicación :" + e);
            return new ResponseEntity(new CustomErrorType("Ocurrio un error al registrar la aplicación :" + e), HttpStatus.BAD_REQUEST);
        }
        session.close();

        String message = "La aplicación se registro con exito!";

        return ResponseBuilder.response(message);
    }

}
