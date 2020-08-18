package com.dxctraining.inventorymgt.supplier.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dxctraining.inventorymgt.supplier.dao.ISupplierDao;
import com.dxctraining.inventorymgt.supplier.entities.Supplier;
import com.dxctraining.inventorymgt.supplier.exceptions.InvalidArgumentException;

@Transactional
@Service
public class SupplierServiceImpl implements ISupplierService
{
		
		@Autowired
		private ISupplierDao dao;
		

		@Override
		public Supplier addSupplier(Supplier supplier) {
			display(supplier);
			supplier=dao.addSupplier(supplier);
			return supplier;
		}

		public void display(Object arg) {
			if(arg==null) {
				throw new InvalidArgumentException("argument is null");
			}
			
		}

		@Override
		public Supplier findById(int id) {
			Supplier supplier=dao.findById(id);
			return supplier;
		}

		@Override
		public void remove(int id) {
			dao.remove(id);
			
		}
}
