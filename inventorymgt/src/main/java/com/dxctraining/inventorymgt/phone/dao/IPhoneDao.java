package com.dxctraining.phone.dao;

import com.dxctraining.phone.entities.Phone;

public interface IPhoneDao {
	Phone add(Phone phone);
	Phone findPhoneBySerialnum(int serialnum);
		 void remove(int serialnum);
}