package com.dxctraining.inventorymgt.supplier.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.dxctraining.inventorymgt.supplier.dto.*;
import com.dxctraining.inventorymgt.supplier.entities.Supplier;
import com.dxctraining.inventorymgt.supplier.service.ISupplierService;

@RestController
@RequestMapping("/suppliers")
public class SupplierRestController 
{
		
		@Autowired
		private ISupplierService supplierService;
		
		@PostMapping("/add")
		@ResponseStatus(HttpStatus.CREATED)
		public Supplier create(@RequestBody CreateSupplierRequest requestData) {
			String name=requestData.getName();
			String password=requestData.getPassword();
			Supplier supplier=new Supplier(name,password);
			supplier=supplierService.addSupplier(supplier);
			return supplier;
		}
		
		@GetMapping("/get/{id}")
		@ResponseStatus(HttpStatus.OK)
		public Supplier findSupplierBy(@PathVariable("id") int id) {
			Supplier supplier=supplierService.findById(id);
			return supplier;
		}
		
		@PutMapping("/update")
		public Supplier updateSupplier(@RequestBody UpdateSupplierRequest requestData) {
			String name = requestData.getName();
			String password = requestData.getPassword();
			int id = requestData.getId();
			Supplier supplier = new Supplier(name, password);
			supplier.setId(id);
			supplier = supplierService.update(supplier);
			return supplier;
		}
		
		@GetMapping("/authenticate/{id}/{password}")
		    public boolean authenticate(@PathVariable("id") int id, @PathVariable("password") String password)
		{
		       boolean result= supplierService.authentication(id, password);
		       return result;
		}
}
