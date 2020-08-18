package com.dxctraining.inventorymgt.item.dao;
import com.dxctraining.inventorymgt.item.entities.Item;
public interface IItemDao 
{
		 Item addItem(Item item);
		 void remove(int id);
		 void itemDetails(Item item);
		 Item findById(int id);
		 
}
