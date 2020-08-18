package com.dxctraining.computer.entities;

import javax.persistence.*;

import com.dxctraining.item.entites.Item;
import com.dxctraining.supplier.entities.Supplier;



@Inheritance(strategy = InheritanceType.JOINED)
@Entity
@Table(name="computers")
public class Computer extends Item{
	
	@Id
	@GeneratedValue
	private int disksize;
	
	public Computer(int id, String name,Supplier supplier,int disksize) {
		super(id,name,supplier);
		this.disksize=disksize;
	}
	public Computer() {
		
	}
	public int getDisksize() {
		return disksize;
	}
	public void setDisksize(int disksize) {
		this.disksize = disksize;
	}
}