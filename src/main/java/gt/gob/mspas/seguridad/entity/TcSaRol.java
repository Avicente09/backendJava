/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gt.gob.mspas.seguridad.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import org.codehaus.jackson.annotate.JsonIgnore;

/**
 *
 * @author Ottoniel RT
 */
@Entity
@Table(name = "tc_sa_rol")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TcSaRol.findAll", query = "SELECT t FROM TcSaRol t")})
public class TcSaRol implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_rol")
    private Integer idRol;
    @Basic(optional = false)
    @Column(name = "nombre_rol")
    private String nombreRol;
    @Column(name = "descripcion")
    private String descripcion;
    @Column(name = "usuario_modificacion")
    private Integer usuarioModificacion;
    @Column(name = "fecha_modificacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaModificacion;
    @Column(name = "usuario_creacion")
    private Integer usuarioCreacion;
    @Basic(optional = false)
    @Column(name = "fecha_creacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaCreacion;
    @Basic(optional = false)
    @Column(name = "activo")
    private boolean activo;
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER, mappedBy = "idRol")
    private List<TtSaRolComponente> ttSaRolComponenteList;

//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idRol")
//    private List<TtSaAplicacionRol> ttSaAplicacionRolList;
    public TcSaRol() {
    }

    public TcSaRol(Integer idRol) {
        this.idRol = idRol;
    }

    public TcSaRol(Integer idRol, String nombreRol, Date fechaCreacion, boolean activo) {
        this.idRol = idRol;
        this.nombreRol = nombreRol;
        this.fechaCreacion = fechaCreacion;
        this.activo = activo;
    }

    public Integer getIdRol() {
        return idRol;
    }

    public void setIdRol(Integer idRol) {
        this.idRol = idRol;
    }

    public String getNombreRol() {
        return nombreRol;
    }

    public void setNombreRol(String nombreRol) {
        this.nombreRol = nombreRol;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
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

    public Integer getUsuarioCreacion() {
        return usuarioCreacion;
    }

    public void setUsuarioCreacion(Integer usuarioCreacion) {
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

    
    @JsonIgnore
    public List<TtSaRolComponente> getTtSaRolComponenteList() {
        return ttSaRolComponenteList;
    }

    public void setTtSaRolComponenteList(List<TtSaRolComponente> ttSaRolComponenteList) {
        this.ttSaRolComponenteList = ttSaRolComponenteList;
    }

//    @XmlTransient
//    @JsonIgnore
//    public List<TtSaAplicacionRol> getTtSaAplicacionRolList() {
//        return ttSaAplicacionRolList;
//    }
//
//    public void setTtSaAplicacionRolList(List<TtSaAplicacionRol> ttSaAplicacionRolList) {
//        this.ttSaAplicacionRolList = ttSaAplicacionRolList;
//    }
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idRol != null ? idRol.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TcSaRol)) {
            return false;
        }
        TcSaRol other = (TcSaRol) object;
        if ((this.idRol == null && other.idRol != null) || (this.idRol != null && !this.idRol.equals(other.idRol))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gt.gob.mspas.seguridad.entity.TcSaRol[ idRol=" + idRol + " ]";
    }

}
