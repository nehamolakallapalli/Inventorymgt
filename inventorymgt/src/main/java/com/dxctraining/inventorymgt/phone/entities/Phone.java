package com.dxctraining.phone.entities;

import javax.persistence.*;

import com.dxctraining.item.entites.Item;
import com.dxctraining.supplier.entities.Supplier;

@Inheritance(strategy = InheritanceType.JOINED)
@Entity
@Table(name="phones")
public class Phone extends Item {
	
	@Id
	@GeneratedValue
	private int storagesize;
	
	public Phone(int id, String name,Supplier supplier,int storagesize) {
		super( id,name,supplier);
		this.storagesize=storagesize;
	}
	public Phone() {
		
	}
	public int getStoragesize() {
		return storagesize;
	}
	public void setStoragesize(int storagesize) {
		this.storagesize = storagesize;
	}
	
	@Override
	public int hashCode() {
		return id;
	}

	@Override
	public boolean equals(Object object) {
		if (this == object)
			return true;
		if (object == null || getClass() != object.getClass()) {
			return false;
		}
		Phone that = (Phone) object;
		return id == that.id;
	}
}