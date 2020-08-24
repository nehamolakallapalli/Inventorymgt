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
import com.dxctraining.inventorymgt.supplier.dto.SessionData;

@Controller
public class SupplierController 
{
		@Autowired
		private ISupplierService service;
		
		@Autowired
		private SessionData sessionData;
		
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
	    public ModelAndView suplierDetails(@RequestParam("id")int id){
			if(!sessionData.isUserLoggedin()) {
				return new ModelAndView("login");
			}
		   Supplier supplier=service.findById(id);
	       ModelAndView modelAndView=new ModelAndView("supplierDetails","supplier",supplier);
	       return modelAndView;
	    }

	    @GetMapping("/listall")
	    public ModelAndView SupplierDetails(){
	    	if(!sessionData.isUserLoggedin()) {
				return new ModelAndView("login");
			}
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
			ModelAndView mv = new ModelAndView("supplierregister");
			return mv;
		}

		@GetMapping("/processregister")
		public ModelAndView processRegister(@RequestParam("name") String name,@RequestParam("password")String password) {
			System.out.println("inside processregister method, name=" + name);
			Supplier supplier = new Supplier(name,password);
			supplier = service.addSupplier(supplier);
			ModelAndView mv = new ModelAndView("supplierDetails", "supplier", supplier);
			return mv;
		}
		@GetMapping("/postregister")
	    public ModelAndView postRegisterPage(){
	        CreateSupplierRequest newSupplier=new CreateSupplierRequest();
	        ModelAndView modelView=new ModelAndView("postregister","supplier",newSupplier);
	        return modelView;
	    }
		@GetMapping("/login")
		public ModelAndView login() {
			ModelAndView modelAndView = new ModelAndView("login");
			return modelAndView;
		}
		
		@GetMapping("/processlogin")
		public ModelAndView processLogin(@RequestParam("id")int id,@RequestParam("password")String password) {
			boolean correct = service.authentication(id,password);
			if(correct) {
				sessionData.saveLogin(id);
				Supplier supplier = service.findById(id);
				ModelAndView modelAndView = new ModelAndView("SupplierDetails","supplier",supplier);
				return modelAndView;
			}
				ModelAndView modelAndView = new ModelAndView("login");
				return modelAndView;
		}
		
		@GetMapping("/logout")
		public ModelAndView logout() {
			sessionData.clear();
			ModelAndView modelAndView = new ModelAndView("login");
			return modelAndView;
		}
}
