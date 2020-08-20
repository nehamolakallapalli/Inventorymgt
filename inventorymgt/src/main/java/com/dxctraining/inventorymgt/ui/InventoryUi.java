package com.dxctraining.inventorymgt.ui;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.dxctraining.inventorymgt.item.service.IItemService;
import com.dxctraining.inventorymgt.item.entities.*;
import com.dxctraining.inventorymgt.supplier.entities.Supplier;
import com.dxctraining.inventorymgt.supplier.exceptions.*;
import com.dxctraining.inventorymgt.supplier.services.ISupplierService;
import java.util.ArrayList;
import java.util.List;

@Component
public class InventoryUi 
{
	@Autowired
	private ISupplierService supplierService;
	@Autowired
	private IItemService itemService;
		
	@PostConstruct
	public void runApp() 
	{
		try {
			List<Item> list = new ArrayList<>();
			//SUPPLIERS
			Supplier supplier1 = new Supplier("a1 suppliers");
			supplierService.addSupplier(supplier1);
			Supplier supplier2 = new Supplier("a2 suppliers");
			supplierService.addSupplier(supplier2);
			Supplier supplier3 = new Supplier("a3 suppliers");
			supplierService.addSupplier(supplier3);
	        
			//ITEM
			Item item1 = new Item("aaa",supplier1);
			Item item2 = new Item("bbb",supplier2);
			Item item3 = new Item("ccc",supplier3);
			list.add(item1);
			itemService.addItem(item1);
	        list.add(item2);
	        itemService.addItem(item2);
	        list.add(item3);
	        itemService.addItem(item3);
				
	        System.out.println("*****Fetching supplier by id*****");
	        int id1=supplier1.getId();
	        Supplier su1=supplierService.findById(id1);
	        System.out.println("fetched id is"+su1.getId()+"fetched supplier is "+su1.getName());
	            
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
		catch(SupplierNullException e)
		{
			e.printStackTrace();
		}
	}
}
