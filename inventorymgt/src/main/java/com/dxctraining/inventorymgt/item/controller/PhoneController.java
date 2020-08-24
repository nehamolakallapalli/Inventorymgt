package com.dxctraining.inventorymgt.item.controller;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.dxctraining.inventorymgt.item.entities.Item;
import com.dxctraining.inventorymgt.item.entities.Phone;
import com.dxctraining.inventorymgt.item.service.IItemService;
import com.dxctraining.inventorymgt.item.dto.*;
import com.dxctraining.inventorymgt.supplier.entities.Supplier;
import com.dxctraining.inventorymgt.supplier.service.ISupplierService;

@Controller
public class PhoneController 
{
		@Autowired
		private IItemService service1;
		
		
		@Autowired
		private ISupplierService service2;
		
		
		@PostConstruct
		public void init() {
			Supplier supplier1=new Supplier("cccc","46778");
			service2.addSupplier(supplier1);
			Phone phone1=new Phone("Vivo",supplier1,1000);
			service1.addItem(phone1);
		}
		@GetMapping("/listallphone")
	    public ModelAndView all(){
			System.out.println("inside one");
	    	 List<Phone>phone=service1.allPhone();
	        ModelAndView modelAndView=new ModelAndView("plist","phone",phone);
	        return modelAndView;
	    }
		
		@GetMapping("/addphone")
		public ModelAndView addPhone() {
			ModelAndView modelAndView = new ModelAndView("addphone");
			return modelAndView;
		}
		@GetMapping("/processaddphone")
		public ModelAndView processAddPhone(@RequestParam("name")String name, @RequestParam("storagesize")int storagesize) {
			Phone phone = new Phone(name, storagesize);
			Item item = (Item)phone;
			item = service1.addItem(item);
			ModelAndView modelAndView = new ModelAndView("processaddphone","phone",item);
			return modelAndView;
		}
		
		@GetMapping("/postaddphone")
		public ModelAndView postAddPhone() {
			CreatePhoneRequest phone = new CreatePhoneRequest();
			ModelAndView modelAndView = new ModelAndView("postaddphone","phone",phone);
			return modelAndView;
		}
}
