/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidad;

import java.io.Serializable;
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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Miltokk
 */
@Entity
@Table(name = "salon")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Salon.findAll", query = "SELECT s FROM Salon s"),
    @NamedQuery(name = "Salon.findBySalonId", query = "SELECT s FROM Salon s WHERE s.salonId = :salonId"),
    @NamedQuery(name = "Salon.findByPlanta", query = "SELECT s FROM Salon s WHERE s.planta = :planta"),
    @NamedQuery(name = "Salon.findByCapacidad", query = "SELECT s FROM Salon s WHERE s.capacidad = :capacidad"),
    @NamedQuery(name = "Salon.findByProyector", query = "SELECT s FROM Salon s WHERE s.proyector = :proyector"),
    @NamedQuery(name = "Salon.findByPizarraElectronica", query = "SELECT s FROM Salon s WHERE s.pizarraElectronica = :pizarraElectronica")})
public class Salon implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "salonId")
    private Integer salonId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "planta")
    private int planta;
    @Basic(optional = false)
    @NotNull
    @Column(name = "capacidad")
    private int capacidad;
    @Size(max = 3)
    @Column(name = "proyector")
    private String proyector;
    @Size(max = 3)
    @Column(name = "pizarraElectronica")
    private String pizarraElectronica;
    @JoinColumn(name = "edificioId", referencedColumnName = "edificioId")
    @ManyToOne(optional = false)
    private Edificio edificioId;

    public Salon() {
    }

    public Salon(Integer salonId) {
        this.salonId = salonId;
    }

    public Salon(Integer salonId, int planta, int capacidad) {
        this.salonId = salonId;
        this.planta = planta;
        this.capacidad = capacidad;
    }

    public Integer getSalonId() {
        return salonId;
    }

    public void setSalonId(Integer salonId) {
        this.salonId = salonId;
    }

    public int getPlanta() {
        return planta;
    }

    public void setPlanta(int planta) {
        this.planta = planta;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public String getProyector() {
        return proyector;
    }

    public void setProyector(String proyector) {
        this.proyector = proyector;
    }

    public String getPizarraElectronica() {
        return pizarraElectronica;
    }

    public void setPizarraElectronica(String pizarraElectronica) {
        this.pizarraElectronica = pizarraElectronica;
    }

    public Edificio getEdificioId() {
        return edificioId;
    }

    public void setEdificioId(Edificio edificioId) {
        this.edificioId = edificioId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (salonId != null ? salonId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Salon)) {
            return false;
        }
        Salon other = (Salon) object;
        if ((this.salonId == null && other.salonId != null) || (this.salonId != null && !this.salonId.equals(other.salonId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidad.Salon[ salonId=" + salonId + " ]";
    }
    
}
