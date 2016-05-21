package controllers;

import org.springframework.stereotype.Controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;

import dao.customerServices;
import dao.productServices;
import models.Product;
import models.customer;

//import dao.servicesImpl;

@Controller
public class HomeController {
	  
    @Autowired
  public productServices productService;
    @Autowired
  public customerServices customerService; 
   /* @Qualifier(value="productService")
    public void setPersonService(productServices ps){
        this.productService = ps;
    }*/
    @RequestMapping("/")
    public String showIndex()
    {
    	return "index";
    }
    @RequestMapping("/index")
    public String showIndexNow()
    {
    	return "index";
    }
    
    
    @RequestMapping("/registration")
    public String showReg(Model model)
    {
    	model.addAttribute("customer", new customer());
    	return "registration";
    }
    
    //Customer data insert
    @RequestMapping(value= "/addCustomer", method = RequestMethod.POST)
    public String addCustomer(@Valid @ModelAttribute("customer") customer c, BindingResult result)
    {
    	
            //new person, add it
    	if(result.hasErrors())
    	{
    		return "signin";
    	}
    	else
    	{
            this.customerService.addPerson(c);
    	}
        
    	return "redirect:/index";
    }
     
    @RequestMapping(value = "/submit", method = RequestMethod.POST)
    public ModelAndView customerTable()
    
    {
        ModelAndView mv = new ModelAndView("custTable");
        mv.addObject("listcust",this.customerService.listcust());
        return mv;
    }
    
    
    /*@RequestMapping(value="/customer" ,method = RequestMethod.POST )
    public String listProduct(Model model) {
    	
    	model.addAttribute("product", new Product());
        model.addAttribute("listProduct", this.productService.listProduct());
    	return "productTableUser";
    }
    */
    
    @RequestMapping(value = "/productTableUser", method=RequestMethod.GET )
    public ModelAndView prodTable()
	{
		//DAOlist dil=new DAOlist();
		//ModelAndView mav = new ModelAndView("productTableUser");
		//mav.addObject("listProduct", this.productService.listProduct());
		
    	List<Product> listtojsp=new ArrayList<Product>();
		listtojsp= productService.listProduct();
		
		
		String json = new Gson().toJson(listtojsp);  // converting list into Google Gson object which is a string
		System.out.println(json);
		ModelAndView mv=new ModelAndView("productTableUser");
		mv.addObject("myJson", json);
		return mv;
		
		
		
  }
    
   
    @RequestMapping("/signin")
	public String signin()
	{
		return "signin";
	}

    @RequestMapping(value = "/productTable", method=RequestMethod.GET )
    public String listProducts(Model model) {
        model.addAttribute("product", new Product());
        model.addAttribute("listProduct", this.productService.listProduct());
        return "productTable";
    }
   
     
    //For add and update person both
    @RequestMapping(value= "/productTable/add", method = RequestMethod.POST)
    public String addProduct(@ModelAttribute("product") Product p){
         
        if(p.getId() == 0){
            //new person, add it
            this.productService.addProduct(p);
        }else{
            //existing person, call update
            this.productService.updateProduct(p);
        }
         
        return "redirect:/productTable";
         
    }
     
    @RequestMapping("/remove/{id}")
    public String removeProduct(@PathVariable("id") int id){
         
        this.productService.removeProduct(id);
        return "redirect:/productTable";
    }
  
   
    @RequestMapping("/edit/{id}")
    public String editProduct(@PathVariable("id") int id, Model model){
        model.addAttribute("product", this.productService.getProductById(id));
        model.addAttribute("listProduct", this.productService.listProduct());
        return "productTable";
    }
    
   /* @RequestMapping(value = "/productTable", method = RequestMethod.POST)
	public String privatePage()
	{
		return "productTable";
	}*/
	
    
	
	
	@RequestMapping(value = "/url", method = RequestMethod.POST)
	public String addNewProduct(MultipartHttpServletRequest request, @RequestParam String h) {
	        String category = request.getParameter("parmname");
	        //other stuff 
			return category;
	}
 
 
    @RequestMapping(value = "/uploadFile", method = RequestMethod.POST)
   
    String uploadFileHandler( @RequestParam("file") MultipartFile file) {
 
        if (!file.isEmpty()) {
            try {
                byte[] bytes = file.getBytes();
 
                // Creating the directory to store file
                String rootPath = "C:/Users/koel.chowdhury/Pictures";
                File dir = new File(rootPath + File.separator + "file");
                if (!dir.exists())
                    dir.mkdirs();
 
                // Create the file on server
                File serverFile = new File(dir.getAbsolutePath() + File.separator + "file"+".png");
                BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(serverFile));
                stream.write(bytes);
                stream.close();
 
                /*logger.info("Server File Location="
                        + serverFile.getAbsolutePath());*/
 
                return "FileUploadSuccess" ;
            } catch (Exception e) {
                return "You failed to upload " ;
            }
        } else {
            return "You failed to upload  because the file was empty.";
        }
    }	
     
}
