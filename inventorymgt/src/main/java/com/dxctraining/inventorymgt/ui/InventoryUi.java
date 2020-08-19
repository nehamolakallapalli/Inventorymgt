package com.dxctraining.inventorymgt.ui;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.dxctraining.inventorymgt.supplier.entities.Supplier;
import com.dxctraining.inventorymgt.supplier.exceptions.*;
import com.dxctraining.inventorymgt.supplier.services.ISupplierService;

@Component
public class InventoryUi 
{
	  @Autowired
	    private ISupplierService supplierService;
	
	    @PostConstruct
	    public void runApp() 
	    {
	        try {
	            //SUPPLIERS
	            Supplier supplier1 = new Supplier("a1 suppliers");
	            Supplier supplier2 = new Supplier("a2 suppliers");
	            supplierService.addSupplier(supplier1);
	            supplierService.addSupplier(supplier2);
	            int id1=supplier1.getId();
	            Supplier su1=supplierService.findById(id1);
	            System.out.println(su1.getId()+"  "+su1.getName());
	            
	        } 
	        catch (InvalidArgumentException e) {
	            e.printStackTrace();
	        }
	    }
}
