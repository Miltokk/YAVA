/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidad;

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
 * @author Miltokk
 */
@Entity
@Table(name = "reporteavancecontenidotematico")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Reporteavancecontenidotematico.findAll", query = "SELECT r FROM Reporteavancecontenidotematico r"),
    @NamedQuery(name = "Reporteavancecontenidotematico.findByRACid", query = "SELECT r FROM Reporteavancecontenidotematico r WHERE r.rACid = :rACid"),
    @NamedQuery(name = "Reporteavancecontenidotematico.findByRACnumero", query = "SELECT r FROM Reporteavancecontenidotematico r WHERE r.rACnumero = :rACnumero"),
    @NamedQuery(name = "Reporteavancecontenidotematico.findByRACfechaElaboracion", query = "SELECT r FROM Reporteavancecontenidotematico r WHERE r.rACfechaElaboracion = :rACfechaElaboracion"),
    @NamedQuery(name = "Reporteavancecontenidotematico.findByRACavanceGlobal", query = "SELECT r FROM Reporteavancecontenidotematico r WHERE r.rACavanceGlobal = :rACavanceGlobal"),
    @NamedQuery(name = "Reporteavancecontenidotematico.findByRACstatus", query = "SELECT r FROM Reporteavancecontenidotematico r WHERE r.rACstatus = :rACstatus")})
public class Reporteavancecontenidotematico implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "RACid")
    private Integer rACid;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "RACnumero")
    private String rACnumero;
    @Basic(optional = false)
    @NotNull
    @Column(name = "RACfechaElaboracion")
    @Temporal(TemporalType.DATE)
    private Date rACfechaElaboracion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "RACavanceGlobal")
    private float rACavanceGlobal;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 8)
    @Column(name = "RACstatus")
    private String rACstatus;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "reporteAvanceContenidoTematicoRACid")
    private Collection<Reporte> reporteCollection;
    @JoinColumn(name = "UnidadAprendizaje_imparte_profesor_UIPid", referencedColumnName = "UIPid")
    @ManyToOne(optional = false)
    private UnidadaprendizajeImparteProfesor unidadAprendizajeimparteprofesorUIPid;

    public Reporteavancecontenidotematico() {
    }

    public Reporteavancecontenidotematico(Integer rACid) {
        this.rACid = rACid;
    }

    public Reporteavancecontenidotematico(Integer rACid, String rACnumero, Date rACfechaElaboracion, float rACavanceGlobal, String rACstatus) {
        this.rACid = rACid;
        this.rACnumero = rACnumero;
        this.rACfechaElaboracion = rACfechaElaboracion;
        this.rACavanceGlobal = rACavanceGlobal;
        this.rACstatus = rACstatus;
    }

    public Integer getRACid() {
        return rACid;
    }

    public void setRACid(Integer rACid) {
        this.rACid = rACid;
    }

    public String getRACnumero() {
        return rACnumero;
    }

    public void setRACnumero(String rACnumero) {
        this.rACnumero = rACnumero;
    }

    public Date getRACfechaElaboracion() {
        return rACfechaElaboracion;
    }

    public void setRACfechaElaboracion(Date rACfechaElaboracion) {
        this.rACfechaElaboracion = rACfechaElaboracion;
    }

    public float getRACavanceGlobal() {
        return rACavanceGlobal;
    }

    public void setRACavanceGlobal(float rACavanceGlobal) {
        this.rACavanceGlobal = rACavanceGlobal;
    }

    public String getRACstatus() {
        return rACstatus;
    }

    public void setRACstatus(String rACstatus) {
        this.rACstatus = rACstatus;
    }

    @XmlTransient
    public Collection<Reporte> getReporteCollection() {
        return reporteCollection;
    }

    public void setReporteCollection(Collection<Reporte> reporteCollection) {
        this.reporteCollection = reporteCollection;
    }

    public UnidadaprendizajeImparteProfesor getUnidadAprendizajeimparteprofesorUIPid() {
        return unidadAprendizajeimparteprofesorUIPid;
    }

    public void setUnidadAprendizajeimparteprofesorUIPid(UnidadaprendizajeImparteProfesor unidadAprendizajeimparteprofesorUIPid) {
        this.unidadAprendizajeimparteprofesorUIPid = unidadAprendizajeimparteprofesorUIPid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (rACid != null ? rACid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Reporteavancecontenidotematico)) {
            return false;
        }
        Reporteavancecontenidotematico other = (Reporteavancecontenidotematico) object;
        if ((this.rACid == null && other.rACid != null) || (this.rACid != null && !this.rACid.equals(other.rACid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidad.Reporteavancecontenidotematico[ rACid=" + rACid + " ]";
    }
    
}
