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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author B09S105est
 */
@Entity
@Table(name = "ControlPeso")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ControlPeso.findAll", query = "SELECT c FROM ControlPeso c")
    , @NamedQuery(name = "ControlPeso.findByNroControl", query = "SELECT c FROM ControlPeso c WHERE c.nroControl = :nroControl")
    , @NamedQuery(name = "ControlPeso.findByFecha", query = "SELECT c FROM ControlPeso c WHERE c.fecha = :fecha")
    , @NamedQuery(name = "ControlPeso.findByPeso", query = "SELECT c FROM ControlPeso c WHERE c.peso = :peso")
    , @NamedQuery(name = "ControlPeso.findByVieneDuenio", query = "SELECT c FROM ControlPeso c WHERE c.vieneDuenio = :vieneDuenio")
    , @NamedQuery(name = "ControlPeso.findByBuenasCondiciones", query = "SELECT c FROM ControlPeso c WHERE c.buenasCondiciones = :buenasCondiciones")})
public class ControlPeso implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "NroControl")
    private Long nroControl;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Fecha")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "Peso")
    private String peso;
    @Basic(optional = false)
    @NotNull
    @Column(name = "VieneDuenio")
    private boolean vieneDuenio;
    @Basic(optional = false)
    @NotNull
    @Column(name = "BuenasCondiciones")
    private boolean buenasCondiciones;
    @JoinColumn(name = "IdMascota", referencedColumnName = "Id")
    @ManyToOne(optional = false)
    private Mascota idMascota;

    public ControlPeso() {
    }

    public ControlPeso(Long nroControl) {
        this.nroControl = nroControl;
    }

    public ControlPeso(Long nroControl, Date fecha, String peso, boolean vieneDuenio, boolean buenasCondiciones) {
        this.nroControl = nroControl;
        this.fecha = fecha;
        this.peso = peso;
        this.vieneDuenio = vieneDuenio;
        this.buenasCondiciones = buenasCondiciones;
    }

    public Long getNroControl() {
        return nroControl;
    }

    public void setNroControl(Long nroControl) {
        this.nroControl = nroControl;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getPeso() {
        return peso;
    }

    public void setPeso(String peso) {
        this.peso = peso;
    }

    public boolean getVieneDuenio() {
        return vieneDuenio;
    }

    public void setVieneDuenio(boolean vieneDuenio) {
        this.vieneDuenio = vieneDuenio;
    }

    public boolean getBuenasCondiciones() {
        return buenasCondiciones;
    }

    public void setBuenasCondiciones(boolean buenasCondiciones) {
        this.buenasCondiciones = buenasCondiciones;
    }

    public Mascota getIdMascota() {
        return idMascota;
    }

    public void setIdMascota(Mascota idMascota) {
        this.idMascota = idMascota;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (nroControl != null ? nroControl.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ControlPeso)) {
            return false;
        }
        ControlPeso other = (ControlPeso) object;
        if ((this.nroControl == null && other.nroControl != null) || (this.nroControl != null && !this.nroControl.equals(other.nroControl))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "upb.tabd.entidades.ControlPeso[ nroControl=" + nroControl + " ]";
    }
    
}
