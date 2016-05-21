package dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import models.customer;

@Service
public class customerServices {


     
	@Autowired
    private customerDAOImpl customerDAO;
 
    public void setcustomerDAO(customerDAOImpl customerDAO) {
        this.customerDAO = customerDAO;
    }
 
   
    @Transactional
    public void addPerson(customer c) {
        this.customerDAO.addPerson(c);
    }
 
   
 

    
    @Transactional
    public List<customer> listcust() {
        return this.customerDAO.listcust();
    }
 
    /*
    @Transactional
    public Product getProductById(int id) {
        return this.productDAO.getProductById(id);
    }
 
 
    @Transactional
    public void removeProduct(int id) 
    {
        this.productDAO.removeProduct(id);
    }
 */

}
