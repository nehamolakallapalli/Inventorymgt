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
	        try 
		{
	            Supplier supplier1 = new Supplier(1,"a1 suppliers");
	            Supplier supplier2 = new Supplier(2,"a2 suppliers");
	            supplierService.addSupplier(supplier1);
	            supplierService.addSupplier(supplier2);
	            int id1=supplier1.getId();
	            Supplier su1=supplierService.findById(id1);
	            System.out.println(su1.getId()+"  "+su1.getName());
		
		    Item item1 = new Item(1,"aaaa", supplier1);
		    itemService.addItem(item1);
		    Item item2 = new Item(2,"bbbb", supplier2);
		    itemService.addItem(item2);
		    Item item3 = new Item(3,"cccc", supplier3);
		    itemService.addItem(item3);
			
			System.out.println("*****Deleting a supplier*****");
			int id3 = supplier3.getId();
			supplierService.removeSupplier(id3);
			System.out.println("removed id"+id3);
			
			System.out.println("*****Fetching supplier by id*****");
			int id1 = supplier1.getId();
			Supplier fetched = supplierService.findById(id1);
			System.out.println("fetched id is "+fetched.getId()+" fetched supplier = "+fetched.getName());
			
			System.out.println("*****Deleting an item******");
			int itemid3 = item3.getId();
			itemService.removeItem(itemid3);
			System.out.println("removed item id is "+itemid3);
			
			System.out.println("******Fetching item by id******");
			int itemid1 = item1.getId();
			Item itemfetched = itemService.findById(itemid1);
			System.out.println("fetched item id is "+itemfetched.getId()+" fetched item name is "+itemfetched.getName());
			
	        } 
		catch (InvalidArgumentException e) {
	            e.printStackTrace();
	        }
	    }
}
