package com.dxctraining.inventorymgt.item.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dxctraining.item.dao.IItemDao;
import com.dxctraining.item.entites.Item;
import com.dxctraining.item.exceptions.InvalidArgumentException;

@Transactional
@Service
public class ItemServiceImpl implements IItemService
{
	
	@Autowired
	private IItemDao dao;
	

	@Override
	public Item add(Item item) {
		display(item);
		item=dao.add(item);
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
	public void remove(int id) {
		dao.remove(id);
		
	}	
}
