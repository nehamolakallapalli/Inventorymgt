package com.dxctraining.inventorymgt.item.service;

import com.dxctraining.inventorymgt.item.entities.Item;
import com.dxctraining.inventorymgt.item.entities.Computer;
import com.dxctraining.inventorymgt.item.entities.Phone;
import java.util.List;
public interface IItemService 
{
	Item findById(int id);
	Item addItem(Item item);
	void removeItem(int id);
	List<Computer> allComputer();
	List<Phone> allPhone();
}