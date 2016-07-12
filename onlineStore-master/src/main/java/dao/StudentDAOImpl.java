package dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import models.Student;


@Repository
public class StudentDAOImpl {

	
	private static final Logger logger = LoggerFactory.getLogger(StudentDAOImpl.class);
	 
    @Autowired
    private SessionFactory sessionFactory;
     
  /*  public void setSessionFactory(SessionFactory sf){
        this.sessionFactory = sf;
    }*/
    
    
    
    @SuppressWarnings("unchecked")
    
    public List<Student> liststudent() {
        Session session = this.sessionFactory.getCurrentSession();
        List<Student> studentList = session.createQuery("from Student").list();
        for(Student s : studentList)
        {
            logger.info("Student List::"+s);
        }
        return studentList;
    }
    
    public StudentDAOImpl()
    {
    	
    }
 
}