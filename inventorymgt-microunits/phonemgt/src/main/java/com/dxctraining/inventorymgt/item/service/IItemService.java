package com.dxctraining.inventorymgt.item.service;

import com.dxctraining.inventorymgt.item.entities.Item;
import com.dxctraining.inventorymgt.item.entities.Phone;
import java.util.List;
public interface IItemService 
{
	Item findById(int id);
	Item addItem(Item item);
	Item updateItem(Item item);
	void removeItem(int id);
	List<Phone> allPhone();
	List<Phone>phoneBySupplier(int supplierId);
}