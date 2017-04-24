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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
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
@Table(name = "mensaje")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Mensaje.findAll", query = "SELECT m FROM Mensaje m"),
    @NamedQuery(name = "Mensaje.findByMENid", query = "SELECT m FROM Mensaje m WHERE m.mENid = :mENid")})
public class Mensaje implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "MENid")
    private Integer mENid;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 2147483647)
    @Column(name = "MENmensaje")
    private String mENmensaje;
    @JoinColumn(name = "Alerta_ALEid", referencedColumnName = "ALEid")
    @ManyToOne(optional = false)
    private Alerta alertaALEid;

    public Mensaje() {
    }

    public Mensaje(Integer mENid) {
        this.mENid = mENid;
    }

    public Mensaje(Integer mENid, String mENmensaje) {
        this.mENid = mENid;
        this.mENmensaje = mENmensaje;
    }

    public Integer getMENid() {
        return mENid;
    }

    public void setMENid(Integer mENid) {
        this.mENid = mENid;
    }

    public String getMENmensaje() {
        return mENmensaje;
    }

    public void setMENmensaje(String mENmensaje) {
        this.mENmensaje = mENmensaje;
    }

    public Alerta getAlertaALEid() {
        return alertaALEid;
    }

    public void setAlertaALEid(Alerta alertaALEid) {
        this.alertaALEid = alertaALEid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (mENid != null ? mENid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Mensaje)) {
            return false;
        }
        Mensaje other = (Mensaje) object;
        if ((this.mENid == null && other.mENid != null) || (this.mENid != null && !this.mENid.equals(other.mENid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidad.Mensaje[ mENid=" + mENid + " ]";
    }
    
}
