package com.dxctraining.inventorymgt.item.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dxctraining.inventorymgt.item.dao.*;
import com.dxctraining.inventorymgt.item.entities.Item;
import com.dxctraining.inventorymgt.item.exceptions.*;

@Transactional
@Service
public class ItemServiceImpl implements IItemService
{
	
	@Autowired
	private IItemDao dao;
	

	@Override
	public Item addItem(Item item) {
		display(item);
		item=dao.addItem(item);
		return item;
	}

	public void display(Object arg) {
		if(arg==null) {
			throw new InvalidArgumentException("argument is null");
		}
		
	}

	@Override
	public Item findItemById(int id) {
		Item item=dao.findItemById(id);
		return item;
	}

	@Override
	public void removeItem(int id) {
		dao.remove(id);
		
	}	
}
