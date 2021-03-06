package com.dxctraining.inventorymgt.supplier.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dxctraining.inventorymgt.supplier.dao.ISupplierDao;
import com.dxctraining.inventorymgt.supplier.entities.Supplier;
import com.dxctraining.inventorymgt.supplier.exceptions.InvalidSupplierArgumentException;
import com.dxctraining.inventorymgt.supplier.exceptions.SupplierNullException;
import java.util.List;

@Transactional
@Service
public class SupplierServiceImpl implements ISupplierService {
	
	@Autowired
	private ISupplierDao dao;
	
	@Override
	public Supplier findById(int id) {
		validateId(id);
		Supplier supplier = dao.findById(id);
		return supplier;
	}
	
	private void validateId(int id) {
		if(id == 0) {
			throw new InvalidSupplierArgumentException("id should not be null");
		}
		
	}

	@Override
	public Supplier addSupplier(Supplier supplier) {
		validateSupplier(supplier);
		dao.addSupplier(supplier);
		return supplier;
	}

	private void validateSupplier(Supplier supplier) {
		if(supplier == null) {
			throw new SupplierNullException("supplier is null");
		}
		
	}
	@Override
	public Supplier update(Supplier supplier) {
		validateSupplier(supplier);
		supplier = dao.update(supplier);
		return supplier;
	}
	@Override
	public void removeSupplier(int id) {
		validateId(id);
		dao.removeSupplier(id);
	}
	@Override
	public List<Supplier>listAll(){
        List<Supplier>allsuppliers=dao.listAll();
	       return allsuppliers;
	}
	@Override
	public boolean authentication(int id, String password) {
		Supplier supplier = dao.findById(id);
		String fetchedpassword = supplier.getPassword();
		boolean equals = fetchedpassword.equals(password);
		return equals;
	}
}
