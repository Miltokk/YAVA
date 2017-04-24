/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidad;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Miltokk
 */
@Entity
@Table(name = "charges")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Charges.findAll", query = "SELECT c FROM Charges c"),
    @NamedQuery(name = "Charges.findById", query = "SELECT c FROM Charges c WHERE c.id = :id"),
    @NamedQuery(name = "Charges.findByLivemode", query = "SELECT c FROM Charges c WHERE c.livemode = :livemode"),
    @NamedQuery(name = "Charges.findByCreatedAt", query = "SELECT c FROM Charges c WHERE c.createdAt = :createdAt"),
    @NamedQuery(name = "Charges.findByStatus", query = "SELECT c FROM Charges c WHERE c.status = :status"),
    @NamedQuery(name = "Charges.findByCurrency", query = "SELECT c FROM Charges c WHERE c.currency = :currency"),
    @NamedQuery(name = "Charges.findByDescription", query = "SELECT c FROM Charges c WHERE c.description = :description"),
    @NamedQuery(name = "Charges.findByReferenceId", query = "SELECT c FROM Charges c WHERE c.referenceId = :referenceId"),
    @NamedQuery(name = "Charges.findByFailureCode", query = "SELECT c FROM Charges c WHERE c.failureCode = :failureCode"),
    @NamedQuery(name = "Charges.findByFailureMessage", query = "SELECT c FROM Charges c WHERE c.failureMessage = :failureMessage"),
    @NamedQuery(name = "Charges.findByAmount", query = "SELECT c FROM Charges c WHERE c.amount = :amount"),
    @NamedQuery(name = "Charges.findByCardName", query = "SELECT c FROM Charges c WHERE c.cardName = :cardName"),
    @NamedQuery(name = "Charges.findByCardExpMonth", query = "SELECT c FROM Charges c WHERE c.cardExpMonth = :cardExpMonth"),
    @NamedQuery(name = "Charges.findByCardExpYear", query = "SELECT c FROM Charges c WHERE c.cardExpYear = :cardExpYear"),
    @NamedQuery(name = "Charges.findByCardAuthCode", query = "SELECT c FROM Charges c WHERE c.cardAuthCode = :cardAuthCode"),
    @NamedQuery(name = "Charges.findByCardLast4", query = "SELECT c FROM Charges c WHERE c.cardLast4 = :cardLast4"),
    @NamedQuery(name = "Charges.findByCardBrand", query = "SELECT c FROM Charges c WHERE c.cardBrand = :cardBrand")})
public class Charges implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "id")
    private String id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "livemode")
    private boolean livemode;
    @Basic(optional = false)
    @NotNull
    @Column(name = "created_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "status")
    private String status;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 5)
    @Column(name = "currency")
    private String currency;
    @Size(max = 255)
    @Column(name = "description")
    private String description;
    @Size(max = 255)
    @Column(name = "reference_id")
    private String referenceId;
    @Size(max = 255)
    @Column(name = "failure_code")
    private String failureCode;
    @Size(max = 255)
    @Column(name = "failure_message")
    private String failureMessage;
    @Basic(optional = false)
    @NotNull
    @Column(name = "amount")
    private int amount;
    @Size(max = 30)
    @Column(name = "card_name")
    private String cardName;
    @Size(max = 2)
    @Column(name = "card_exp_month")
    private String cardExpMonth;
    @Size(max = 2)
    @Column(name = "card_exp_year")
    private String cardExpYear;
    @Size(max = 6)
    @Column(name = "card_auth_code")
    private String cardAuthCode;
    @Size(max = 4)
    @Column(name = "card_last4")
    private String cardLast4;
    @Size(max = 5)
    @Column(name = "card_brand")
    private String cardBrand;

    public Charges() {
    }

    public Charges(String id) {
        this.id = id;
    }

    public Charges(String id, boolean livemode, Date createdAt, String status, String currency, int amount) {
        this.id = id;
        this.livemode = livemode;
        this.createdAt = createdAt;
        this.status = status;
        this.currency = currency;
        this.amount = amount;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public boolean getLivemode() {
        return livemode;
    }

    public void setLivemode(boolean livemode) {
        this.livemode = livemode;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getReferenceId() {
        return referenceId;
    }

    public void setReferenceId(String referenceId) {
        this.referenceId = referenceId;
    }

    public String getFailureCode() {
        return failureCode;
    }

    public void setFailureCode(String failureCode) {
        this.failureCode = failureCode;
    }

    public String getFailureMessage() {
        return failureMessage;
    }

    public void setFailureMessage(String failureMessage) {
        this.failureMessage = failureMessage;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getCardName() {
        return cardName;
    }

    public void setCardName(String cardName) {
        this.cardName = cardName;
    }

    public String getCardExpMonth() {
        return cardExpMonth;
    }

    public void setCardExpMonth(String cardExpMonth) {
        this.cardExpMonth = cardExpMonth;
    }

    public String getCardExpYear() {
        return cardExpYear;
    }

    public void setCardExpYear(String cardExpYear) {
        this.cardExpYear = cardExpYear;
    }

    public String getCardAuthCode() {
        return cardAuthCode;
    }

    public void setCardAuthCode(String cardAuthCode) {
        this.cardAuthCode = cardAuthCode;
    }

    public String getCardLast4() {
        return cardLast4;
    }

    public void setCardLast4(String cardLast4) {
        this.cardLast4 = cardLast4;
    }

    public String getCardBrand() {
        return cardBrand;
    }

    public void setCardBrand(String cardBrand) {
        this.cardBrand = cardBrand;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Charges)) {
            return false;
        }
        Charges other = (Charges) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidad.Charges[ id=" + id + " ]";
    }
    
}
