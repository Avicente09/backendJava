package gt.gob.mspas.seguridad.impl;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import gt.gob.mspas.seguridad.config.CustomErrorType;
import gt.gob.mspas.seguridad.config.ResponseBuilder;
import gt.gob.mspas.seguridad.entity.TcSaAplicacion;
import gt.gob.mspas.seguridad.entity.TtSaAplicacionRol;
import gt.gob.mspas.seguridad.entity.TtSaRolComponente;
import gt.gob.mspas.seguridad.entity.TtSaPersona;
import gt.gob.mspas.seguridad.entity.TtSaUsuario;
import gt.gob.mspas.seguridad.entity.TtSaUsuarioAplicacionRol;
import gt.gob.mspas.seguridad.service.UsuarioService;
import java.io.Console;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
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
 * @author archeesman
 */
public class UsuarioImpl implements UsuarioService {

    @Autowired
    SessionFactory sessionFactory;

    Session session = null;
    Transaction tx = null;

    @Override
    public ResponseEntity<Map<String, Object>> saveOrUpdateUsuario(TtSaUsuario usuario) {
        Date fechaActual = new Date();
        TtSaPersona persona = new TtSaPersona();

        try {

            session = sessionFactory.openSession();
            tx = session.beginTransaction();

            if (usuario.getIdPersona().getIdPersona() != null) {
                usuario.setFechaModificacion(fechaActual);
                persona = usuario.getIdPersona();
            } else {

                usuario.setActivo(true);
                usuario.setFechaCreacion(fechaActual);
                usuario.setUsuarioCreacion(1);
                usuario.getIdPersona().setActivo(true);
                usuario.getIdPersona().setFechaCreacion(fechaActual);
                usuario.getIdPersona().setUsuarioCreacion(1);
                persona = usuario.getIdPersona();
                persona.setIdRedServicio(1);
                usuario.setIdTipoUsuario(1);
            }

            session.saveOrUpdate(persona);
            usuario.setIdPersona(persona);
            session.saveOrUpdate(usuario);

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

        String message = "El Usuario se registro con exito!";

        return ResponseBuilder.response(message);
    }

    @Override
    public ResponseEntity<Map<String, Object>> getUsuarioById(Integer id) {
        List<TtSaUsuario> persona = new ArrayList<>();
        String message;

        try {
            session = sessionFactory.openSession();

            Query query = session.createQuery("from TtSaUsuario tm  where tm.idPersona.idPersona =:idPersona AND tm.activo = true");
            query.setParameter("idPersona", id);
            persona = query.list();

        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            session.close();
            System.out.println("Ocurrio un error al obtener Usuario por ID:" + id + " " + e.toString());
            message = "Ocurrio un error al obtener Usuario por ID:" + id + " " + e.toString();
            return ResponseBuilder.response(message, false);
        }
        session.close();

        message = "La consulta se realizo con exito!";

        return ResponseBuilder.response(persona.get(0), message, true);
    }

    @Override
    public ResponseEntity<Map<String, Object>> getUsuarioListByString(String str) {
        List<TtSaUsuario> usuarioList = new ArrayList<>();
        String message;
        try {
            session = sessionFactory.openSession();

            Query query = session.createQuery("FROM TtSaUsuario md WHERE md.activo =:paramEstado  AND "
                    + " concat(md.usuario , ' ', lower(md.idPersona.personaConcatenada)) LIKE lower(:str)");
            query.setParameter("paramEstado", true);
            query.setParameter("str", "%" + str + "%");
//            query.setFirstResult(0);
//            query.setMaxResults(50);
            usuarioList = query.list();

        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            session.close();
            System.out.println("Ocurrio un error al obtener aplicacion por string:" + str + " " + e.toString());
            message = "Ocurrio un error al obtener aplicacion por string:" + str + " " + e.toString();
            return ResponseBuilder.response(message, false);
        }
        session.close();

        message = "La consulta se realizo con exito!";

        return ResponseBuilder.response(usuarioList, message, true);
    }

    @Override
    public ResponseEntity<Map<String, Object>> deleteUsuario(TtSaUsuario usuario) {
        String message;
        usuario.setActivo(false);

        try {
            session = sessionFactory.openSession();
            tx = session.beginTransaction();
            session.update(usuario);
            tx.commit();

        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            session.close();
            System.out.println("Ocurrio un error al eliminar usuario por ID:" + usuario + " " + e.toString());
            message = "Ocurrio un error al eliminar usuario por ID:" + usuario + " " + e.toString();
            return ResponseBuilder.response(message, false);
        }
        session.close();

        message = "El registro fue eliminado!";

        return ResponseBuilder.response(message, true);
    }

    @Override
    public ResponseEntity<Map<String, Object>> getLoginUsuario(TtSaUsuario datosLogin, String str) {
        List<TtSaUsuario> list = new ArrayList<>();

        String message;

        try {
            session = sessionFactory.openSession();

            Criteria c2 = session.createCriteria(TtSaUsuario.class);
            c2.add(Restrictions.eq("usuario", datosLogin.getUsuario()));
            list = c2.list();

            if (list.size() <= 0) {
                message = "El usuario es incorrecto, por favor verificar";
                return ResponseBuilder.response(message, false);
            }

            String pass = list.get(0).getPassword();
            if (pass == null ? datosLogin.getPassword() != null : !pass.equals(datosLogin.getPassword())) {
                message = "La contraseña es invalida, intentalo de nuevo";
                return ResponseBuilder.response(message, false);
            }
            //  session.close();

        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            session.close();
            System.out.println("Ocurrio un error al verificar login" + e.toString());
            message = "Ocurrio un error al verificar login" + e.toString();
            return ResponseBuilder.response(message, false);
        }

        return getUsuarioPermisos(list.get(0).getIdUsuario(), str);
    }

    @Override
    public ResponseEntity<Map<String, Object>> getUsuarioPermisos(Integer idUsuario, String str) {
        List<TcSaAplicacion> aplicacionList = new ArrayList<>();
        String appName = "";
        if (str != null) {
            appName = " AND md.idAplicacionRol.idAplicacion.nombreAplicacion =:paramNombreApp";
        }

        String message;
        try {
            session = sessionFactory.openSession();

            Query query = session.createQuery("SELECT DISTINCT md.idAplicacionRol.idAplicacion, md.idUsuario.idUsuario FROM TtSaUsuarioAplicacionRol md WHERE md.activo =:paramEstado "
                    + " AND md.idUsuario.idUsuario =:idUsuario"
                    + appName);
            query.setParameter("paramEstado", true);
            query.setParameter("idUsuario", idUsuario);
            if (str != null) {
                query.setParameter("paramNombreApp", str);
            }

            aplicacionList = query.list();

            if (str != null) {
                if (aplicacionList.size() > 0) {
                    for (int i = 0; i < aplicacionList.size(); i++) {
                        if (aplicacionList.get(i).getNombreAplicacion().equals(str)) {
                            System.out.println(aplicacionList.get(i).getIdAplicacion());
                            return getListByIdAplicacion(aplicacionList.get(i).getIdAplicacion(), idUsuario);
                        }
                    }
                }
            }

        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            session.close();
            System.out.println("Ocurrio un error al obtener lista aplicacion: " + e.toString());
            message = "Ocurrio un error al obtener lista aplicacion: " + e.toString();
            return ResponseBuilder.response(message, false);
        }
        //  session.close();

        message = "Login Correcto!";

        return ResponseBuilder.response(aplicacionList, message, true);
    }

    public ResponseEntity<Map<String, Object>> getListByIdAplicacion(Integer aplicacion, Integer usuario) {
        List<TtSaUsuarioAplicacionRol> aplicacionList = new ArrayList<>();

        String message;
        try {
            session = sessionFactory.openSession();

            Query query = session.createQuery("FROM TtSaUsuarioAplicacionRol md WHERE md.activo =:paramEstado "
                    + " AND md.idUsuario.idUsuario =:idUsuario "
                    + " AND md.idAplicacionRol.idAplicacion.idAplicacion =:idAplicacion"
                    + " AND md.idAplicacionRol.idRol.activo =:paramEstadoComponente");
            query.setParameter("paramEstado", true);
            query.setParameter("idUsuario", usuario);
            query.setParameter("idAplicacion", aplicacion);
            query.setParameter("paramEstadoComponente", true);
            aplicacionList = query.list();

            if (aplicacionList.size() > 0) {
                for (TtSaUsuarioAplicacionRol ttSaUsuarioAplicacionRol : aplicacionList) {
                    ttSaUsuarioAplicacionRol.getIdAplicacionRol().getIdRol().getTtSaRolComponenteList().clear();
                    Criteria listRolComponents = session.createCriteria(TtSaRolComponente.class);
                    listRolComponents.add(Restrictions.eq("activo", true));
                    listRolComponents.add(Restrictions.eq("idRol", ttSaUsuarioAplicacionRol.getIdAplicacionRol().getIdRol().getIdRol()));
                    ttSaUsuarioAplicacionRol.getIdAplicacionRol().getIdRol().setTtSaRolComponenteList(listRolComponents.list());
                }
            }

        } catch (HibernateException e) {
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

}
