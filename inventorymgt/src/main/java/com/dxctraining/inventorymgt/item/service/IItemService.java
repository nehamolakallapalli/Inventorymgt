package com.dxctraining.inventorymgt.item.service;

import com.dxctraining.inventorymgt.item.entities.*;

public interface IItemService 
{
	Item findById(int id);
	Item addItem(Item item);
	void removeItem(int id);
}
