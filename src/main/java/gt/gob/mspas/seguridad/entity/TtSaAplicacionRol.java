/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gt.gob.mspas.seguridad.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Ottoniel RT
 */
@Entity
@Table(name = "tt_sa_aplicacion_rol")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TtSaAplicacionRol.findAll", query = "SELECT t FROM TtSaAplicacionRol t")})
public class TtSaAplicacionRol implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_aplicacion_rol")
    private Integer idAplicacionRol;
    @Column(name = "usuario_modificacion")
    private Integer usuarioModificacion;
    @Column(name = "fecha_modificacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaModificacion;
    @Basic(optional = false)
    @Column(name = "usuario_creacion")
    private int usuarioCreacion;
    @Basic(optional = false)
    @Column(name = "fecha_creacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaCreacion;
    @Basic(optional = false)
    @Column(name = "activo")
    private boolean activo;
    @JoinColumn(name = "id_aplicacion", referencedColumnName = "id_aplicacion")
    @ManyToOne(optional = false)
    private TcSaAplicacion idAplicacion;
    @JoinColumn(name = "id_rol", referencedColumnName = "id_rol")
    @ManyToOne(optional = false)
    private TcSaRol idRol;
//    @OneToOne(cascade = CascadeType.ALL, mappedBy = "ttSaAplicacionRol1")
//    private TtSaAplicacionRol ttSaAplicacionRol;
//    @JoinColumn(name = "id_aplicacion_rol", referencedColumnName = "id_aplicacion_rol", insertable = false, updatable = false)
//    @OneToOne(optional = false)
//    private TtSaAplicacionRol ttSaAplicacionRol1;

    public TtSaAplicacionRol() {
    }

    public TtSaAplicacionRol(Integer idAplicacionRol) {
        this.idAplicacionRol = idAplicacionRol;
    }

    public TtSaAplicacionRol(Integer idAplicacionRol, int usuarioCreacion, Date fechaCreacion, boolean activo) {
        this.idAplicacionRol = idAplicacionRol;
        this.usuarioCreacion = usuarioCreacion;
        this.fechaCreacion = fechaCreacion;
        this.activo = activo;
    }

    public Integer getIdAplicacionRol() {
        return idAplicacionRol;
    }

    public void setIdAplicacionRol(Integer idAplicacionRol) {
        this.idAplicacionRol = idAplicacionRol;
    }

    public Integer getUsuarioModificacion() {
        return usuarioModificacion;
    }

    public void setUsuarioModificacion(Integer usuarioModificacion) {
        this.usuarioModificacion = usuarioModificacion;
    }

    public Date getFechaModificacion() {
        return fechaModificacion;
    }

    public void setFechaModificacion(Date fechaModificacion) {
        this.fechaModificacion = fechaModificacion;
    }

    public int getUsuarioCreacion() {
        return usuarioCreacion;
    }

    public void setUsuarioCreacion(int usuarioCreacion) {
        this.usuarioCreacion = usuarioCreacion;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public boolean getActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public TcSaAplicacion getIdAplicacion() {
        return idAplicacion;
    }

    public void setIdAplicacion(TcSaAplicacion idAplicacion) {
        this.idAplicacion = idAplicacion;
    }

    public TcSaRol getIdRol() {
        return idRol;
    }

    public void setIdRol(TcSaRol idRol) {
        this.idRol = idRol;
    }

//    public TtSaAplicacionRol getTtSaAplicacionRol() {
//        return ttSaAplicacionRol;
//    }
//
//    public void setTtSaAplicacionRol(TtSaAplicacionRol ttSaAplicacionRol) {
//        this.ttSaAplicacionRol = ttSaAplicacionRol;
//    }
//
//    public TtSaAplicacionRol getTtSaAplicacionRol1() {
//        return ttSaAplicacionRol1;
//    }
//
//    public void setTtSaAplicacionRol1(TtSaAplicacionRol ttSaAplicacionRol1) {
//        this.ttSaAplicacionRol1 = ttSaAplicacionRol1;
//    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idAplicacionRol != null ? idAplicacionRol.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TtSaAplicacionRol)) {
            return false;
        }
        TtSaAplicacionRol other = (TtSaAplicacionRol) object;
        if ((this.idAplicacionRol == null && other.idAplicacionRol != null) || (this.idAplicacionRol != null && !this.idAplicacionRol.equals(other.idAplicacionRol))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gt.gob.mspas.seguridad.entity.TtSaAplicacionRol[ idAplicacionRol=" + idAplicacionRol + " ]";
    }
    
}
