package com.dxctraining.phone.service;

import com.dxctraining.phone.entities.Phone;

public interface IPhoneService {
	Phone add(Phone phone);
	Phone findPhoneBySerialnum(int serialnum);
		 void remove(int serialnum);

}