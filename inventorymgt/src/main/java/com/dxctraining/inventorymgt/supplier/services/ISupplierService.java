package com.dxctraining.inventorymgt.supplier.services;
import com.dxctraining.inventorymgt.supplier.entities.*;
public interface ISupplierService 
{
	Supplier addSupplier(Supplier supplier);
	Supplier findById(int id);
	void remove(int id);
}
