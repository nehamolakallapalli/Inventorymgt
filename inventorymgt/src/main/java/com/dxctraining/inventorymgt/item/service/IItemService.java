package com.dxctraining.inventorymgt.item.service;

import com.dxctraining.inventorymgt.item.entities.*;

public interface IItemService 
{
	Item add(Item item);
	Item findById(int id);
	void remove(int id);
}
