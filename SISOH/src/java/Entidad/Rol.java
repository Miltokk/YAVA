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
@Table(name = "rol")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Rol.findAll", query = "SELECT r FROM Rol r"),
    @NamedQuery(name = "Rol.findByROLid", query = "SELECT r FROM Rol r WHERE r.rOLid = :rOLid"),
    @NamedQuery(name = "Rol.findByROLtipo", query = "SELECT r FROM Rol r WHERE r.rOLtipo = :rOLtipo"),
    @NamedQuery(name = "Rol.findByROLprioridad", query = "SELECT r FROM Rol r WHERE r.rOLprioridad = :rOLprioridad")})
public class Rol implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ROLid")
    private Integer rOLid;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 80)
    @Column(name = "ROLtipo")
    private String rOLtipo;
    @Column(name = "ROLprioridad")
    private Integer rOLprioridad;
    @JoinTable(name = "rol_tiene_usuario", joinColumns = {
        @JoinColumn(name = "Rol_ROLid", referencedColumnName = "ROLid")}, inverseJoinColumns = {
        @JoinColumn(name = "Usuario_USUid", referencedColumnName = "USUid")})
    @ManyToMany
    private Collection<Usuario> usuarioCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "rol")
    private Collection<RolHasPermiso> rolHasPermisoCollection;

    public Rol() {
    }

    public Rol(Integer rOLid) {
        this.rOLid = rOLid;
    }

    public Rol(Integer rOLid, String rOLtipo) {
        this.rOLid = rOLid;
        this.rOLtipo = rOLtipo;
    }

    public Integer getROLid() {
        return rOLid;
    }

    public void setROLid(Integer rOLid) {
        this.rOLid = rOLid;
    }

    public String getROLtipo() {
        return rOLtipo;
    }

    public void setROLtipo(String rOLtipo) {
        this.rOLtipo = rOLtipo;
    }

    public Integer getROLprioridad() {
        return rOLprioridad;
    }

    public void setROLprioridad(Integer rOLprioridad) {
        this.rOLprioridad = rOLprioridad;
    }

    @XmlTransient
    public Collection<Usuario> getUsuarioCollection() {
        return usuarioCollection;
    }

    public void setUsuarioCollection(Collection<Usuario> usuarioCollection) {
        this.usuarioCollection = usuarioCollection;
    }

    @XmlTransient
    public Collection<RolHasPermiso> getRolHasPermisoCollection() {
        return rolHasPermisoCollection;
    }

    public void setRolHasPermisoCollection(Collection<RolHasPermiso> rolHasPermisoCollection) {
        this.rolHasPermisoCollection = rolHasPermisoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (rOLid != null ? rOLid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Rol)) {
            return false;
        }
        Rol other = (Rol) object;
        if ((this.rOLid == null && other.rOLid != null) || (this.rOLid != null && !this.rOLid.equals(other.rOLid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidad.Rol[ rOLid=" + rOLid + " ]";
    }
    
}
