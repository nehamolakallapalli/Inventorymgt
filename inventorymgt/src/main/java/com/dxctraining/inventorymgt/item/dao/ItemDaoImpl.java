package com.dxctraining.inventorymgt.item.dao;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dxctraining.inventorymgt.item.entities.Item;
import com.dxctraining.inventorymgt.item.exceptions.ItemNullException;
import com.dxctraining.inventorymgt.item.entities.Computer;
import java.util.List;

@Repository
public class ItemDaoImpl implements IItemDao{
	
	@Autowired
	private EntityManager em;
	
	@Override
	public Item findById(int id) {
		Item item = em.find(Item.class, id);
		if(item == null) {
			throw new ItemNullException("item is null");
		}
		return item;
	}

	@Override
	public Item addItem(Item item) {
		em.persist(item);
		return item;
	}

	@Override
	public void removeItem(int id) {
		Item item = findById(id);
		em.remove(item);
	}
	 @Override
	    public List<Computer> allComputer() {
	        String jpaql="from Computer";
	        TypedQuery<Computer>query=em.createQuery(jpaql,Computer.class);
	        List<Computer>computerList=query.getResultList();
	        return computerList;
	    }

}
