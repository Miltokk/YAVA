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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Miltokk
 */
@Entity
@Table(name = "alerta")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Alerta.findAll", query = "SELECT a FROM Alerta a"),
    @NamedQuery(name = "Alerta.findByALEid", query = "SELECT a FROM Alerta a WHERE a.aLEid = :aLEid"),
    @NamedQuery(name = "Alerta.findByALEtipo", query = "SELECT a FROM Alerta a WHERE a.aLEtipo = :aLEtipo"),
    @NamedQuery(name = "Alerta.findByALEcolor", query = "SELECT a FROM Alerta a WHERE a.aLEcolor = :aLEcolor")})
public class Alerta implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ALEid")
    private Integer aLEid;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "ALEtipo")
    private String aLEtipo;
    @Size(max = 7)
    @Column(name = "ALEcolor")
    private String aLEcolor;
    @OneToMany(mappedBy = "alertaALEid")
    private Collection<Configuracion> configuracionCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "alerta")
    private Collection<CalendarioreporteTieneAlerta> calendarioreporteTieneAlertaCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "alertaALEid")
    private Collection<Mensaje> mensajeCollection;

    public Alerta() {
    }

    public Alerta(Integer aLEid) {
        this.aLEid = aLEid;
    }

    public Alerta(Integer aLEid, String aLEtipo) {
        this.aLEid = aLEid;
        this.aLEtipo = aLEtipo;
    }

    public Integer getALEid() {
        return aLEid;
    }

    public void setALEid(Integer aLEid) {
        this.aLEid = aLEid;
    }

    public String getALEtipo() {
        return aLEtipo;
    }

    public void setALEtipo(String aLEtipo) {
        this.aLEtipo = aLEtipo;
    }

    public String getALEcolor() {
        return aLEcolor;
    }

    public void setALEcolor(String aLEcolor) {
        this.aLEcolor = aLEcolor;
    }

    @XmlTransient
    public Collection<Configuracion> getConfiguracionCollection() {
        return configuracionCollection;
    }

    public void setConfiguracionCollection(Collection<Configuracion> configuracionCollection) {
        this.configuracionCollection = configuracionCollection;
    }

    @XmlTransient
    public Collection<CalendarioreporteTieneAlerta> getCalendarioreporteTieneAlertaCollection() {
        return calendarioreporteTieneAlertaCollection;
    }

    public void setCalendarioreporteTieneAlertaCollection(Collection<CalendarioreporteTieneAlerta> calendarioreporteTieneAlertaCollection) {
        this.calendarioreporteTieneAlertaCollection = calendarioreporteTieneAlertaCollection;
    }

    @XmlTransient
    public Collection<Mensaje> getMensajeCollection() {
        return mensajeCollection;
    }

    public void setMensajeCollection(Collection<Mensaje> mensajeCollection) {
        this.mensajeCollection = mensajeCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (aLEid != null ? aLEid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Alerta)) {
            return false;
        }
        Alerta other = (Alerta) object;
        if ((this.aLEid == null && other.aLEid != null) || (this.aLEid != null && !this.aLEid.equals(other.aLEid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidad.Alerta[ aLEid=" + aLEid + " ]";
    }
    
}
