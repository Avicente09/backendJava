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
@Table(name = "tc_red_de_servicio")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TcRedDeServicio.findAll", query = "SELECT t FROM TcRedDeServicio t")})
public class TcRedDeServicio implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_red_servicio")
    private Integer idRedServicio;
    @Basic(optional = false)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @Column(name = "descripcion")
    private String descripcion;
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
    @Column(name = "activo")
    private Boolean activo;
//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idRedServicio")
//    private List<TtSaPersona> ttSaPersonaList;

    public TcRedDeServicio() {
    }

    public TcRedDeServicio(Integer idRedServicio) {
        this.idRedServicio = idRedServicio;
    }

    public TcRedDeServicio(Integer idRedServicio, String nombre, String descripcion, int usuarioCreacion, Date fechaCreacion) {
        this.idRedServicio = idRedServicio;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.usuarioCreacion = usuarioCreacion;
        this.fechaCreacion = fechaCreacion;
    }

    public Integer getIdRedServicio() {
        return idRedServicio;
    }

    public void setIdRedServicio(Integer idRedServicio) {
        this.idRedServicio = idRedServicio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
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

    public Boolean getActivo() {
        return activo;
    }

    public void setActivo(Boolean activo) {
        this.activo = activo;
    }

//    @XmlTransient
//    @JsonIgnore
//    public List<TtSaPersona> getTtSaPersonaList() {
//        return ttSaPersonaList;
//    }
//
//    public void setTtSaPersonaList(List<TtSaPersona> ttSaPersonaList) {
//        this.ttSaPersonaList = ttSaPersonaList;
//    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idRedServicio != null ? idRedServicio.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TcRedDeServicio)) {
            return false;
        }
        TcRedDeServicio other = (TcRedDeServicio) object;
        if ((this.idRedServicio == null && other.idRedServicio != null) || (this.idRedServicio != null && !this.idRedServicio.equals(other.idRedServicio))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gt.gob.mspas.seguridad.entity.TcRedDeServicio[ idRedServicio=" + idRedServicio + " ]";
    }
    
}
