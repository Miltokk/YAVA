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
@Table(name = "usuario")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Usuario.findAll", query = "SELECT u FROM Usuario u"),
    @NamedQuery(name = "Usuario.findByUSUid", query = "SELECT u FROM Usuario u WHERE u.uSUid = :uSUid"),
    @NamedQuery(name = "Usuario.findByUSUusuario", query = "SELECT u FROM Usuario u WHERE u.uSUusuario = :uSUusuario"),
    @NamedQuery(name = "Usuario.findByUSUcontrasenia", query = "SELECT u FROM Usuario u WHERE u.uSUcontrasenia = :uSUcontrasenia")})
public class Usuario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "USUid")
    private Integer uSUid;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "USUusuario")
    private String uSUusuario;
    @Size(max = 45)
    @Column(name = "USUcontrasenia")
    private String uSUcontrasenia;
    @ManyToMany(mappedBy = "usuarioCollection")
    private Collection<Rol> rolCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "usuarioUSUid")
    private Collection<Catalogoreportes> catalogoreportesCollection;
    @OneToMany(mappedBy = "usuarioUSUid")
    private Collection<Profesor> profesorCollection;

    public Usuario() {
    }

    public Usuario(Integer uSUid) {
        this.uSUid = uSUid;
    }

    public Usuario(Integer uSUid, String uSUusuario) {
        this.uSUid = uSUid;
        this.uSUusuario = uSUusuario;
    }

    public Integer getUSUid() {
        return uSUid;
    }

    public void setUSUid(Integer uSUid) {
        this.uSUid = uSUid;
    }

    public String getUSUusuario() {
        return uSUusuario;
    }

    public void setUSUusuario(String uSUusuario) {
        this.uSUusuario = uSUusuario;
    }

    public String getUSUcontrasenia() {
        return uSUcontrasenia;
    }

    public void setUSUcontrasenia(String uSUcontrasenia) {
        this.uSUcontrasenia = uSUcontrasenia;
    }

    @XmlTransient
    public Collection<Rol> getRolCollection() {
        return rolCollection;
    }

    public void setRolCollection(Collection<Rol> rolCollection) {
        this.rolCollection = rolCollection;
    }

    @XmlTransient
    public Collection<Catalogoreportes> getCatalogoreportesCollection() {
        return catalogoreportesCollection;
    }

    public void setCatalogoreportesCollection(Collection<Catalogoreportes> catalogoreportesCollection) {
        this.catalogoreportesCollection = catalogoreportesCollection;
    }

    @XmlTransient
    public Collection<Profesor> getProfesorCollection() {
        return profesorCollection;
    }

    public void setProfesorCollection(Collection<Profesor> profesorCollection) {
        this.profesorCollection = profesorCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (uSUid != null ? uSUid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Usuario)) {
            return false;
        }
        Usuario other = (Usuario) object;
        if ((this.uSUid == null && other.uSUid != null) || (this.uSUid != null && !this.uSUid.equals(other.uSUid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidad.Usuario[ uSUid=" + uSUid + " ]";
    }
    
}
