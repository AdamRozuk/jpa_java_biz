/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package task.jpaexample.model;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="PURCHASE", schema="APP")
public class PurchaseDTO extends AbstractDTO {
    @ManyToOne
    private CustomerDTO customer;
    @ManyToOne
    @JoinColumn(name = "KURIER_ID", referencedColumnName = "ID")
    private KurierDTO kurier;
    @OneToMany(mappedBy = "purchase", cascade={CascadeType.ALL})
    private List<PurchaseItemDTO> purchaseItems = new LinkedList<PurchaseItemDTO>();
    private String miejsce;
    private String dataR;
    @OneToMany
    public List<KurierDTO> ListOfKuriers = new LinkedList<KurierDTO>();

    public List<KurierDTO> getListOfKuriers() {
        return ListOfKuriers;
    }

    public void addKurrier(KurierDTO kurier) {
        ListOfKuriers.add(kurier);
    }
    
    public KurierDTO getKurier() {
        return kurier;
    }

    public void setKurier(KurierDTO kurier) {
        this.kurier = kurier;
    }


    public CustomerDTO getCustomer() {
        return customer;
    }

    public void setCustomer(CustomerDTO customer) {
        this.customer = customer;
    }

    public void addPurchaseItem(PurchaseItemDTO pi) {
        purchaseItems.add(pi);
        pi.setPurchase(this);
       
    }

    public List<PurchaseItemDTO> getPurchaseItems() {
        return purchaseItems;
    }

    public String getMiejsce() {
        return miejsce;
    }

    public void setMiejsce(String miejsce) {
        this.miejsce = miejsce;
    }

    public String getDataR() {
        return dataR;
    }

    public void setDataR(String dataR) {
        this.dataR = dataR;
    }

    
}
