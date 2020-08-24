package com.dxctraining.inventorymgt.supplier.dao;

import com.dxctraining.inventorymgt.supplier.entities.Supplier;
import java.util.List;
public interface ISupplierDao {
	Supplier findById(int id);
	Supplier addSupplier(Supplier supplier);
	void removeSupplier(int id);
	List<Supplier>listAll();
}
