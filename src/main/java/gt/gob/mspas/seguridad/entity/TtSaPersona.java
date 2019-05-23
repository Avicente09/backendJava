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
@Table(name = "tt_sa_persona")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TtSaPersona.findAll", query = "SELECT t FROM TtSaPersona t")})
public class TtSaPersona implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_persona")
    private Integer idPersona;
    @Basic(optional = false)
    @Column(name = "cui")
    private int cui;
    @Basic(optional = false)
    @Column(name = "primer_nombre")
    private String primerNombre;
    @Column(name = "segundo_nombre")
    private String segundoNombre;
    @Basic(optional = false)
    @Column(name = "primer_apellido")
    private String primerApellido;
    @Column(name = "segundo_apellido")
    private String segundoApellido;
    @Column(name = "apellido_casada")
    private String apellidoCasada;
    @Column(name = "fecha_nacimiento")
    @Temporal(TemporalType.DATE)
    private Date fechaNacimiento;
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
    @Column(name = "id_red_servicio")
    private Integer idRedServicio;

    @Formula(value = "primer_nombre || ' ' || CASE WHEN segundo_nombre is null THEN '' ELSE segundo_nombre END || ' ' || primer_apellido || ' ' || CASE WHEN segundo_apellido is null THEN '' ELSE segundo_apellido END")
    private String personaConcatenada;

    public TtSaPersona() {
    }

    public TtSaPersona(Integer idPersona) {
        this.idPersona = idPersona;
    }

    public TtSaPersona(Integer idPersona, int cui, String primerNombre, String primerApellido, Date fechaCreacion, boolean activo) {
        this.idPersona = idPersona;
        this.cui = cui;
        this.primerNombre = primerNombre;
        this.primerApellido = primerApellido;
        this.fechaCreacion = fechaCreacion;
        this.activo = activo;

    }

    public String getPersonaConcatenada() {
        return personaConcatenada;
    }

    public void setPersonaConcatenada(String personaConcatenada) {
        this.personaConcatenada = personaConcatenada;
    }

    public Integer getIdRedServicio() {
        return idRedServicio;
    }

    public void setIdRedServicio(Integer idRedServicio) {
        this.idRedServicio = idRedServicio;
    }

    public Integer getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(Integer idPersona) {
        this.idPersona = idPersona;
    }

    public int getCui() {
        return cui;
    }

    public void setCui(int cui) {
        this.cui = cui;
    }

    public String getPrimerNombre() {
        return primerNombre;
    }

    public void setPrimerNombre(String primerNombre) {
        this.primerNombre = primerNombre;
    }

    public String getSegundoNombre() {
        return segundoNombre;
    }

    public void setSegundoNombre(String segundoNombre) {
        this.segundoNombre = segundoNombre;
    }

    public String getPrimerApellido() {
        return primerApellido;
    }

    public void setPrimerApellido(String primerApellido) {
        this.primerApellido = primerApellido;
    }

    public String getSegundoApellido() {
        return segundoApellido;
    }

    public void setSegundoApellido(String segundoApellido) {
        this.segundoApellido = segundoApellido;
    }

    public String getApellidoCasada() {
        return apellidoCasada;
    }

    public void setApellidoCasada(String apellidoCasada) {
        this.apellidoCasada = apellidoCasada;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
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

//    @XmlTransient
//    @JsonIgnore
//    public List<TtSaUsuario> getTtSaUsuarioList() {
//        return ttSaUsuarioList;
//    }
//
//    public void setTtSaUsuarioList(List<TtSaUsuario> ttSaUsuarioList) {
//        this.ttSaUsuarioList = ttSaUsuarioList;
//    }
//
//    public TcRedDeServicio getIdRedServicio() {
//        return idRedServicio;
//    }
//
//    public void setIdRedServicio(TcRedDeServicio idRedServicio) {
//        this.idRedServicio = idRedServicio;
//    }
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPersona != null ? idPersona.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TtSaPersona)) {
            return false;
        }
        TtSaPersona other = (TtSaPersona) object;
        if ((this.idPersona == null && other.idPersona != null) || (this.idPersona != null && !this.idPersona.equals(other.idPersona))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gt.gob.mspas.seguridad.entity.TtSaPersona[ idPersona=" + idPersona + " ]";
    }

}
