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
@Table(name = "unidadacademica")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Unidadacademica.findAll", query = "SELECT u FROM Unidadacademica u"),
    @NamedQuery(name = "Unidadacademica.findByUACid", query = "SELECT u FROM Unidadacademica u WHERE u.uACid = :uACid"),
    @NamedQuery(name = "Unidadacademica.findByUACclave", query = "SELECT u FROM Unidadacademica u WHERE u.uACclave = :uACclave"),
    @NamedQuery(name = "Unidadacademica.findByUACnombre", query = "SELECT u FROM Unidadacademica u WHERE u.uACnombre = :uACnombre"),
    @NamedQuery(name = "Unidadacademica.findByUACtipo", query = "SELECT u FROM Unidadacademica u WHERE u.uACtipo = :uACtipo")})
public class Unidadacademica implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "UACid")
    private Integer uACid;
    @Basic(optional = false)
    @NotNull
    @Column(name = "UACclave")
    private int uACclave;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "UACnombre")
    private String uACnombre;
    @Size(max = 45)
    @Column(name = "UACtipo")
    private String uACtipo;
    @ManyToMany(mappedBy = "unidadacademicaCollection")
    private Collection<Profesor> profesorCollection;
    @OneToMany(mappedBy = "unidadAcademicaUACid")
    private Collection<Programaeducativo> programaeducativoCollection;
    @JoinColumn(name = "Campus_CAMid", referencedColumnName = "CAMid")
    @ManyToOne
    private Campus campusCAMid;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "uACid")
    private Collection<Edificio> edificioCollection;

    public Unidadacademica() {
    }

    public Unidadacademica(Integer uACid) {
        this.uACid = uACid;
    }

    public Unidadacademica(Integer uACid, int uACclave, String uACnombre) {
        this.uACid = uACid;
        this.uACclave = uACclave;
        this.uACnombre = uACnombre;
    }

    public Integer getUACid() {
        return uACid;
    }

    public void setUACid(Integer uACid) {
        this.uACid = uACid;
    }

    public int getUACclave() {
        return uACclave;
    }

    public void setUACclave(int uACclave) {
        this.uACclave = uACclave;
    }

    public String getUACnombre() {
        return uACnombre;
    }

    public void setUACnombre(String uACnombre) {
        this.uACnombre = uACnombre;
    }

    public String getUACtipo() {
        return uACtipo;
    }

    public void setUACtipo(String uACtipo) {
        this.uACtipo = uACtipo;
    }

    @XmlTransient
    public Collection<Profesor> getProfesorCollection() {
        return profesorCollection;
    }

    public void setProfesorCollection(Collection<Profesor> profesorCollection) {
        this.profesorCollection = profesorCollection;
    }

    @XmlTransient
    public Collection<Programaeducativo> getProgramaeducativoCollection() {
        return programaeducativoCollection;
    }

    public void setProgramaeducativoCollection(Collection<Programaeducativo> programaeducativoCollection) {
        this.programaeducativoCollection = programaeducativoCollection;
    }

    public Campus getCampusCAMid() {
        return campusCAMid;
    }

    public void setCampusCAMid(Campus campusCAMid) {
        this.campusCAMid = campusCAMid;
    }

    @XmlTransient
    public Collection<Edificio> getEdificioCollection() {
        return edificioCollection;
    }

    public void setEdificioCollection(Collection<Edificio> edificioCollection) {
        this.edificioCollection = edificioCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (uACid != null ? uACid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Unidadacademica)) {
            return false;
        }
        Unidadacademica other = (Unidadacademica) object;
        if ((this.uACid == null && other.uACid != null) || (this.uACid != null && !this.uACid.equals(other.uACid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidad.Unidadacademica[ uACid=" + uACid + " ]";
    }
    
}
