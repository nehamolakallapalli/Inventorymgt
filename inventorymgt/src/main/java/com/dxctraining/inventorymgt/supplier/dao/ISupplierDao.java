package com.dxctraining.inventorymgt.supplier.dao;

import com.dxctraining.inventorymgt.supplier.entities.*;

public interface ISupplierDao 
{
		Supplier addSupplier(Supplier supplier);
		Supplier findById(int id);
		void remove(int id);
}
