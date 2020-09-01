package com.dxctraining.mongoexperiments.suppliermgt.service;

import com.dxctraining.mongoexperiments.suppliermgt.entities.Supplier;

public interface ISupplierService {

    Supplier save(Supplier supplier);

    void removeSupplierById(String id);

	Supplier findSupplierById(String id);

}