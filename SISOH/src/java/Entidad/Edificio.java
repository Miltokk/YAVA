/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidad;

import java.io.Serializable;
import java.util.Collection;
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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Miltokk
 */
@Entity
@Table(name = "edificio")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Edificio.findAll", query = "SELECT e FROM Edificio e"),
    @NamedQuery(name = "Edificio.findByEdificioId", query = "SELECT e FROM Edificio e WHERE e.edificioId = :edificioId"),
    @NamedQuery(name = "Edificio.findByNombreEdificio", query = "SELECT e FROM Edificio e WHERE e.nombreEdificio = :nombreEdificio"),
    @NamedQuery(name = "Edificio.findByPlantas", query = "SELECT e FROM Edificio e WHERE e.plantas = :plantas")})
public class Edificio implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "edificioId")
    private Integer edificioId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 70)
    @Column(name = "nombreEdificio")
    private String nombreEdificio;
    @Basic(optional = false)
    @NotNull
    @Column(name = "plantas")
    private int plantas;
    @JoinColumn(name = "UACid", referencedColumnName = "UACid")
    @ManyToOne(optional = false)
    private Unidadacademica uACid;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "edificioId")
    private Collection<Salon> salonCollection;

    public Edificio() {
    }

    public Edificio(Integer edificioId) {
        this.edificioId = edificioId;
    }

    public Edificio(Integer edificioId, String nombreEdificio, int plantas) {
        this.edificioId = edificioId;
        this.nombreEdificio = nombreEdificio;
        this.plantas = plantas;
    }

    public Integer getEdificioId() {
        return edificioId;
    }

    public void setEdificioId(Integer edificioId) {
        this.edificioId = edificioId;
    }

    public String getNombreEdificio() {
        return nombreEdificio;
    }

    public void setNombreEdificio(String nombreEdificio) {
        this.nombreEdificio = nombreEdificio;
    }

    public int getPlantas() {
        return plantas;
    }

    public void setPlantas(int plantas) {
        this.plantas = plantas;
    }

    public Unidadacademica getUACid() {
        return uACid;
    }

    public void setUACid(Unidadacademica uACid) {
        this.uACid = uACid;
    }

    @XmlTransient
    public Collection<Salon> getSalonCollection() {
        return salonCollection;
    }

    public void setSalonCollection(Collection<Salon> salonCollection) {
        this.salonCollection = salonCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (edificioId != null ? edificioId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Edificio)) {
            return false;
        }
        Edificio other = (Edificio) object;
        if ((this.edificioId == null && other.edificioId != null) || (this.edificioId != null && !this.edificioId.equals(other.edificioId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidad.Edificio[ edificioId=" + edificioId + " ]";
    }
    
}
