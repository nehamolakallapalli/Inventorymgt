package com.dxctraining.inventorymgt.supplier.controller;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import com.dxctraining.inventorymgt.supplier.dao.*;
import com.dxctraining.inventorymgt.supplier.dto.*;
import com.dxctraining.inventorymgt.supplier.entities.*;
import com.dxctraining.inventorymgt.supplier.exceptions.*;
import com.dxctraining.inventorymgt.supplier.service.*;

@RestController
@RequestMapping("/suppliers")
public class SupplierController 
{

	    @Autowired
	    private ISupplierService supplierService;
	    
	    @PostMapping("/add")
		@ResponseStatus(HttpStatus.CREATED)
		public SupplierDto create(@RequestBody CreateSupplierRequest requestData) {
			Supplier supplier=new Supplier();
			supplier.setName(requestData.getName());
			supplier.setPassword(requestData.getPassword());
			supplier = supplierService.addSupplier(supplier);
			SupplierDto response = toDto(supplier);
			return response;
		}

		@GetMapping("/get/{id}")
		@ResponseStatus(HttpStatus.OK)
		public SupplierDto findSupplierBy(@PathVariable("id") int id) {
			Supplier supplier = supplierService.findById(id);
			SupplierDto response = toDto(supplier);
			return response;
		}

		public SupplierDto toDto(Supplier supplier) {
			SupplierDto dto = new SupplierDto();
			dto.setId(supplier.getId());
			dto.setName(supplier.getName());
			dto.setPassword(supplier.getPassword());
			return dto;
		}
}
