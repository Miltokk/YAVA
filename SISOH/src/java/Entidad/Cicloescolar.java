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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Miltokk
 */
@Entity
@Table(name = "cicloescolar")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cicloescolar.findAll", query = "SELECT c FROM Cicloescolar c"),
    @NamedQuery(name = "Cicloescolar.findByCESid", query = "SELECT c FROM Cicloescolar c WHERE c.cESid = :cESid"),
    @NamedQuery(name = "Cicloescolar.findByCEScicloEscolar", query = "SELECT c FROM Cicloescolar c WHERE c.cEScicloEscolar = :cEScicloEscolar")})
public class Cicloescolar implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "CESid")
    private Integer cESid;
    @Size(max = 6)
    @Column(name = "CEScicloEscolar")
    private String cEScicloEscolar;
    @OneToMany(mappedBy = "cicloEscolarCESid")
    private Collection<Configuracion> configuracionCollection;
    @OneToMany(mappedBy = "cicloEscolarCESid")
    private Collection<Unidadaprendizaje> unidadaprendizajeCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cicloEscolarCESid")
    private Collection<UnidadaprendizajeImparteProfesor> unidadaprendizajeImparteProfesorCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cicloescolar")
    private Collection<ProfesorPerteneceProgramaeducativo> profesorPerteneceProgramaeducativoCollection;

    public Cicloescolar() {
    }

    public Cicloescolar(Integer cESid) {
        this.cESid = cESid;
    }

    public Integer getCESid() {
        return cESid;
    }

    public void setCESid(Integer cESid) {
        this.cESid = cESid;
    }

    public String getCEScicloEscolar() {
        return cEScicloEscolar;
    }

    public void setCEScicloEscolar(String cEScicloEscolar) {
        this.cEScicloEscolar = cEScicloEscolar;
    }

    @XmlTransient
    public Collection<Configuracion> getConfiguracionCollection() {
        return configuracionCollection;
    }

    public void setConfiguracionCollection(Collection<Configuracion> configuracionCollection) {
        this.configuracionCollection = configuracionCollection;
    }

    @XmlTransient
    public Collection<Unidadaprendizaje> getUnidadaprendizajeCollection() {
        return unidadaprendizajeCollection;
    }

    public void setUnidadaprendizajeCollection(Collection<Unidadaprendizaje> unidadaprendizajeCollection) {
        this.unidadaprendizajeCollection = unidadaprendizajeCollection;
    }

    @XmlTransient
    public Collection<UnidadaprendizajeImparteProfesor> getUnidadaprendizajeImparteProfesorCollection() {
        return unidadaprendizajeImparteProfesorCollection;
    }

    public void setUnidadaprendizajeImparteProfesorCollection(Collection<UnidadaprendizajeImparteProfesor> unidadaprendizajeImparteProfesorCollection) {
        this.unidadaprendizajeImparteProfesorCollection = unidadaprendizajeImparteProfesorCollection;
    }

    @XmlTransient
    public Collection<ProfesorPerteneceProgramaeducativo> getProfesorPerteneceProgramaeducativoCollection() {
        return profesorPerteneceProgramaeducativoCollection;
    }

    public void setProfesorPerteneceProgramaeducativoCollection(Collection<ProfesorPerteneceProgramaeducativo> profesorPerteneceProgramaeducativoCollection) {
        this.profesorPerteneceProgramaeducativoCollection = profesorPerteneceProgramaeducativoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cESid != null ? cESid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cicloescolar)) {
            return false;
        }
        Cicloescolar other = (Cicloescolar) object;
        if ((this.cESid == null && other.cESid != null) || (this.cESid != null && !this.cESid.equals(other.cESid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidad.Cicloescolar[ cESid=" + cESid + " ]";
    }
    
}
