package com.dxctraining.computer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dxctraining.computer.dao.IComputerDao;
import com.dxctraining.computer.entities.Computer;
import com.dxctraining.computer.exceptions.InvalidArgumentException;

@Transactional
@Service
public class ComputerServiceImpl implements IComputerService {

	@Autowired
	private IComputerDao dao;

	@Override
	public Computer add(Computer computer) {
		display(computer);
		computer = dao.add(computer);
		return computer;
	}

	public void display(Object arg) {
		if (arg == null) {
			throw new InvalidArgumentException("argument is null");
		}

	}

	@Override
	public Computer findComputerBySerialnum(int serialnum) {
		Computer computer = dao.findComputerBySerialnum(serialnum);
		return computer;
	}

	@Override
	public void remove(int serialnum) {
		dao.remove(serialnum);

	}

}