package dao;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import models.Student;
import dao.StudentDAOImpl;

@Service
public class StudentServices {

	
	@Autowired
    private StudentDAOImpl studentDAO;
 
    /*public void setStudentDAO(StudentDAOImpl studentDAO) {
        this.studentDAO = studentDAO;
    }
*/
    
    
    @Transactional
    public List<Student> listStudent() {
        return this.studentDAO.liststudent();
    }
    
    public StudentServices()
    {
    	
    }
    
}

