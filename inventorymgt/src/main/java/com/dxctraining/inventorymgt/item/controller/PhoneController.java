package com.dxctraining.inventorymgt.item.controller;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.dxctraining.inventorymgt.item.entities.Phone;
import com.dxctraining.inventorymgt.item.service.IItemService;
import com.dxctraining.inventorymgt.supplier.entities.Supplier;
import com.dxctraining.inventorymgt.supplier.service.ISupplierService;

@Controller
public class PhoneController 
{
		@Autowired
		private IItemService service;
		
		
		@Autowired
		private ISupplierService service2;
		
		
		@PostConstruct
		public void init() {
			Supplier supplier1=new Supplier("cccc","46778");
			Phone phone1=new Phone("Vivo",supplier1,1000);
			service2.addSupplier(supplier1);
			service.addItem(phone1);
		}
		@GetMapping("/listallphone")
	    public ModelAndView all(){
			System.out.println("inside one");
	    	 List<Phone>phone=service.allPhone();
	        ModelAndView modelAndView=new ModelAndView("plist","phone",phone);
	        return modelAndView;
	    }
}
