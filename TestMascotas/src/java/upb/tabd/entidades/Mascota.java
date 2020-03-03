/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package upb.tabd.entidades;

import java.io.Serializable;
import java.util.Collection;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author B09S105est
 */
@Entity
@Table(name = "Mascota")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Mascota.findAll", query = "SELECT m FROM Mascota m")
    , @NamedQuery(name = "Mascota.findById", query = "SELECT m FROM Mascota m WHERE m.id = :id")
    , @NamedQuery(name = "Mascota.findByNombre", query = "SELECT m FROM Mascota m WHERE m.nombre = :nombre")
    , @NamedQuery(name = "Mascota.findByTieneChip", query = "SELECT m FROM Mascota m WHERE m.tieneChip = :tieneChip")
    , @NamedQuery(name = "Mascota.findByFechaIngreso", query = "SELECT m FROM Mascota m WHERE m.fechaIngreso = :fechaIngreso")
    , @NamedQuery(name = "Mascota.findByFechaModificacion", query = "SELECT m FROM Mascota m WHERE m.fechaModificacion = :fechaModificacion")})
public class Mascota implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Id")
    private Long id;
    @Size(max = 255)
    @Column(name = "Nombre")
    private String nombre;
    @Column(name = "TieneChip")
    private Boolean tieneChip;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FechaIngreso")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaIngreso;
    @Column(name = "FechaModificacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaModificacion;
    @JoinColumn(name = "IdentCliente", referencedColumnName = "IdentCliente")
    @ManyToOne(optional = false)
    private Cliente identCliente;
    @JoinColumn(name = "IdRaza", referencedColumnName = "IdRaza")
    @ManyToOne
    private Raza idRaza;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idMascota")
    private Collection<ControlPeso> controlPesoCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idMascota")
    private Collection<Vacunacion> vacunacionCollection;

    public Mascota() {
    }

    public Mascota(Long id) {
        this.id = id;
    }

    public Mascota(Long id, Date fechaIngreso) {
        this.id = id;
        this.fechaIngreso = fechaIngreso;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Boolean getTieneChip() {
        return tieneChip;
    }

    public void setTieneChip(Boolean tieneChip) {
        this.tieneChip = tieneChip;
    }

    public Date getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(Date fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public Date getFechaModificacion() {
        return fechaModificacion;
    }

    public void setFechaModificacion(Date fechaModificacion) {
        this.fechaModificacion = fechaModificacion;
    }

    public Cliente getIdentCliente() {
        return identCliente;
    }

    public void setIdentCliente(Cliente identCliente) {
        this.identCliente = identCliente;
    }

    public Raza getIdRaza() {
        return idRaza;
    }

    public void setIdRaza(Raza idRaza) {
        this.idRaza = idRaza;
    }

    @XmlTransient
    public Collection<ControlPeso> getControlPesoCollection() {
        return controlPesoCollection;
    }

    public void setControlPesoCollection(Collection<ControlPeso> controlPesoCollection) {
        this.controlPesoCollection = controlPesoCollection;
    }

    @XmlTransient
    public Collection<Vacunacion> getVacunacionCollection() {
        return vacunacionCollection;
    }

    public void setVacunacionCollection(Collection<Vacunacion> vacunacionCollection) {
        this.vacunacionCollection = vacunacionCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Mascota)) {
            return false;
        }
        Mascota other = (Mascota) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "upb.tabd.entidades.Mascota[ id=" + id + " ]";
    }
    
}
