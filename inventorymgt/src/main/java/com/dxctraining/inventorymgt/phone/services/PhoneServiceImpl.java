package com.dxctraining.phone.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dxctraining.phone.dao.IPhoneDao;
import com.dxctraining.phone.entities.Phone;
import com.dxctraining.phone.exceptions.InvalidArgumentException;


@Transactional
@Service
public class PhoneServiceImpl implements IPhoneService {

	@Autowired
	private IPhoneDao dao;

	@Override
	public Phone add(Phone phone) {
		display(phone);
		phone = dao.add(phone);
		return phone;
	}

	public void display(Object arg) {
		if (arg == null) {
			throw new InvalidArgumentException("argument is null");
		}

	}

	@Override
	public Phone findPhoneBySerialnum(int serialnum) {
		Phone phone= dao.findPhoneBySerialnum(serialnum);
		return phone;
	}

	@Override
	public void remove(int serialnum) {
		dao.remove(serialnum);

	}
}