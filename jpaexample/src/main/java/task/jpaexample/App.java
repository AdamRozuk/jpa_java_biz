/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package task.jpaexample;

import java.util.Scanner;

import task.jpaexample.dao.CustomerDao;
import task.jpaexample.dao.ProductDao;
import task.jpaexample.dao.PurchaseDao;
import task.jpaexample.dao.KurierDao;
import task.jpaexample.dao.jpa.JpaCustomerDao;
import task.jpaexample.dao.jpa.JpaProductDao;
import task.jpaexample.dao.jpa.JpaPurchaseDao;
import task.jpaexample.dao.jpa.JpaKurierDao;
import task.jpaexample.model.CustomerDTO;
import task.jpaexample.model.ProductDTO;
import task.jpaexample.model.PurchaseDTO;
import task.jpaexample.model.PurchaseItemDTO;
import task.jpaexample.model.KurierDTO;


public class App {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        CustomerDao cdao = new JpaCustomerDao();
        ProductDao pdao = new JpaProductDao();
        PurchaseDao dao = new JpaPurchaseDao();
        KurierDao kdao = new JpaKurierDao();

        // utworzenie klienta
        CustomerDTO c1 = new CustomerDTO();
        c1.setFirstName("jan");
        c1.setLastName("kowalski");
        c1.setEmail("jan.kowalski@dot.com");
        // zapis klienta
        cdao.save(c1);

        // utworzenie produktu
        ProductDTO p1 = new ProductDTO();
        p1.setName("monitor");
        p1.setPrice(599.99);
        // zapis produktu
        pdao.save(p1);

        //Tworzymy firme kurierska
        KurierDTO k1 = new KurierDTO();
        k1.setNazwa("FeedX");
        k1.setAddres("Warsaw 15-331, Wiejska 45A");
        k1.setKontakt("email: feedx@gmail.com");
        kdao.save(k1);

        KurierDTO k2 = new KurierDTO();
        k2.setNazwa("Delivery");
        k2.setAddres("Warsaw 15-335, Pulaskiego 15");
        k2.setKontakt("email: delivery@gmail.com");

        kdao.save(k2);

        // utworzenie zamowienia
        PurchaseDTO pe = new PurchaseDTO();
        pe.addKurrier(k1);
        pe.addKurrier(k2);
        pe.setCustomer(c1);
        pe.setMiejsce("Warszawa");
        pe.setDataR("22-05-2018");


        System.out.println("wybierz firme kurierska: ");
        System.out.println("lista kurierow: " + pe.getListOfKuriers());
        Scanner skaner = new Scanner(System.in);
        System.out.println("Wpisz Id firmy ktora ma dostarczyc przesylke");
        long l = skaner.nextLong();
        System.out.println("Ustawianie firmy kurierskiej na : " + kdao.findById(l));

        pe.setKurier(kdao.findById(l));

        PurchaseItemDTO pi = new PurchaseItemDTO();
        pi.setProduct(p1);
        pi.setQuantity(10);
        pe.addPurchaseItem(pi);

        // zapis zamowienia
        dao.save(pe);
        
        //Upadate 
        c1.setFirstName("janek");
        cdao.update(c1);

        pe.setMiejsce("Kleosin");
        dao.update(pe);


    }

}
