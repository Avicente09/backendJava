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
@Table(name = "tt_sa_bitacora")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TtSaBitacora.findAll", query = "SELECT t FROM TtSaBitacora t")})
public class TtSaBitacora implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_bitacora")
    private Integer idBitacora;
    @Basic(optional = false)
    @Column(name = "usuario")
    private int usuario;
    @Column(name = "evento")
    private Integer evento;
    @Column(name = "origen_url")
    private String origenUrl;
    @Column(name = "usuario_modificacion")
    private Integer usuarioModificacion;
    @Column(name = "fecha_modificacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaModificacion;
    @Basic(optional = false)
    @Column(name = "usuario_creacion")
    private int usuarioCreacion;
    @Basic(optional = false)
    @Column(name = "fecha_accion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaAccion;
    @Basic(optional = false)
    @Column(name = "activo")
    private boolean activo;
    @JoinColumn(name = "id_accion", referencedColumnName = "id_accion")
    @ManyToOne(optional = false)
    private TcSaAccion idAccion;
    @JoinColumn(name = "id_usuario", referencedColumnName = "id_usuario")
    @ManyToOne(optional = false)
    private TtSaUsuario idUsuario;

    public TtSaBitacora() {
    }

    public TtSaBitacora(Integer idBitacora) {
        this.idBitacora = idBitacora;
    }

    public TtSaBitacora(Integer idBitacora, int usuario, int usuarioCreacion, Date fechaAccion, boolean activo) {
        this.idBitacora = idBitacora;
        this.usuario = usuario;
        this.usuarioCreacion = usuarioCreacion;
        this.fechaAccion = fechaAccion;
        this.activo = activo;
    }

    public Integer getIdBitacora() {
        return idBitacora;
    }

    public void setIdBitacora(Integer idBitacora) {
        this.idBitacora = idBitacora;
    }

    public int getUsuario() {
        return usuario;
    }

    public void setUsuario(int usuario) {
        this.usuario = usuario;
    }

    public Integer getEvento() {
        return evento;
    }

    public void setEvento(Integer evento) {
        this.evento = evento;
    }

    public String getOrigenUrl() {
        return origenUrl;
    }

    public void setOrigenUrl(String origenUrl) {
        this.origenUrl = origenUrl;
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

    public Date getFechaAccion() {
        return fechaAccion;
    }

    public void setFechaAccion(Date fechaAccion) {
        this.fechaAccion = fechaAccion;
    }

    public boolean getActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public TcSaAccion getIdAccion() {
        return idAccion;
    }

    public void setIdAccion(TcSaAccion idAccion) {
        this.idAccion = idAccion;
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
        hash += (idBitacora != null ? idBitacora.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TtSaBitacora)) {
            return false;
        }
        TtSaBitacora other = (TtSaBitacora) object;
        if ((this.idBitacora == null && other.idBitacora != null) || (this.idBitacora != null && !this.idBitacora.equals(other.idBitacora))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gt.gob.mspas.seguridad.entity.TtSaBitacora[ idBitacora=" + idBitacora + " ]";
    }
    
}
