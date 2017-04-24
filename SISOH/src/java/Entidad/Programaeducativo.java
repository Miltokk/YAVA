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
import javax.persistence.ManyToMany;
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
@Table(name = "programaeducativo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Programaeducativo.findAll", query = "SELECT p FROM Programaeducativo p"),
    @NamedQuery(name = "Programaeducativo.findByPEDid", query = "SELECT p FROM Programaeducativo p WHERE p.pEDid = :pEDid"),
    @NamedQuery(name = "Programaeducativo.findByPEDclave", query = "SELECT p FROM Programaeducativo p WHERE p.pEDclave = :pEDclave"),
    @NamedQuery(name = "Programaeducativo.findByPEDnombre", query = "SELECT p FROM Programaeducativo p WHERE p.pEDnombre = :pEDnombre")})
public class Programaeducativo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "PEDid")
    private Integer pEDid;
    @Basic(optional = false)
    @NotNull
    @Column(name = "PEDclave")
    private int pEDclave;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "PEDnombre")
    private String pEDnombre;
    @ManyToMany(mappedBy = "programaeducativoCollection")
    private Collection<Profesor> profesorCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "programaEducativoPEDid")
    private Collection<Areaadministrativa> areaadministrativaCollection;
    @OneToMany(mappedBy = "programaEducativoPEDid")
    private Collection<Planestudio> planestudioCollection;
    @JoinColumn(name = "UnidadAcademica_UACid", referencedColumnName = "UACid")
    @ManyToOne
    private Unidadacademica unidadAcademicaUACid;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "programaeducativo")
    private Collection<ProfesorPerteneceProgramaeducativo> profesorPerteneceProgramaeducativoCollection;

    public Programaeducativo() {
    }

    public Programaeducativo(Integer pEDid) {
        this.pEDid = pEDid;
    }

    public Programaeducativo(Integer pEDid, int pEDclave, String pEDnombre) {
        this.pEDid = pEDid;
        this.pEDclave = pEDclave;
        this.pEDnombre = pEDnombre;
    }

    public Integer getPEDid() {
        return pEDid;
    }

    public void setPEDid(Integer pEDid) {
        this.pEDid = pEDid;
    }

    public int getPEDclave() {
        return pEDclave;
    }

    public void setPEDclave(int pEDclave) {
        this.pEDclave = pEDclave;
    }

    public String getPEDnombre() {
        return pEDnombre;
    }

    public void setPEDnombre(String pEDnombre) {
        this.pEDnombre = pEDnombre;
    }

    @XmlTransient
    public Collection<Profesor> getProfesorCollection() {
        return profesorCollection;
    }

    public void setProfesorCollection(Collection<Profesor> profesorCollection) {
        this.profesorCollection = profesorCollection;
    }

    @XmlTransient
    public Collection<Areaadministrativa> getAreaadministrativaCollection() {
        return areaadministrativaCollection;
    }

    public void setAreaadministrativaCollection(Collection<Areaadministrativa> areaadministrativaCollection) {
        this.areaadministrativaCollection = areaadministrativaCollection;
    }

    @XmlTransient
    public Collection<Planestudio> getPlanestudioCollection() {
        return planestudioCollection;
    }

    public void setPlanestudioCollection(Collection<Planestudio> planestudioCollection) {
        this.planestudioCollection = planestudioCollection;
    }

    public Unidadacademica getUnidadAcademicaUACid() {
        return unidadAcademicaUACid;
    }

    public void setUnidadAcademicaUACid(Unidadacademica unidadAcademicaUACid) {
        this.unidadAcademicaUACid = unidadAcademicaUACid;
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
        hash += (pEDid != null ? pEDid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Programaeducativo)) {
            return false;
        }
        Programaeducativo other = (Programaeducativo) object;
        if ((this.pEDid == null && other.pEDid != null) || (this.pEDid != null && !this.pEDid.equals(other.pEDid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidad.Programaeducativo[ pEDid=" + pEDid + " ]";
    }
    
}
