package com.dxctraining.inventorymgt.supplier.dao;

import com.dxctraining.inventorymgt.supplier.exceptions.*;
import com.dxctraining.inventorymgt.supplier.entities.*;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class SupplierDaoImpl implements ISupplierDao
{
		@PersistenceContext
		private EntityManager entityManager;
		
		@Override
		public Supplier findById(int id) {
			Supplier supplier=entityManager.find(Supplier.class, id);
			if(supplier==null) {
				throw new SupplierNotFoundException("supplier not found for the given id"+id);
			}
			return supplier;
		}
		
		@Override
		public Supplier addSupplier(Supplier supplier) {
			entityManager.persist(supplier);
			return supplier;
		}


		@Override
		public void remove(int id) {
			Supplier supplier=findById(id);
			entityManager.remove(supplier);
		}
}
