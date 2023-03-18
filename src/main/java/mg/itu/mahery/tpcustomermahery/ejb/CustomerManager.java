/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mg.itu.mahery.tpcustomermahery.ejb;

import jakarta.ejb.Stateless;
import java.util.List;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import mg.itu.mahery.tpcustomermahery.entities.Customer;

/**
 *
 * @author mahery-Capri
 */
@Stateless
public class CustomerManager {
    @PersistenceContext(unitName = "customerPU")
    private EntityManager em;
    
    public List<Customer> getAllCustomers(){
        Query query = em.createNamedQuery("Customer.findAll");
        System.out.print(query.getResultList());
        return query.getResultList();
    }
    public Customer update(Customer customer){
         return em.merge(customer);
    } 
    public void persist(Customer customer) {
        em.persist(customer);
    }
    
}
