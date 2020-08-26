package com.dxctraining.inventorymgt.item.controller;

import java.util.List;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;

import com.dxctraining.inventorymgt.item.entities.Item;
import com.dxctraining.inventorymgt.item.entities.Phone;
import com.dxctraining.inventorymgt.item.service.*;
import com.dxctraining.inventorymgt.item.dto.*;
import com.dxctraining.inventorymgt.item.util.*;


@RestController
@RequestMapping("/phone")
public class PhoneController 
{
		@Autowired
		private IItemService service;

		@Autowired
		private PhoneUtil phoneUtil;

		@Autowired
		private RestTemplate restTemplate;

		@PostMapping("/add")
		@ResponseStatus(HttpStatus.CREATED)
		public PhoneDto add(@RequestBody CreatePhoneRequest request) {
			String name = request.getName();
			int size = request.getStoragesize();
			int supplierId = request.getSupplierId();
			Item phone = new Phone();
			phone = service.addItem(phone);
			SupplierDto supplierDto = fetchFromSupplierById(supplierId);
			PhoneDto response = phoneUtil.phoneDto(phone, supplierId, supplierDto.getName());
			return response;
		}

		@GetMapping("/get/{id}")
		public PhoneDto getPhone(@PathVariable("id") int id) {
			Item phone = service.findById(id);
			int supplierId = phone.getSupplierId();
			SupplierDto supplierDto = fetchFromSupplierById(supplierId);
			PhoneDto response = phoneUtil.phoneDto(phone, supplierId, supplierDto.getName());
			return response;
		}

		@GetMapping
		public List<PhoneDto> fetchAll() {
			List<Phone> list = service.allPhone();
			List<PhoneDto> response = new ArrayList<>();
			for (Phone phone : list) {
				int supplierId = phone.getSupplierId();
				SupplierDto supplierDto = fetchFromSupplierById(supplierId);
				PhoneDto phoneDto = phoneUtil.phoneDto(phone, supplierId, supplierDto.getName());
				response.add(phoneDto);
			}
			return response;
		}

		@GetMapping("/supplier/{supplierId}")
		public List<PhoneDto> fetchAllSuppliers(@PathVariable("supplierId") int supplierId) {
			List<Phone> list = service.phoneBySupplier(supplierId);
			List<PhoneDto> response = new ArrayList<>();
			SupplierDto supplierDto = fetchFromSupplierById(supplierId);
			for (Phone phone : list) {
				PhoneDto phoneDto = phoneUtil.phoneDto(phone, supplierId, supplierDto.getName());
				response.add(phoneDto);
			}
			return response;
		}

		public SupplierDto fetchFromSupplierById(int supplierId) {
			String url = "http://localhost:8585/suppliers/get/" + supplierId;
			SupplierDto dto = restTemplate.getForObject(url, SupplierDto.class);
			return dto;
		}
}
