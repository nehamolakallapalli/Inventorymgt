package com.dxctraining.mongoexperiments.suppliermgt.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Objects;

@Document("suppliers")
public class Supplier {

    @Id
    private String id;
    private String name;
    private String password;

    public Supplier(){

    }

    public Supplier(String name, String password){
        this.name=name;
        this.password = password;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	 @Override
    public int hashCode() {
		 return Objects.hash(id);
    }

	@Override
    public boolean equals(Object arg) {
        if (this == arg) 
        	return true;
        if (arg == null || getClass() != arg.getClass()) {
        	return false;
	}
        Supplier supplier = (Supplier) arg;
        return Objects.equals(id, supplier.id);
    }
}