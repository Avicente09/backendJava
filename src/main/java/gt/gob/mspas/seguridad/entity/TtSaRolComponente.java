/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gt.gob.mspas.seguridad.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Ottoniel RT
 */
@Entity
@Table(name = "tt_sa_rol_componente")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TtSaRolComponente.findAll", query = "SELECT t FROM TtSaRolComponente t")})
public class TtSaRolComponente implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_rol_componente")
    private Integer idRolComponente;
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
    @Basic(optional = false)
    @Column(name = "id_rol")
    private Integer idRol;
//    @Basic(optional = false)
//    @Column(name = "id_componente")
//    private boolean idComponente;

//    @JoinColumn(name = "id_rol", referencedColumnName = "id_rol")
//    @ManyToOne(optional = false)
//    private TcSaRol idRol;
    @JoinColumn(name = "id_componente", referencedColumnName = "id_componente")
    @ManyToOne(optional = false)
    private TtSaComponente idComponente;
    public TtSaRolComponente() {
    }

    public TtSaRolComponente(Integer idRolComponente) {
        this.idRolComponente = idRolComponente;
    }

    public TtSaRolComponente(Integer idRolComponente, int usuarioCreacion, Date fechaCreacion, boolean activo) {
        this.idRolComponente = idRolComponente;
        this.usuarioCreacion = usuarioCreacion;
        this.fechaCreacion = fechaCreacion;
        this.activo = activo;
    }

    public Integer getIdRolComponente() {
        return idRolComponente;
    }

    public void setIdRolComponente(Integer idRolComponente) {
        this.idRolComponente = idRolComponente;
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

//    public TcSaRol getIdRol() {
//        return idRol;
//    }
//
//    public void setIdRol(TcSaRol idRol) {
//        this.idRol = idRol;
//    }

    public TtSaComponente getIdComponente() {
        return idComponente;
    }

    public void setIdComponente(TtSaComponente idComponente) {
        this.idComponente = idComponente;
    }
    public Integer getIdRol() {
        return idRol;
    }

    public void setIdRol(Integer idRol) {
        this.idRol = idRol;
    }

//    public boolean isIdComponente() {
//        return idComponente;
//    }
//
//    public void setIdComponente(boolean idComponente) {
//        this.idComponente = idComponente;
//    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idRolComponente != null ? idRolComponente.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TtSaRolComponente)) {
            return false;
        }
        TtSaRolComponente other = (TtSaRolComponente) object;
        if ((this.idRolComponente == null && other.idRolComponente != null) || (this.idRolComponente != null && !this.idRolComponente.equals(other.idRolComponente))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gt.gob.mspas.seguridad.entity.TtSaRolComponente[ idRolComponente=" + idRolComponente + " ]";
    }

}
