package com.dxctraining.computer.dao;

import org.springframework.stereotype.Repository;

import com.dxctraining.computer.entities.Computer;
import com.dxctraining.computer.exceptions.ComputerNotFoundException;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class ComputerDaoImpl implements IComputerDao {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public Computer add(Computer computer) {
		entityManager.persist(computer);
		return computer;
	}

	@Override
	public Computer findComputerBySerialnum(int serialnum) {
		Computer computer = entityManager.find(Computer.class, serialnum);
		if (computer == null) {
			throw new ComputerNotFoundException("computer not found for the given serialnumber" +serialnum);
		}
		return computer;
	}

	@Override
	public void remove(int serialnum) {
		Computer computer = findComputerBySerialnum(serialnum);
		entityManager.remove(computer);
	}

}