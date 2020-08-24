package com.dxctraining.inventorymgt.supplier.controller;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import javax.annotation.PostConstruct;
import com.dxctraining.inventorymgt.supplier.dto.CreateSupplierRequest;
import com.dxctraining.inventorymgt.supplier.entities.Supplier;
import com.dxctraining.inventorymgt.supplier.service.ISupplierService;

@Controller
public class SupplierController 
{
		@Autowired
		private ISupplierService service;
		
		@PostConstruct
		public void init() {
			Supplier supplier1 = new Supplier("aaaa","1234");
			int id1 = supplier1.getId();
			supplier1 = service.addSupplier(supplier1);
			
			Supplier supplier2 = new Supplier("bbbb","5678");
			int id2 = supplier2.getId();
			supplier2 = service.addSupplier(supplier2);	
		}
		
		@GetMapping("/profile")
	    public ModelAndView employeeDetails(@RequestParam("id")int id){
	       Supplier supplier=service.findById(id);
	       ModelAndView modelAndView=new ModelAndView("supplierDetails","supplier",supplier);
	       return modelAndView;
	    }

	    @GetMapping("/listall")
	    public ModelAndView allSuppliers(){
	    	 List<Supplier>listAll=service.listAll();
	        ModelAndView modelAndView=new ModelAndView("list","supplier",listAll);
	        return modelAndView;
	    }
	    @GetMapping("/addsupplier")
	    public ModelAndView supplierPage(){
	        ModelAndView modelView=new ModelAndView("addsupplier");
	        return modelView;
	    }
	    @GetMapping("/register")
		public ModelAndView registerSupplier() {
			ModelAndView mv = new ModelAndView("register");
			return mv;
		}

		@GetMapping("/processregister")
		public ModelAndView processRegister(@RequestParam("name") String name,@RequestParam("password")String password) {
			System.out.println("inside processregister method, name=" + name);
			Supplier supplier = new Supplier(name,password);
			supplier = service.addSupplier(supplier);
			ModelAndView mv = new ModelAndView("details", "supplier", supplier);
			return mv;
		}
		@GetMapping("/postregister")
	    public ModelAndView postRegisterPage(){
	        CreateSupplierRequest newSupplier=new CreateSupplierRequest();
	        ModelAndView modelView=new ModelAndView("postregister","supplier",newSupplier);
	        return modelView;
	    }
}
