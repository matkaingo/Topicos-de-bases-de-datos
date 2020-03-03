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
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name = "Vacuna")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Vacuna.findAll", query = "SELECT v FROM Vacuna v")
    , @NamedQuery(name = "Vacuna.findById", query = "SELECT v FROM Vacuna v WHERE v.id = :id")
    , @NamedQuery(name = "Vacuna.findByVacuna", query = "SELECT v FROM Vacuna v WHERE v.vacuna = :vacuna")
    , @NamedQuery(name = "Vacuna.findByContraindicaciones", query = "SELECT v FROM Vacuna v WHERE v.contraindicaciones = :contraindicaciones")
    , @NamedQuery(name = "Vacuna.findByFechaCreacion", query = "SELECT v FROM Vacuna v WHERE v.fechaCreacion = :fechaCreacion")
    , @NamedQuery(name = "Vacuna.findByFechaModificacion", query = "SELECT v FROM Vacuna v WHERE v.fechaModificacion = :fechaModificacion")
    , @NamedQuery(name = "Vacuna.findByActivo", query = "SELECT v FROM Vacuna v WHERE v.activo = :activo")})
public class Vacuna implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Id")
    private Long id;
    @Size(max = 255)
    @Column(name = "Vacuna")
    private String vacuna;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Contraindicaciones")
    private boolean contraindicaciones;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FechaCreacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaCreacion;
    @Column(name = "FechaModificacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaModificacion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Activo")
    private boolean activo;
    @OneToMany(mappedBy = "idVacuna")
    private Collection<Vacunacion> vacunacionCollection;

    public Vacuna() {
    }

    public Vacuna(Long id) {
        this.id = id;
    }

    public Vacuna(Long id, boolean contraindicaciones, Date fechaCreacion, boolean activo) {
        this.id = id;
        this.contraindicaciones = contraindicaciones;
        this.fechaCreacion = fechaCreacion;
        this.activo = activo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getVacuna() {
        return vacuna;
    }

    public void setVacuna(String vacuna) {
        this.vacuna = vacuna;
    }

    public boolean getContraindicaciones() {
        return contraindicaciones;
    }

    public void setContraindicaciones(boolean contraindicaciones) {
        this.contraindicaciones = contraindicaciones;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public Date getFechaModificacion() {
        return fechaModificacion;
    }

    public void setFechaModificacion(Date fechaModificacion) {
        this.fechaModificacion = fechaModificacion;
    }

    public boolean getActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
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
        if (!(object instanceof Vacuna)) {
            return false;
        }
        Vacuna other = (Vacuna) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "upb.tabd.entidades.Vacuna[ id=" + id + " ]";
    }
    
}
