package com.dxctraining.inventorymgt.item.entities;

import com.dxctraining.inventorymgt.supplier.entities.Supplier;
import javax.persistence.*;

@Entity
@Table(name = "items")
@Inheritance(strategy = InheritanceType.JOINED)
public class Item 
{
	    private int id;
	    private String name;
	    @ManyToOne
	    private Supplier supplier;

	    public Item(int id, String name, Supplier supplier) {
	        this.id = id;
	        this.name = name;
	        this.supplier = supplier;
	    }

	    public int getId() {
	        return id;
	    }


	    public void setId(int id) {
	        this.id = id;
	    }

	    public String getName() {
	        return name;
	    }

	    public void setName(String name) {
	        this.name = name;
	    }

	    public Supplier getSupplier() {
	        return supplier;
	    }

	    public void setSupplier(Supplier supplier) {
	        this.supplier = supplier;
	    }
}
