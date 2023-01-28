/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.appfevers.dto;

import com.appfevers.entities.Msg;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;


/**
 *
 * @author cyrus
 */
public interface MsgRepository extends CrudRepository<Msg, Long>{
    
    @Query("select m.uName, m.msg, m.create_dtm, m.lupd_dtm from Msg m where m.create_dtm >= :cDtm")
    List<Msg> getMsgBeforeCreateDtm();
    
}