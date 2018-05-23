/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package task.jpaexample.model;

/**
 *
 * @author dell
 */

import java.util.LinkedList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name="KURIER",schema="APP")
public class KurierDTO extends AbstractDTO{
    //@ManyToOne
    //private PurchaseDTO purchase;
    private String nazwa;
    private String addres;
    private String kontakt;

    
    /*    public PurchaseDTO getPurchase() {
    return purchase;
    }
    
    public void setPurchase(PurchaseDTO purchase) {
    this.purchase = purchase;
    }*/
    
     
    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public String getAddres() {
        return addres;
    }

    public void setAddres(String addres) {
        this.addres = addres;
    }

    public String getKontakt() {
        return kontakt;
    }

    public void setKontakt(String kontakt) {
        this.kontakt = kontakt;
    }

    @Override
    public String toString() {
        return "KurierDTO{" +"Id : " +getId()+ ", nazwa=" + nazwa + ", addres=" + addres + ", kontakt=" + kontakt + '}';
    }

    
    
}
