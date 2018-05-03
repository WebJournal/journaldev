package com.journaldev.abstractfactory;

import com.journaldev.beans.Computer;
import com.journaldev.beans.Laptop;

public class LaptopFactory implements ComputerAbstractFactory {

	@Override
	public Computer createComputer() {
		return new Laptop();
	}

}
