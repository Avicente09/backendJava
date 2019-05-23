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
import org.hibernate.annotations.Formula;

/**
 *
 * @author Ottoniel RT
 */
@Entity
@Table(name = "tt_sa_usuario")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TtSaUsuario.findAll", query = "SELECT t FROM TtSaUsuario t")})
public class TtSaUsuario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_usuario")
    private Integer idUsuario;
    @Basic(optional = false)
    @Column(name = "usuario")
    private String usuario;
    @Basic(optional = false)
    @Column(name = "correo_electronico")
    private String correoElectronico;
    @Column(name = "telefono")
    private Integer telefono;
    @Column(name = "password")
    private String password;
    @Column(name = "reset_password")
    private Boolean resetPassword;
    @Column(name = "fecha_caducidad_ingreso")
    @Temporal(TemporalType.DATE)
    private Date fechaCaducidadIngreso;
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
    @Column(name = "fecha_modificacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaModificacion;
    @Column(name = "usuario_modificacion")
    private Integer usuarioModificacion;
    @Basic(optional = false)

//    @Column(name = "sa_personaid_persona")
//    private int saPersonaidPersona;
    @JoinColumn(name = "id_persona", referencedColumnName = "id_persona")
    @ManyToOne(optional = false)
    private TtSaPersona idPersona;
    @Column(name = "id_tipo_usuario")
    private Integer idTipoUsuario;

//    @JoinColumn(name = "id_tipo_usuario", referencedColumnName = "id_tipo_usuario")
//    @ManyToOne(optional = false)
//    private TtSaTipoUsuario idTipoUsuario;
//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idUsuario")
//    private List<TtSaBitacora> ttSaBitacoraList;
//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idUsuario")
//    private List<TcSaUsuarioAplicacionRol> tcSaUsuarioAplicacionRolList;
    public TtSaUsuario() {
    }

    public TtSaUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public TtSaUsuario(Integer idUsuario, String usuario, String correoElectronico, int usuarioCreacion, Date fechaCreacion, boolean activo, int saPersonaidPersona) {
        this.idUsuario = idUsuario;
        this.usuario = usuario;
        this.correoElectronico = correoElectronico;
        this.usuarioCreacion = usuarioCreacion;
        this.fechaCreacion = fechaCreacion;
        this.activo = activo;
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public Integer getTelefono() {
        return telefono;
    }

    public void setTelefono(Integer telefono) {
        this.telefono = telefono;
    }

    public Boolean getResetPassword() {
        return resetPassword;
    }

    public void setResetPassword(Boolean resetPassword) {
        this.resetPassword = resetPassword;
    }

    public Date getFechaCaducidadIngreso() {
        return fechaCaducidadIngreso;
    }

    public void setFechaCaducidadIngreso(Date fechaCaducidadIngreso) {
        this.fechaCaducidadIngreso = fechaCaducidadIngreso;
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

    public Date getFechaModificacion() {
        return fechaModificacion;
    }

    public void setFechaModificacion(Date fechaModificacion) {
        this.fechaModificacion = fechaModificacion;
    }

    @JsonIgnore
    public String getPassword() {
        return password;
    }

    @JsonIgnore
    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getUsuarioModificacion() {
        return usuarioModificacion;
    }

    public void setUsuarioModificacion(Integer usuarioModificacion) {
        this.usuarioModificacion = usuarioModificacion;
    }

    public TtSaPersona getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(TtSaPersona idPersona) {
        this.idPersona = idPersona;
    }

//    public TtSaTipoUsuario getIdTipoUsuario() {
//        return idTipoUsuario;
//    }
//
//    public void setIdTipoUsuario(TtSaTipoUsuario idTipoUsuario) {
//        this.idTipoUsuario = idTipoUsuario;
//    }
//
//    @XmlTransient
//    @JsonIgnore
//    public List<TtSaBitacora> getTtSaBitacoraList() {
//        return ttSaBitacoraList;
//    }
//    public void setTtSaBitacoraList(List<TtSaBitacora> ttSaBitacoraList) {
//        this.ttSaBitacoraList = ttSaBitacoraList;
//    }
//
//    @XmlTransient
//    @JsonIgnore
//    public List<TcSaUsuarioAplicacionRol> getTcSaUsuarioAplicacionRolList() {
//        return tcSaUsuarioAplicacionRolList;
//    }
//
//    public void setTcSaUsuarioAplicacionRolList(List<TcSaUsuarioAplicacionRol> tcSaUsuarioAplicacionRolList) {
//        this.tcSaUsuarioAplicacionRolList = tcSaUsuarioAplicacionRolList;
//    }
    public Integer getIdTipoUsuario() {
        return idTipoUsuario;
    }

    public void setIdTipoUsuario(Integer idTipoUsuario) {
        this.idTipoUsuario = idTipoUsuario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idUsuario != null ? idUsuario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TtSaUsuario)) {
            return false;
        }
        TtSaUsuario other = (TtSaUsuario) object;
        if ((this.idUsuario == null && other.idUsuario != null) || (this.idUsuario != null && !this.idUsuario.equals(other.idUsuario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gt.gob.mspas.seguridad.entity.TtSaUsuario[ idUsuario=" + idUsuario + " ]";
    }

}
