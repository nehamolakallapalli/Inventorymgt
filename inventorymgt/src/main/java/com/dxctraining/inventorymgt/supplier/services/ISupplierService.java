package com.dxctraining.inventorymgt.supplier.services;
import com.dxctraining.inventorymgt.supplier.entities.*;
public interface ISupplierService 
{
	Supplier findById(int id);
	Supplier addSupplier(Supplier supplier);
	void removeSupplier(int id);
}
