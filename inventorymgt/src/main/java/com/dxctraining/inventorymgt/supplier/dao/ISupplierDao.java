package com.dxctraining.inventorymgt.supplier.dao;

import com.dxctraining.inventorymgt.supplier.entities.*;

public interface ISupplierDao 
{
	Supplier findById(int id);
	Supplier addSupplier(Supplier supplier);
	void remove(int id);
}
