/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package task.jpaexample.model;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="PRODUCT", schema="APP")
public class ProductDTO extends AbstractDTO {
   
    private String name;
    private Double price;

    public ProductDTO() {}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

     @Override
    public String toString() {
        return "["+getId()+","+name+","+price;
    }
}
