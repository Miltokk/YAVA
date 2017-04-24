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
@Table(name = "unidadaprendizaje")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Unidadaprendizaje.findAll", query = "SELECT u FROM Unidadaprendizaje u"),
    @NamedQuery(name = "Unidadaprendizaje.findByUAPid", query = "SELECT u FROM Unidadaprendizaje u WHERE u.uAPid = :uAPid"),
    @NamedQuery(name = "Unidadaprendizaje.findByUAPclave", query = "SELECT u FROM Unidadaprendizaje u WHERE u.uAPclave = :uAPclave"),
    @NamedQuery(name = "Unidadaprendizaje.findByUAPnombre", query = "SELECT u FROM Unidadaprendizaje u WHERE u.uAPnombre = :uAPnombre"),
    @NamedQuery(name = "Unidadaprendizaje.findByUAPetapaFormacion", query = "SELECT u FROM Unidadaprendizaje u WHERE u.uAPetapaFormacion = :uAPetapaFormacion"),
    @NamedQuery(name = "Unidadaprendizaje.findByUAPcreditos", query = "SELECT u FROM Unidadaprendizaje u WHERE u.uAPcreditos = :uAPcreditos"),
    @NamedQuery(name = "Unidadaprendizaje.findByUAPhorasClase", query = "SELECT u FROM Unidadaprendizaje u WHERE u.uAPhorasClase = :uAPhorasClase"),
    @NamedQuery(name = "Unidadaprendizaje.findByUAPhorasLaboratorio", query = "SELECT u FROM Unidadaprendizaje u WHERE u.uAPhorasLaboratorio = :uAPhorasLaboratorio"),
    @NamedQuery(name = "Unidadaprendizaje.findByUAPhorasTaller", query = "SELECT u FROM Unidadaprendizaje u WHERE u.uAPhorasTaller = :uAPhorasTaller"),
    @NamedQuery(name = "Unidadaprendizaje.findByUAPhorasClinica", query = "SELECT u FROM Unidadaprendizaje u WHERE u.uAPhorasClinica = :uAPhorasClinica"),
    @NamedQuery(name = "Unidadaprendizaje.findByUAPhorasCampo", query = "SELECT u FROM Unidadaprendizaje u WHERE u.uAPhorasCampo = :uAPhorasCampo"),
    @NamedQuery(name = "Unidadaprendizaje.findByUAPhorasExtraClase", query = "SELECT u FROM Unidadaprendizaje u WHERE u.uAPhorasExtraClase = :uAPhorasExtraClase"),
    @NamedQuery(name = "Unidadaprendizaje.findByUAPtipoCaracter", query = "SELECT u FROM Unidadaprendizaje u WHERE u.uAPtipoCaracter = :uAPtipoCaracter"),
    @NamedQuery(name = "Unidadaprendizaje.findByUAPhorasClaseCompletas", query = "SELECT u FROM Unidadaprendizaje u WHERE u.uAPhorasClaseCompletas = :uAPhorasClaseCompletas"),
    @NamedQuery(name = "Unidadaprendizaje.findByUAPhorasLaboratorioCompletas", query = "SELECT u FROM Unidadaprendizaje u WHERE u.uAPhorasLaboratorioCompletas = :uAPhorasLaboratorioCompletas"),
    @NamedQuery(name = "Unidadaprendizaje.findByUAPhorasTallerCompletas", query = "SELECT u FROM Unidadaprendizaje u WHERE u.uAPhorasTallerCompletas = :uAPhorasTallerCompletas"),
    @NamedQuery(name = "Unidadaprendizaje.findByUAPhorasCampoCompletas", query = "SELECT u FROM Unidadaprendizaje u WHERE u.uAPhorasCampoCompletas = :uAPhorasCampoCompletas")})
public class Unidadaprendizaje implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "UAPid")
    private Integer uAPid;
    @Basic(optional = false)
    @NotNull
    @Column(name = "UAPclave")
    private int uAPclave;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 150)
    @Column(name = "UAPnombre")
    private String uAPnombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 13)
    @Column(name = "UAPetapaFormacion")
    private String uAPetapaFormacion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "UAPcreditos")
    private int uAPcreditos;
    @Column(name = "UAPhorasClase")
    private Integer uAPhorasClase;
    @Column(name = "UAPhorasLaboratorio")
    private Integer uAPhorasLaboratorio;
    @Column(name = "UAPhorasTaller")
    private Integer uAPhorasTaller;
    @Column(name = "UAPhorasClinica")
    private Integer uAPhorasClinica;
    @Column(name = "UAPhorasCampo")
    private Integer uAPhorasCampo;
    @Column(name = "UAPhorasExtraClase")
    private Integer uAPhorasExtraClase;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 11)
    @Column(name = "UAPtipoCaracter")
    private String uAPtipoCaracter;
    @Column(name = "UAPhorasClaseCompletas")
    private Boolean uAPhorasClaseCompletas;
    @Column(name = "UAPhorasLaboratorioCompletas")
    private Boolean uAPhorasLaboratorioCompletas;
    @Column(name = "UAPhorasTallerCompletas")
    private Boolean uAPhorasTallerCompletas;
    @Column(name = "UAPhorasCampoCompletas")
    private Boolean uAPhorasCampoCompletas;
    @ManyToMany(mappedBy = "unidadaprendizajeCollection")
    private Collection<Areaconocimiento> areaconocimientoCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "unidadAprendizajeUAPid")
    private Collection<Practicasclinica> practicasclinicaCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "unidadAprendizajeUAPid")
    private Collection<Practicataller> practicatallerCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "unidadAprendizajeUAPid")
    private Collection<Practicascampo> practicascampoCollection;
    @JoinColumn(name = "CicloEscolar_CESid", referencedColumnName = "CESid")
    @ManyToOne
    private Cicloescolar cicloEscolarCESid;
    @OneToMany(mappedBy = "unidadAprendizajeUAPid")
    private Collection<Unidadaprendizaje> unidadaprendizajeCollection;
    @JoinColumn(name = "UnidadAprendizaje_UAPid", referencedColumnName = "UAPid")
    @ManyToOne
    private Unidadaprendizaje unidadAprendizajeUAPid;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "unidadAprendizajeUAPid")
    private Collection<UnidadaprendizajeImparteProfesor> unidadaprendizajeImparteProfesorCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "unidadaprendizaje")
    private Collection<Coordinadorareaadministrativa> coordinadorareaadministrativaCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "unidadAprendizajeUAPid")
    private Collection<Unidad> unidadCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "unidadAprendizajeUAPid")
    private Collection<Practicalaboratorio> practicalaboratorioCollection;

    public Unidadaprendizaje() {
    }

    public Unidadaprendizaje(Integer uAPid) {
        this.uAPid = uAPid;
    }

    public Unidadaprendizaje(Integer uAPid, int uAPclave, String uAPnombre, String uAPetapaFormacion, int uAPcreditos, String uAPtipoCaracter) {
        this.uAPid = uAPid;
        this.uAPclave = uAPclave;
        this.uAPnombre = uAPnombre;
        this.uAPetapaFormacion = uAPetapaFormacion;
        this.uAPcreditos = uAPcreditos;
        this.uAPtipoCaracter = uAPtipoCaracter;
    }

    public Integer getUAPid() {
        return uAPid;
    }

    public void setUAPid(Integer uAPid) {
        this.uAPid = uAPid;
    }

    public int getUAPclave() {
        return uAPclave;
    }

    public void setUAPclave(int uAPclave) {
        this.uAPclave = uAPclave;
    }

    public String getUAPnombre() {
        return uAPnombre;
    }

    public void setUAPnombre(String uAPnombre) {
        this.uAPnombre = uAPnombre;
    }

    public String getUAPetapaFormacion() {
        return uAPetapaFormacion;
    }

    public void setUAPetapaFormacion(String uAPetapaFormacion) {
        this.uAPetapaFormacion = uAPetapaFormacion;
    }

    public int getUAPcreditos() {
        return uAPcreditos;
    }

    public void setUAPcreditos(int uAPcreditos) {
        this.uAPcreditos = uAPcreditos;
    }

    public Integer getUAPhorasClase() {
        return uAPhorasClase;
    }

    public void setUAPhorasClase(Integer uAPhorasClase) {
        this.uAPhorasClase = uAPhorasClase;
    }

    public Integer getUAPhorasLaboratorio() {
        return uAPhorasLaboratorio;
    }

    public void setUAPhorasLaboratorio(Integer uAPhorasLaboratorio) {
        this.uAPhorasLaboratorio = uAPhorasLaboratorio;
    }

    public Integer getUAPhorasTaller() {
        return uAPhorasTaller;
    }

    public void setUAPhorasTaller(Integer uAPhorasTaller) {
        this.uAPhorasTaller = uAPhorasTaller;
    }

    public Integer getUAPhorasClinica() {
        return uAPhorasClinica;
    }

    public void setUAPhorasClinica(Integer uAPhorasClinica) {
        this.uAPhorasClinica = uAPhorasClinica;
    }

    public Integer getUAPhorasCampo() {
        return uAPhorasCampo;
    }

    public void setUAPhorasCampo(Integer uAPhorasCampo) {
        this.uAPhorasCampo = uAPhorasCampo;
    }

    public Integer getUAPhorasExtraClase() {
        return uAPhorasExtraClase;
    }

    public void setUAPhorasExtraClase(Integer uAPhorasExtraClase) {
        this.uAPhorasExtraClase = uAPhorasExtraClase;
    }

    public String getUAPtipoCaracter() {
        return uAPtipoCaracter;
    }

    public void setUAPtipoCaracter(String uAPtipoCaracter) {
        this.uAPtipoCaracter = uAPtipoCaracter;
    }

    public Boolean getUAPhorasClaseCompletas() {
        return uAPhorasClaseCompletas;
    }

    public void setUAPhorasClaseCompletas(Boolean uAPhorasClaseCompletas) {
        this.uAPhorasClaseCompletas = uAPhorasClaseCompletas;
    }

    public Boolean getUAPhorasLaboratorioCompletas() {
        return uAPhorasLaboratorioCompletas;
    }

    public void setUAPhorasLaboratorioCompletas(Boolean uAPhorasLaboratorioCompletas) {
        this.uAPhorasLaboratorioCompletas = uAPhorasLaboratorioCompletas;
    }

    public Boolean getUAPhorasTallerCompletas() {
        return uAPhorasTallerCompletas;
    }

    public void setUAPhorasTallerCompletas(Boolean uAPhorasTallerCompletas) {
        this.uAPhorasTallerCompletas = uAPhorasTallerCompletas;
    }

    public Boolean getUAPhorasCampoCompletas() {
        return uAPhorasCampoCompletas;
    }

    public void setUAPhorasCampoCompletas(Boolean uAPhorasCampoCompletas) {
        this.uAPhorasCampoCompletas = uAPhorasCampoCompletas;
    }

    @XmlTransient
    public Collection<Areaconocimiento> getAreaconocimientoCollection() {
        return areaconocimientoCollection;
    }

    public void setAreaconocimientoCollection(Collection<Areaconocimiento> areaconocimientoCollection) {
        this.areaconocimientoCollection = areaconocimientoCollection;
    }

    @XmlTransient
    public Collection<Practicasclinica> getPracticasclinicaCollection() {
        return practicasclinicaCollection;
    }

    public void setPracticasclinicaCollection(Collection<Practicasclinica> practicasclinicaCollection) {
        this.practicasclinicaCollection = practicasclinicaCollection;
    }

    @XmlTransient
    public Collection<Practicataller> getPracticatallerCollection() {
        return practicatallerCollection;
    }

    public void setPracticatallerCollection(Collection<Practicataller> practicatallerCollection) {
        this.practicatallerCollection = practicatallerCollection;
    }

    @XmlTransient
    public Collection<Practicascampo> getPracticascampoCollection() {
        return practicascampoCollection;
    }

    public void setPracticascampoCollection(Collection<Practicascampo> practicascampoCollection) {
        this.practicascampoCollection = practicascampoCollection;
    }

    public Cicloescolar getCicloEscolarCESid() {
        return cicloEscolarCESid;
    }

    public void setCicloEscolarCESid(Cicloescolar cicloEscolarCESid) {
        this.cicloEscolarCESid = cicloEscolarCESid;
    }

    @XmlTransient
    public Collection<Unidadaprendizaje> getUnidadaprendizajeCollection() {
        return unidadaprendizajeCollection;
    }

    public void setUnidadaprendizajeCollection(Collection<Unidadaprendizaje> unidadaprendizajeCollection) {
        this.unidadaprendizajeCollection = unidadaprendizajeCollection;
    }

    public Unidadaprendizaje getUnidadAprendizajeUAPid() {
        return unidadAprendizajeUAPid;
    }

    public void setUnidadAprendizajeUAPid(Unidadaprendizaje unidadAprendizajeUAPid) {
        this.unidadAprendizajeUAPid = unidadAprendizajeUAPid;
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

    @XmlTransient
    public Collection<Unidad> getUnidadCollection() {
        return unidadCollection;
    }

    public void setUnidadCollection(Collection<Unidad> unidadCollection) {
        this.unidadCollection = unidadCollection;
    }

    @XmlTransient
    public Collection<Practicalaboratorio> getPracticalaboratorioCollection() {
        return practicalaboratorioCollection;
    }

    public void setPracticalaboratorioCollection(Collection<Practicalaboratorio> practicalaboratorioCollection) {
        this.practicalaboratorioCollection = practicalaboratorioCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (uAPid != null ? uAPid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Unidadaprendizaje)) {
            return false;
        }
        Unidadaprendizaje other = (Unidadaprendizaje) object;
        if ((this.uAPid == null && other.uAPid != null) || (this.uAPid != null && !this.uAPid.equals(other.uAPid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidad.Unidadaprendizaje[ uAPid=" + uAPid + " ]";
    }
    
}
