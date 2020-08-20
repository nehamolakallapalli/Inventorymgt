package com.dxctraining.inventorymgt.supplier.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dxctraining.inventorymgt.supplier.dao.ISupplierDao;
import com.dxctraining.inventorymgt.supplier.entities.Supplier;
import com.dxctraining.inventorymgt.supplier.exceptions.*;

@Transactional
@Service
public class SupplierServiceImpl implements ISupplierService
{
		
		@Autowired
		private ISupplierDao dao;
		
		@Override
		public Supplier findById(int id) {
			validateId(id);
			Supplier supplier=dao.findById(id);
			return supplier;
		}
		
		private void validateId(int id) {
			if(id == 0) {
				throw new InvalidArgumentException("id should not be null");
			}
		}
		
		@Override
		public Supplier addSupplier(Supplier supplier) {
			validateSupplier(supplier);
			dao.addSupplier(supplier);
			return supplier;
		}

		public void validateSupplier(Supplier supplier) {
			if(supplier==null) {
				throw new InvalidArgumentException("supplier is null");
			}
		}
		
		@Override
		public void removeSupplier(int id) {
			validateId(id);
			dao.remove(id);
			
		}
}
