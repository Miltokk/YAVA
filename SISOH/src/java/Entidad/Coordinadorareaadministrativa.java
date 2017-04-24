/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidad;

import java.io.Serializable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Miltokk
 */
@Entity
@Table(name = "coordinadorareaadministrativa")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Coordinadorareaadministrativa.findAll", query = "SELECT c FROM Coordinadorareaadministrativa c"),
    @NamedQuery(name = "Coordinadorareaadministrativa.findByProfesorPROid", query = "SELECT c FROM Coordinadorareaadministrativa c WHERE c.coordinadorareaadministrativaPK.profesorPROid = :profesorPROid"),
    @NamedQuery(name = "Coordinadorareaadministrativa.findByUnidadAprendizajeUAPid", query = "SELECT c FROM Coordinadorareaadministrativa c WHERE c.coordinadorareaadministrativaPK.unidadAprendizajeUAPid = :unidadAprendizajeUAPid")})
public class Coordinadorareaadministrativa implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected CoordinadorareaadministrativaPK coordinadorareaadministrativaPK;
    @JoinColumn(name = "AreaAdministrativa_AADid", referencedColumnName = "AADid")
    @ManyToOne(optional = false)
    private Areaadministrativa areaAdministrativaAADid;
    @JoinColumn(name = "Profesor_PROid", referencedColumnName = "PROid", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Profesor profesor;
    @JoinColumn(name = "UnidadAprendizaje_UAPid", referencedColumnName = "UAPid", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Unidadaprendizaje unidadaprendizaje;

    public Coordinadorareaadministrativa() {
    }

    public Coordinadorareaadministrativa(CoordinadorareaadministrativaPK coordinadorareaadministrativaPK) {
        this.coordinadorareaadministrativaPK = coordinadorareaadministrativaPK;
    }

    public Coordinadorareaadministrativa(int profesorPROid, int unidadAprendizajeUAPid) {
        this.coordinadorareaadministrativaPK = new CoordinadorareaadministrativaPK(profesorPROid, unidadAprendizajeUAPid);
    }

    public CoordinadorareaadministrativaPK getCoordinadorareaadministrativaPK() {
        return coordinadorareaadministrativaPK;
    }

    public void setCoordinadorareaadministrativaPK(CoordinadorareaadministrativaPK coordinadorareaadministrativaPK) {
        this.coordinadorareaadministrativaPK = coordinadorareaadministrativaPK;
    }

    public Areaadministrativa getAreaAdministrativaAADid() {
        return areaAdministrativaAADid;
    }

    public void setAreaAdministrativaAADid(Areaadministrativa areaAdministrativaAADid) {
        this.areaAdministrativaAADid = areaAdministrativaAADid;
    }

    public Profesor getProfesor() {
        return profesor;
    }

    public void setProfesor(Profesor profesor) {
        this.profesor = profesor;
    }

    public Unidadaprendizaje getUnidadaprendizaje() {
        return unidadaprendizaje;
    }

    public void setUnidadaprendizaje(Unidadaprendizaje unidadaprendizaje) {
        this.unidadaprendizaje = unidadaprendizaje;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (coordinadorareaadministrativaPK != null ? coordinadorareaadministrativaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Coordinadorareaadministrativa)) {
            return false;
        }
        Coordinadorareaadministrativa other = (Coordinadorareaadministrativa) object;
        if ((this.coordinadorareaadministrativaPK == null && other.coordinadorareaadministrativaPK != null) || (this.coordinadorareaadministrativaPK != null && !this.coordinadorareaadministrativaPK.equals(other.coordinadorareaadministrativaPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidad.Coordinadorareaadministrativa[ coordinadorareaadministrativaPK=" + coordinadorareaadministrativaPK + " ]";
    }
    
}
