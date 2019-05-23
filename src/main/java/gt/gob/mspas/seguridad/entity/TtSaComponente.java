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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "tt_sa_componente")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TtSaComponente.findAll", query = "SELECT t FROM TtSaComponente t")})
public class TtSaComponente implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_componente")
    private Integer idComponente;
    @Basic(optional = false)
    @Column(name = "nombre_componente")
    private String nombreComponente;
    @Column(name = "descripcion")
    private String descripcion;
    @Column(name = "nodo_padre")
    private Integer nodoPadre;
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
    @Column(name = "id_aplicacion")
    private Integer idAplicacion;

//    @JoinColumn(name = "nodo_padre", referencedColumnName = "id_componente")
//    @ManyToOne(optional = false)
//    private TtSaComponente nodoPadre;
//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idComponente")
//    private List<TtSaRolComponente> ttSaRolComponenteList;
//    @JoinColumn(name = "id_aplicacion", referencedColumnName = "id_aplicacion")
//    @ManyToOne(optional = false)
//    private TcSaAplicacion idAplicacion;
    public TtSaComponente() {
    }

    public TtSaComponente(Integer idComponente) {
        this.idComponente = idComponente;
    }

    public TtSaComponente(Integer idComponente, String nombreComponente, int usuarioCreacion, Date fechaCreacion, boolean activo) {
        this.idComponente = idComponente;
        this.nombreComponente = nombreComponente;
        this.usuarioCreacion = usuarioCreacion;
        this.fechaCreacion = fechaCreacion;
        this.activo = activo;
    }

    public Integer getIdAplicacion() {
        return idAplicacion;
    }

    public void setIdAplicacion(Integer idAplicacion) {
        this.idAplicacion = idAplicacion;
    }

    public Integer getIdComponente() {
        return idComponente;
    }

    public void setIdComponente(Integer idComponente) {
        this.idComponente = idComponente;
    }

    public String getNombreComponente() {
        return nombreComponente;
    }

    public void setNombreComponente(String nombreComponente) {
        this.nombreComponente = nombreComponente;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Integer getNodoPadre() {
        return nodoPadre;
    }

    public void setNodoPadre(Integer nodoPadre) {
        this.nodoPadre = nodoPadre;
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

//        @XmlTransient
//    @JsonIgnore
//    public List<TtSaRolComponente> getTtSaRolComponenteList() {
//        return ttSaRolComponenteList;
//    }
//
//    public void setTtSaRolComponenteList(List<TtSaRolComponente> ttSaRolComponenteList) {
//        this.ttSaRolComponenteList = ttSaRolComponenteList;
//    }
//    public TcSaAplicacion getIdAplicacion() {
//        return idAplicacion;
//    }
//
//    public void setIdAplicacion(TcSaAplicacion idAplicacion) {
//        this.idAplicacion = idAplicacion;
//    }
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idComponente != null ? idComponente.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TtSaComponente)) {
            return false;
        }
        TtSaComponente other = (TtSaComponente) object;
        if ((this.idComponente == null && other.idComponente != null) || (this.idComponente != null && !this.idComponente.equals(other.idComponente))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gt.gob.mspas.seguridad.entity.TtSaComponente[ idComponente=" + idComponente + " ]";
    }

}
