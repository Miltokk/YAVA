/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidad;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Miltokk
 */
@Embeddable
public class CoordinadorareaadministrativaPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "Profesor_PROid")
    private int profesorPROid;
    @Basic(optional = false)
    @NotNull
    @Column(name = "UnidadAprendizaje_UAPid")
    private int unidadAprendizajeUAPid;

    public CoordinadorareaadministrativaPK() {
    }

    public CoordinadorareaadministrativaPK(int profesorPROid, int unidadAprendizajeUAPid) {
        this.profesorPROid = profesorPROid;
        this.unidadAprendizajeUAPid = unidadAprendizajeUAPid;
    }

    public int getProfesorPROid() {
        return profesorPROid;
    }

    public void setProfesorPROid(int profesorPROid) {
        this.profesorPROid = profesorPROid;
    }

    public int getUnidadAprendizajeUAPid() {
        return unidadAprendizajeUAPid;
    }

    public void setUnidadAprendizajeUAPid(int unidadAprendizajeUAPid) {
        this.unidadAprendizajeUAPid = unidadAprendizajeUAPid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) profesorPROid;
        hash += (int) unidadAprendizajeUAPid;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CoordinadorareaadministrativaPK)) {
            return false;
        }
        CoordinadorareaadministrativaPK other = (CoordinadorareaadministrativaPK) object;
        if (this.profesorPROid != other.profesorPROid) {
            return false;
        }
        if (this.unidadAprendizajeUAPid != other.unidadAprendizajeUAPid) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidad.CoordinadorareaadministrativaPK[ profesorPROid=" + profesorPROid + ", unidadAprendizajeUAPid=" + unidadAprendizajeUAPid + " ]";
    }
    
}
