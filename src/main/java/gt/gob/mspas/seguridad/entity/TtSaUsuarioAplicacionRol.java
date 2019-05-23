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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Ottoniel RT
 */
@Entity
@Table(name = "tt_sa_usuario_aplicacion_rol")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TtSaUsuarioAplicacionRol.findAll", query = "SELECT t FROM TtSaUsuarioAplicacionRol t")})
public class TtSaUsuarioAplicacionRol implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_usuario_aplicacion_rol")
    private Integer idUsuarioAplicacionRol;

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
    @JoinColumn(name = "id_usuario", referencedColumnName = "id_usuario")
    @ManyToOne(optional = false)
    private TtSaUsuario idUsuario;
//    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER, mappedBy = "idAplicacionRol")
//    private List<TtSaRolComponente> ttSaAplicacionRolList;

    //  @Basic(optional = false)
    @JoinColumn(name = "id_aplicacion_rol", referencedColumnName = "id_aplicacion_rol")
    @ManyToOne(optional = false)
    private TtSaAplicacionRol idAplicacionRol;

    public TtSaUsuarioAplicacionRol() {
    }

    public TtSaUsuarioAplicacionRol(Integer idUsuarioAplicacionRol) {
        this.idUsuarioAplicacionRol = idUsuarioAplicacionRol;
    }

    public TtSaUsuarioAplicacionRol(Integer idUsuarioAplicacionRol, int idAplicacionRol, int usuarioCreacion, Date fechaCreacion, boolean activo) {
        this.idUsuarioAplicacionRol = idUsuarioAplicacionRol;

        this.usuarioCreacion = usuarioCreacion;
        this.fechaCreacion = fechaCreacion;
        this.activo = activo;
    }

    public Integer getIdUsuarioAplicacionRol() {
        return idUsuarioAplicacionRol;
    }

    public void setIdUsuarioAplicacionRol(Integer idUsuarioAplicacionRol) {
        this.idUsuarioAplicacionRol = idUsuarioAplicacionRol;
    }

    public TtSaAplicacionRol getIdAplicacionRol() {
        return idAplicacionRol;
    }

    public void setIdAplicacionRol(TtSaAplicacionRol idAplicacionRol) {
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

    public TtSaUsuario getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(TtSaUsuario idUsuario) {
        this.idUsuario = idUsuario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idUsuarioAplicacionRol != null ? idUsuarioAplicacionRol.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TtSaUsuarioAplicacionRol)) {
            return false;
        }
        TtSaUsuarioAplicacionRol other = (TtSaUsuarioAplicacionRol) object;
        if ((this.idUsuarioAplicacionRol == null && other.idUsuarioAplicacionRol != null) || (this.idUsuarioAplicacionRol != null && !this.idUsuarioAplicacionRol.equals(other.idUsuarioAplicacionRol))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gt.gob.mspas.seguridad.entity.TtSaUsuarioAplicacionRol[ idUsuarioAplicacionRol=" + idUsuarioAplicacionRol + " ]";
    }

}
