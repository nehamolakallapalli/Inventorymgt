package com.dxctraining.phone.dao;

import org.springframework.stereotype.Repository;

import com.dxctraining.phone.entities.Phone;
import com.dxctraining.phone.exceptions.PhoneNotFoundException;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class PhoneDaoImpl implements IPhoneDao {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public Phone add(Phone phone) {
		entityManager.persist(phone);
		return phone;
	}

	@Override
	public Phone findPhoneBySerialnum(int serialnum) {
		Phone phone= entityManager.find(Phone.class, serialnum);
		if (phone == null) {
			throw new PhoneNotFoundException("phone not found for the given serialnumber" +serialnum);
		}
		return phone;
	}

	@Override
	public void remove(int serialnum) {
		Phone phone= findPhoneBySerialnum(serialnum);
		entityManager.remove(phone);
	}
}