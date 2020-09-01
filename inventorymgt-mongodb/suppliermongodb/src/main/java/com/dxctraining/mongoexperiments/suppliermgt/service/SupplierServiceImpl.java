package com.dxctraining.mongoexperiments.suppliermgt.service;

import com.dxctraining.mongoexperiments.suppliermgt.entities.*;
import com.dxctraining.mongoexperiments.suppliermgt.exceptions.*;
import com.dxctraining.mongoexperiments.suppliermgt.dao.ISupplierDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SupplierServiceImpl implements ISupplierService {

	@Autowired
	private ISupplierDao dao;

	@Override
	public Supplier save(Supplier supplier) {
		supplier = dao.save(supplier);
		return supplier;
	}

	@Override
	public Supplier findSupplierById(String id) {
		Optional<Supplier> optional = dao.findById(id);
		boolean exist = optional.isPresent();
		if (!exist) {
			throw new SupplierNotFoundException("supplier not found for id=" + id);
		}
		Supplier supplier = optional.get();
		return supplier;
	}

	@Override
	public void removeSupplierById(String id) {
		dao.deleteById(id);
	}
}