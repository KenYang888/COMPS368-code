/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.appfevers.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Temporal;

/**
 *
 * @author cyrus
 */
@Entity
@NamedQueries({
    @NamedQuery(name="Msg.getMsgByUser", query="select m.uName, m.msg, m.create_dtm, m.lupd_dtm from Msg m where LOWER(m.uName) like LOWER(:users)"),
    @NamedQuery(name="Msg.getMsgByMsg", query="select m.uName, m.msg, m.create_dtm, m.lupd_dtm from Msg m where LOWER(m.msg) like LOWER(:msg)"),
})
public class Msg implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @Column(nullable=false,length=255)
    private String uName;
    
    @Column(nullable=false,length=500)
    private String msg;
    
    @Column(nullable=false)
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date create_dtm;
    
    @Column(nullable=false)
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date lupd_dtm;
    
    @PreUpdate
    public void updt(){
        Date _now = new Date();
        lupd_dtm = _now;
    }
    
    @PrePersist
    public void add(){
        Date _now = new Date();
        lupd_dtm = _now;
        create_dtm = _now;
    }

    public String getuName() {
        return uName;
    }

    public void setuName(String uName) {
        this.uName = uName;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Date getCreate_dtm() {
        return create_dtm;
    }

    public void setCreate_dtm(Date create_dtm) {
        this.create_dtm = create_dtm;
    }

    public Date getLupd_dtm() {
        return lupd_dtm;
    }

    public void setLupd_dtm(Date lupd_dtm) {
        this.lupd_dtm = lupd_dtm;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
        if (!(object instanceof Msg)) {
            return false;
        }
        Msg other = (Msg) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.appfevers.entities.Msg[ id=" + id + " ]";
    }
    
}
