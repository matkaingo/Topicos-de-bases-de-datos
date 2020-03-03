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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author B09S105est
 */
@Entity
@Table(name = "Especie")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Especie.findAll", query = "SELECT e FROM Especie e")
    , @NamedQuery(name = "Especie.findByIdEspecie", query = "SELECT e FROM Especie e WHERE e.idEspecie = :idEspecie")
    , @NamedQuery(name = "Especie.findByEspecie", query = "SELECT e FROM Especie e WHERE e.especie = :especie")})
public class Especie implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IdEspecie")
    private Integer idEspecie;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "Especie")
    private String especie;
    @OneToMany(mappedBy = "idEspecie")
    private Collection<Raza> razaCollection;

    public Especie() {
    }

    public Especie(Integer idEspecie) {
        this.idEspecie = idEspecie;
    }

    public Especie(Integer idEspecie, String especie) {
        this.idEspecie = idEspecie;
        this.especie = especie;
    }

    public Integer getIdEspecie() {
        return idEspecie;
    }

    public void setIdEspecie(Integer idEspecie) {
        this.idEspecie = idEspecie;
    }

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    @XmlTransient
    public Collection<Raza> getRazaCollection() {
        return razaCollection;
    }

    public void setRazaCollection(Collection<Raza> razaCollection) {
        this.razaCollection = razaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEspecie != null ? idEspecie.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Especie)) {
            return false;
        }
        Especie other = (Especie) object;
        if ((this.idEspecie == null && other.idEspecie != null) || (this.idEspecie != null && !this.idEspecie.equals(other.idEspecie))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "upb.tabd.entidades.Especie[ idEspecie=" + idEspecie + " ]";
    }
    
}
