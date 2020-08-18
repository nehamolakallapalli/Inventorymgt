package com.dxctraining.inventorymgt.supplier.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Supplier 
{
		@Id
		@GeneratedValue
		private int id;
		private String name;
		
		public Supplier(int id,String name) {
			this.id=id;
			this.name = name;
		}
		public Supplier() {
			//this("");
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
		@Override
		public int hashCode() {
			return id;
		}
		@Override
		public boolean equals(Object o) {
			if(this == o) {
				return true;
			}
			if(o == null || !(o instanceof Supplier)) {
				return false;
			}
			Supplier supplier = (Supplier) o;
			boolean isequals = this.id == supplier.id;
			return isequals;
			
		}
}
