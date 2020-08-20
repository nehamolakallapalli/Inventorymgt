package com.dxctraining.inventorymgt.supplier.controller;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import javax.annotation.PostConstruct;
import com.dxctraining.inventorymgt.supplier.entities.Supplier;
import com.dxctraining.inventorymgt.supplier.service.ISupplierService;

@Controller
public class SupplierController 
{
		@Autowired
		private ISupplierService service;
		
		@PostConstruct
		public void init() {
			Supplier supplier1 = new Supplier("aaaa");
			int id1 = supplier1.getId();
			supplier1 = service.addSupplier(supplier1);
			
			Supplier supplier2 = new Supplier("bbbb");
			int id2 = supplier2.getId();
			supplier2 = service.addSupplier(supplier2);	
		}
		
		@GetMapping("/profile")
	    public ModelAndView employeeDetails(@RequestParam("id")int id){
	       Supplier supplier=service.findById(id);
	       ModelAndView modelAndView=new ModelAndView("details","supplier",supplier);
	       return modelAndView;
	    }

	    @GetMapping("/listall")
	    public ModelAndView all(){
	    	 List<Supplier>supplierValues=service.allSuppliers();
	        ModelAndView modelAndView=new ModelAndView("list","supplier",supplierValues);
	        return modelAndView;
	 }
}
