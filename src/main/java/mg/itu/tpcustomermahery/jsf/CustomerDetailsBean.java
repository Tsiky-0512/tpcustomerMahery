/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mg.itu.tpcustomermahery.jsf;

import jakarta.ejb.EJB;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;
import java.io.Serializable;
import java.util.List;
import mg.itu.tpcustomermahery.ejb.CustomerManager;
import mg.itu.tpcustomermahery.ejb.DiscountManager;
import mg.itu.tpcustomermahery.entities.Customer;
import mg.itu.tpcustomermahery.entities.Discount;

/**
 *
 * @author Peabody
 */
@Named(value = "customerDetailsBean")
@ViewScoped
public class CustomerDetailsBean implements Serializable{

    private int idCustomer;
    private Customer customer;
    private List<Discount> discountList;  

    @EJB
    private CustomerManager customerManager;
    
    @EJB
    private DiscountManager discountManager;

    public int getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(int idCustomer) {
        this.idCustomer = idCustomer;
    }

    public Customer getCustomer() {
        return customer;
    }

    public String update() {
        customer = customerManager.update(customer);
        return "customerList";
    }

    public void loadCustomer() {
        this.customer = customerManager.findById(idCustomer);
    }
    
     public List<Discount> getDiscounts() {
      if (discountList == null) {
        discountList = discountManager.getAllDiscounts();
      }
      return discountList;
    }  

}
