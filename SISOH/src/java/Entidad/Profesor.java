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
import javax.persistence.JoinTable;
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
@Table(name = "profesor")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Profesor.findAll", query = "SELECT p FROM Profesor p"),
    @NamedQuery(name = "Profesor.findByPROid", query = "SELECT p FROM Profesor p WHERE p.pROid = :pROid"),
    @NamedQuery(name = "Profesor.findByPROnumeroEmpleado", query = "SELECT p FROM Profesor p WHERE p.pROnumeroEmpleado = :pROnumeroEmpleado"),
    @NamedQuery(name = "Profesor.findByPROnombre", query = "SELECT p FROM Profesor p WHERE p.pROnombre = :pROnombre"),
    @NamedQuery(name = "Profesor.findByPROapellidoPaterno", query = "SELECT p FROM Profesor p WHERE p.pROapellidoPaterno = :pROapellidoPaterno"),
    @NamedQuery(name = "Profesor.findByPROapellidoMaterno", query = "SELECT p FROM Profesor p WHERE p.pROapellidoMaterno = :pROapellidoMaterno"),
    @NamedQuery(name = "Profesor.findByPROrfc", query = "SELECT p FROM Profesor p WHERE p.pROrfc = :pROrfc")})
public class Profesor implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "PROid")
    private Integer pROid;
    @Basic(optional = false)
    @NotNull
    @Column(name = "PROnumeroEmpleado")
    private int pROnumeroEmpleado;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "PROnombre")
    private String pROnombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "PROapellidoPaterno")
    private String pROapellidoPaterno;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "PROapellidoMaterno")
    private String pROapellidoMaterno;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "PROrfc")
    private String pROrfc;
    @ManyToMany(mappedBy = "profesorCollection")
    private Collection<Areaconocimiento> areaconocimientoCollection;
    @JoinTable(name = "profesor_pertenece_unidadacademica", joinColumns = {
        @JoinColumn(name = "Profesor_PROid", referencedColumnName = "PROid")}, inverseJoinColumns = {
        @JoinColumn(name = "UnidadAcademica_UACid", referencedColumnName = "UACid")})
    @ManyToMany
    private Collection<Unidadacademica> unidadacademicaCollection;
    @JoinTable(name = "responsableprogramaeducativo", joinColumns = {
        @JoinColumn(name = "Profesor_PROid", referencedColumnName = "PROid")}, inverseJoinColumns = {
        @JoinColumn(name = "ProgramaEducativo_PEDid", referencedColumnName = "PEDid")})
    @ManyToMany
    private Collection<Programaeducativo> programaeducativoCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "profesorPROid")
    private Collection<UnidadaprendizajeImparteProfesor> unidadaprendizajeImparteProfesorCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "profesor")
    private Collection<Coordinadorareaadministrativa> coordinadorareaadministrativaCollection;
    @JoinColumn(name = "Usuario_USUid", referencedColumnName = "USUid")
    @ManyToOne
    private Usuario usuarioUSUid;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "profesor")
    private Collection<ProfesorPerteneceProgramaeducativo> profesorPerteneceProgramaeducativoCollection;

    public Profesor() {
    }

    public Profesor(Integer pROid) {
        this.pROid = pROid;
    }

    public Profesor(Integer pROid, int pROnumeroEmpleado, String pROnombre, String pROapellidoPaterno, String pROapellidoMaterno, String pROrfc) {
        this.pROid = pROid;
        this.pROnumeroEmpleado = pROnumeroEmpleado;
        this.pROnombre = pROnombre;
        this.pROapellidoPaterno = pROapellidoPaterno;
        this.pROapellidoMaterno = pROapellidoMaterno;
        this.pROrfc = pROrfc;
    }

    public Integer getPROid() {
        return pROid;
    }

    public void setPROid(Integer pROid) {
        this.pROid = pROid;
    }

    public int getPROnumeroEmpleado() {
        return pROnumeroEmpleado;
    }

    public void setPROnumeroEmpleado(int pROnumeroEmpleado) {
        this.pROnumeroEmpleado = pROnumeroEmpleado;
    }

    public String getPROnombre() {
        return pROnombre;
    }

    public void setPROnombre(String pROnombre) {
        this.pROnombre = pROnombre;
    }

    public String getPROapellidoPaterno() {
        return pROapellidoPaterno;
    }

    public void setPROapellidoPaterno(String pROapellidoPaterno) {
        this.pROapellidoPaterno = pROapellidoPaterno;
    }

    public String getPROapellidoMaterno() {
        return pROapellidoMaterno;
    }

    public void setPROapellidoMaterno(String pROapellidoMaterno) {
        this.pROapellidoMaterno = pROapellidoMaterno;
    }

    public String getPROrfc() {
        return pROrfc;
    }

    public void setPROrfc(String pROrfc) {
        this.pROrfc = pROrfc;
    }

    @XmlTransient
    public Collection<Areaconocimiento> getAreaconocimientoCollection() {
        return areaconocimientoCollection;
    }

    public void setAreaconocimientoCollection(Collection<Areaconocimiento> areaconocimientoCollection) {
        this.areaconocimientoCollection = areaconocimientoCollection;
    }

    @XmlTransient
    public Collection<Unidadacademica> getUnidadacademicaCollection() {
        return unidadacademicaCollection;
    }

    public void setUnidadacademicaCollection(Collection<Unidadacademica> unidadacademicaCollection) {
        this.unidadacademicaCollection = unidadacademicaCollection;
    }

    @XmlTransient
    public Collection<Programaeducativo> getProgramaeducativoCollection() {
        return programaeducativoCollection;
    }

    public void setProgramaeducativoCollection(Collection<Programaeducativo> programaeducativoCollection) {
        this.programaeducativoCollection = programaeducativoCollection;
    }

    @XmlTransient
    public Collection<UnidadaprendizajeImparteProfesor> getUnidadaprendizajeImparteProfesorCollection() {
        return unidadaprendizajeImparteProfesorCollection;
    }

    public void setUnidadaprendizajeImparteProfesorCollection(Collection<UnidadaprendizajeImparteProfesor> unidadaprendizajeImparteProfesorCollection) {
        this.unidadaprendizajeImparteProfesorCollection = unidadaprendizajeImparteProfesorCollection;
    }

    @XmlTransient
    public Collection<Coordinadorareaadministrativa> getCoordinadorareaadministrativaCollection() {
        return coordinadorareaadministrativaCollection;
    }

    public void setCoordinadorareaadministrativaCollection(Collection<Coordinadorareaadministrativa> coordinadorareaadministrativaCollection) {
        this.coordinadorareaadministrativaCollection = coordinadorareaadministrativaCollection;
    }

    public Usuario getUsuarioUSUid() {
        return usuarioUSUid;
    }

    public void setUsuarioUSUid(Usuario usuarioUSUid) {
        this.usuarioUSUid = usuarioUSUid;
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
        hash += (pROid != null ? pROid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Profesor)) {
            return false;
        }
        Profesor other = (Profesor) object;
        if ((this.pROid == null && other.pROid != null) || (this.pROid != null && !this.pROid.equals(other.pROid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidad.Profesor[ pROid=" + pROid + " ]";
    }
    
}
