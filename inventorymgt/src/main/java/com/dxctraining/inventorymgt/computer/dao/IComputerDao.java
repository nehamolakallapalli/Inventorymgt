package com.dxctraining.computer.dao;

import com.dxctraining.computer.entities.Computer;

public interface IComputerDao {
	Computer add(Computer  computer);
	Computer findComputerBySerialnum(int serialnum);
		 void remove(int serialnum);
}