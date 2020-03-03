/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package upb.tabd.entidades;

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
 * @author B09S105est
 */
@Entity
@Table(name = "Vacunacion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Vacunacion.findAll", query = "SELECT v FROM Vacunacion v")
    , @NamedQuery(name = "Vacunacion.findByNroVacunacion", query = "SELECT v FROM Vacunacion v WHERE v.nroVacunacion = :nroVacunacion")
    , @NamedQuery(name = "Vacunacion.findByFecha", query = "SELECT v FROM Vacunacion v WHERE v.fecha = :fecha")
    , @NamedQuery(name = "Vacunacion.findByVieneDuenio", query = "SELECT v FROM Vacunacion v WHERE v.vieneDuenio = :vieneDuenio")
    , @NamedQuery(name = "Vacunacion.findByBuenasCondiciones", query = "SELECT v FROM Vacunacion v WHERE v.buenasCondiciones = :buenasCondiciones")
    , @NamedQuery(name = "Vacunacion.findByReaccionAlergica", query = "SELECT v FROM Vacunacion v WHERE v.reaccionAlergica = :reaccionAlergica")
    , @NamedQuery(name = "Vacunacion.findByEnTratamiento", query = "SELECT v FROM Vacunacion v WHERE v.enTratamiento = :enTratamiento")})
public class Vacunacion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "NroVacunacion")
    private Long nroVacunacion;
    @Column(name = "Fecha")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;
    @Column(name = "VieneDuenio")
    private Boolean vieneDuenio;
    @Column(name = "BuenasCondiciones")
    private Boolean buenasCondiciones;
    @Column(name = "ReaccionAlergica")
    private Boolean reaccionAlergica;
    @Column(name = "EnTratamiento")
    private Boolean enTratamiento;
    @JoinColumn(name = "IdMascota", referencedColumnName = "Id")
    @ManyToOne(optional = false)
    private Mascota idMascota;
    @JoinColumn(name = "IdVacuna", referencedColumnName = "Id")
    @ManyToOne
    private Vacuna idVacuna;

    public Vacunacion() {
    }

    public Vacunacion(Long nroVacunacion) {
        this.nroVacunacion = nroVacunacion;
    }

    public Long getNroVacunacion() {
        return nroVacunacion;
    }

    public void setNroVacunacion(Long nroVacunacion) {
        this.nroVacunacion = nroVacunacion;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Boolean getVieneDuenio() {
        return vieneDuenio;
    }

    public void setVieneDuenio(Boolean vieneDuenio) {
        this.vieneDuenio = vieneDuenio;
    }

    public Boolean getBuenasCondiciones() {
        return buenasCondiciones;
    }

    public void setBuenasCondiciones(Boolean buenasCondiciones) {
        this.buenasCondiciones = buenasCondiciones;
    }

    public Boolean getReaccionAlergica() {
        return reaccionAlergica;
    }

    public void setReaccionAlergica(Boolean reaccionAlergica) {
        this.reaccionAlergica = reaccionAlergica;
    }

    public Boolean getEnTratamiento() {
        return enTratamiento;
    }

    public void setEnTratamiento(Boolean enTratamiento) {
        this.enTratamiento = enTratamiento;
    }

    public Mascota getIdMascota() {
        return idMascota;
    }

    public void setIdMascota(Mascota idMascota) {
        this.idMascota = idMascota;
    }

    public Vacuna getIdVacuna() {
        return idVacuna;
    }

    public void setIdVacuna(Vacuna idVacuna) {
        this.idVacuna = idVacuna;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (nroVacunacion != null ? nroVacunacion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Vacunacion)) {
            return false;
        }
        Vacunacion other = (Vacunacion) object;
        if ((this.nroVacunacion == null && other.nroVacunacion != null) || (this.nroVacunacion != null && !this.nroVacunacion.equals(other.nroVacunacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "upb.tabd.entidades.Vacunacion[ nroVacunacion=" + nroVacunacion + " ]";
    }
    
}
