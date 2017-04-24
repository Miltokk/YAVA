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
@Table(name = "permiso")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Permiso.findAll", query = "SELECT p FROM Permiso p"),
    @NamedQuery(name = "Permiso.findByPERid", query = "SELECT p FROM Permiso p WHERE p.pERid = :pERid"),
    @NamedQuery(name = "Permiso.findByPERtipo", query = "SELECT p FROM Permiso p WHERE p.pERtipo = :pERtipo"),
    @NamedQuery(name = "Permiso.findByPERvalor", query = "SELECT p FROM Permiso p WHERE p.pERvalor = :pERvalor")})
public class Permiso implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "PERid")
    private Integer pERid;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 65)
    @Column(name = "PERtipo")
    private String pERtipo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "PERvalor")
    private int pERvalor;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "permiso")
    private Collection<RolHasPermiso> rolHasPermisoCollection;

    public Permiso() {
    }

    public Permiso(Integer pERid) {
        this.pERid = pERid;
    }

    public Permiso(Integer pERid, String pERtipo, int pERvalor) {
        this.pERid = pERid;
        this.pERtipo = pERtipo;
        this.pERvalor = pERvalor;
    }

    public Integer getPERid() {
        return pERid;
    }

    public void setPERid(Integer pERid) {
        this.pERid = pERid;
    }

    public String getPERtipo() {
        return pERtipo;
    }

    public void setPERtipo(String pERtipo) {
        this.pERtipo = pERtipo;
    }

    public int getPERvalor() {
        return pERvalor;
    }

    public void setPERvalor(int pERvalor) {
        this.pERvalor = pERvalor;
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
        hash += (pERid != null ? pERid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Permiso)) {
            return false;
        }
        Permiso other = (Permiso) object;
        if ((this.pERid == null && other.pERid != null) || (this.pERid != null && !this.pERid.equals(other.pERid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidad.Permiso[ pERid=" + pERid + " ]";
    }
    
}
