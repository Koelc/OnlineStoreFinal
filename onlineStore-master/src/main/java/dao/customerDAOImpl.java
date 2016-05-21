package dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

//import models.Product;
import models.customer;
@Repository
public class customerDAOImpl {
	    
	    private static final Logger logger = LoggerFactory.getLogger(customerDAOImpl.class);
	 
	    @Autowired
	    private SessionFactory sessionFactory;
	     
	    public void setSessionFactory(SessionFactory sf){
	        this.sessionFactory = sf;
	    }
	 
	  
	    public void addPerson(customer c)
	    {
	        Session session = this.sessionFactory.getCurrentSession();
	        session.persist(c);
	        //logger.info("Product saved successfully, Product Details="+p);
	    }
	 
	 
	 
	    @SuppressWarnings("unchecked")
	   
	    public List<customer> listcust() {
	        Session session = this.sessionFactory.getCurrentSession();
	        List<customer> custList = session.createQuery("from customer").list();
	        for(customer c : custList)
	        {
	            logger.info("customer List::"+c);
	        }
	        return custList;
	    }
	 
	    
	    public customer getCustomerById(int id) {
	        Session session = this.sessionFactory.getCurrentSession();      
	        customer c = (customer) session.load(customer.class, new Integer(id));
	        logger.info("customer loaded successfully, customer details="+c);
	        return c;
	    }
	 

	 /*   public void removeProduct(int id) {
	        Session session = this.sessionFactory.getCurrentSession();
	        Product p = (Product) session.load(Product.class, new Integer(id));
	        if(null != p){
	            session.delete(p);
	        }
	        logger.info("Product deleted successfully, Product details="+p);
	    }*/
	 
}
