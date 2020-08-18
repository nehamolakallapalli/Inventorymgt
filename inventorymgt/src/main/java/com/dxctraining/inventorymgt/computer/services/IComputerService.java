package com.dxctraining.computer.service;

import com.dxctraining.computer.entities.Computer;

public interface IComputerService {
	Computer add(Computer  computer);
	Computer findComputerBySerialnum(int serialnum);
		 void remove(int serialnum);

}