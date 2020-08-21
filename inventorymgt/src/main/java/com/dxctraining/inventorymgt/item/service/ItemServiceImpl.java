package com.dxctraining.inventorymgt.item.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dxctraining.inventorymgt.item.dao.IItemDao;
import com.dxctraining.inventorymgt.item.entities.Item;
import com.dxctraining.inventorymgt.item.exceptions.InvalidItemArgumentException;
import com.dxctraining.inventorymgt.item.entities.Computer;
import java.util.List;
@Transactional
@Service
public class ItemServiceImpl implements IItemService
{	
	@Autowired
	private IItemDao dao;
	
	@Override
	public Item findById(int id) {
		validateId(id);
		Item item = dao.findById(id);
		return item;
	}

	private void validateId(int id) {
		if(id == 0) {
			throw new InvalidItemArgumentException("id should not be null");
		}
	}

	@Override
	public Item addItem(Item item) {
		validateItem(item);
		item = dao.addItem(item);
		return item;
	}

	private void validateItem(Item item) {
		if(item == null) {
			throw new InvalidItemArgumentException("item is invalid");
		}
		
	}

	@Override
	public void removeItem(int id) {
		dao.removeItem(id);	
	}
	 @Override
	    public List<Computer> allComputer(){
	        List<Computer>allcomputer=dao.allComputer();
	        return allcomputer;
	    }
}
