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
@Table(name = "practicasclinica")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Practicasclinica.findAll", query = "SELECT p FROM Practicasclinica p"),
    @NamedQuery(name = "Practicasclinica.findByPRCid", query = "SELECT p FROM Practicasclinica p WHERE p.pRCid = :pRCid"),
    @NamedQuery(name = "Practicasclinica.findByPRCnumero", query = "SELECT p FROM Practicasclinica p WHERE p.pRCnumero = :pRCnumero"),
    @NamedQuery(name = "Practicasclinica.findByPRCnombre", query = "SELECT p FROM Practicasclinica p WHERE p.pRCnombre = :pRCnombre"),
    @NamedQuery(name = "Practicasclinica.findByPRCvalorPorcentaje", query = "SELECT p FROM Practicasclinica p WHERE p.pRCvalorPorcentaje = :pRCvalorPorcentaje"),
    @NamedQuery(name = "Practicasclinica.findByPRChoras", query = "SELECT p FROM Practicasclinica p WHERE p.pRChoras = :pRChoras")})
public class Practicasclinica implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "PRCid")
    private Integer pRCid;
    @Column(name = "PRCnumero")
    private Integer pRCnumero;
    @Size(max = 120)
    @Column(name = "PRCnombre")
    private String pRCnombre;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "PRCvalorPorcentaje")
    private Float pRCvalorPorcentaje;
    @Column(name = "PRChoras")
    private Integer pRChoras;
    @JoinColumn(name = "UnidadAprendizaje_UAPid", referencedColumnName = "UAPid")
    @ManyToOne(optional = false)
    private Unidadaprendizaje unidadAprendizajeUAPid;

    public Practicasclinica() {
    }

    public Practicasclinica(Integer pRCid) {
        this.pRCid = pRCid;
    }

    public Integer getPRCid() {
        return pRCid;
    }

    public void setPRCid(Integer pRCid) {
        this.pRCid = pRCid;
    }

    public Integer getPRCnumero() {
        return pRCnumero;
    }

    public void setPRCnumero(Integer pRCnumero) {
        this.pRCnumero = pRCnumero;
    }

    public String getPRCnombre() {
        return pRCnombre;
    }

    public void setPRCnombre(String pRCnombre) {
        this.pRCnombre = pRCnombre;
    }

    public Float getPRCvalorPorcentaje() {
        return pRCvalorPorcentaje;
    }

    public void setPRCvalorPorcentaje(Float pRCvalorPorcentaje) {
        this.pRCvalorPorcentaje = pRCvalorPorcentaje;
    }

    public Integer getPRChoras() {
        return pRChoras;
    }

    public void setPRChoras(Integer pRChoras) {
        this.pRChoras = pRChoras;
    }

    public Unidadaprendizaje getUnidadAprendizajeUAPid() {
        return unidadAprendizajeUAPid;
    }

    public void setUnidadAprendizajeUAPid(Unidadaprendizaje unidadAprendizajeUAPid) {
        this.unidadAprendizajeUAPid = unidadAprendizajeUAPid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pRCid != null ? pRCid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Practicasclinica)) {
            return false;
        }
        Practicasclinica other = (Practicasclinica) object;
        if ((this.pRCid == null && other.pRCid != null) || (this.pRCid != null && !this.pRCid.equals(other.pRCid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidad.Practicasclinica[ pRCid=" + pRCid + " ]";
    }
    
}
