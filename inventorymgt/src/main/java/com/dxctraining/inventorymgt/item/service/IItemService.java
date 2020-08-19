package com.dxctraining.inventorymgt.item.service;

import com.dxctraining.inventorymgt.item.entities.*;

public interface IItemService 
{
	Item addItem(Item item);
	Item findItemById(int id);
	void removeItem(int id);
}
