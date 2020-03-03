/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package upb.tabd.entidades;

import java.io.Serializable;
import java.util.Collection;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author B09S105est
 */
@Entity
@Table(name = "Raza")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Raza.findAll", query = "SELECT r FROM Raza r")
    , @NamedQuery(name = "Raza.findByIdRaza", query = "SELECT r FROM Raza r WHERE r.idRaza = :idRaza")
    , @NamedQuery(name = "Raza.findByRaza", query = "SELECT r FROM Raza r WHERE r.raza = :raza")})
public class Raza implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IdRaza")
    private Long idRaza;
    @Size(max = 255)
    @Column(name = "Raza")
    private String raza;
    @JoinColumn(name = "IdEspecie", referencedColumnName = "IdEspecie")
    @ManyToOne
    private Especie idEspecie;
    @OneToMany(mappedBy = "idRaza")
    private Collection<Mascota> mascotaCollection;

    public Raza() {
    }

    public Raza(Long idRaza) {
        this.idRaza = idRaza;
    }

    public Long getIdRaza() {
        return idRaza;
    }

    public void setIdRaza(Long idRaza) {
        this.idRaza = idRaza;
    }

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    public Especie getIdEspecie() {
        return idEspecie;
    }

    public void setIdEspecie(Especie idEspecie) {
        this.idEspecie = idEspecie;
    }

    @XmlTransient
    public Collection<Mascota> getMascotaCollection() {
        return mascotaCollection;
    }

    public void setMascotaCollection(Collection<Mascota> mascotaCollection) {
        this.mascotaCollection = mascotaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idRaza != null ? idRaza.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Raza)) {
            return false;
        }
        Raza other = (Raza) object;
        if ((this.idRaza == null && other.idRaza != null) || (this.idRaza != null && !this.idRaza.equals(other.idRaza))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "upb.tabd.entidades.Raza[ idRaza=" + idRaza + " ]";
    }
    
}
