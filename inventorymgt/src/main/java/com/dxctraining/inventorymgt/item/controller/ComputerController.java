package com.dxctraining.inventorymgt.item.controller;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.dxctraining.inventorymgt.item.entities.Computer;
import com.dxctraining.inventorymgt.item.entities.Item;
import com.dxctraining.inventorymgt.item.service.IItemService;
import com.dxctraining.inventorymgt.item.dto.*;
import com.dxctraining.inventorymgt.supplier.entities.Supplier;
import com.dxctraining.inventorymgt.supplier.service.*;

@Controller
public class ComputerController 
{
		@Autowired
		private IItemService service1;
		
		@Autowired
		private ISupplierService service2;
		
		@PostConstruct
		public void init() {
			Supplier supplier1=new Supplier("aaaa","1234");
			service2.addSupplier(supplier1);
			Computer computer1=new Computer("Dell",supplier1,200);
			service1.addItem(computer1);
		}
		
		@GetMapping("/listallcmp")
	    public ModelAndView allComputers(){
	    	 List<Computer>computer=service1.allComputer();
	        ModelAndView modelAndView=new ModelAndView("clist","computers",computer);
	        return modelAndView;
	    }
		@GetMapping("/addcomputer")
		public ModelAndView addComputer() {
			ModelAndView modelAndView = new ModelAndView("addcomputer");
			return modelAndView;
		}
		
		@GetMapping("/processaddcomputer")
		public ModelAndView processAddComputer(@RequestParam("name")String name, @RequestParam("discsize")int discsize) {
			Computer computer = new Computer(name, discsize);
			Item item = (Item)computer;
			item = service1.addItem(item);
			ModelAndView modelAndView = new ModelAndView("processaddcomputer","computers",item);
			return modelAndView;
		}
		
		@GetMapping("/postaddcomputer")
		public ModelAndView postAddComputer() {
			CreateComputerRequest computer = new CreateComputerRequest();
			ModelAndView modelAndView = new ModelAndView("postaddcomputer","computers",computer);
			return modelAndView;
		}
}
