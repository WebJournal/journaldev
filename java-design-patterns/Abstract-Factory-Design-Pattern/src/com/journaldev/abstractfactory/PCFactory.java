package com.journaldev.abstractfactory;

import com.journaldev.beans.Computer;
import com.journaldev.beans.PC;

public class PCFactory implements ComputerAbstractFactory {

	@Override
	public Computer createComputer() {
		return new PC(this.RAM, this.HDD, this.CPU);
	}

	private String RAM;
	private String HDD;
	private String CPU;

	public PCFactory(String ram, String hdd, String cpu) {
		this.RAM = ram;
		this.HDD = hdd;
		this.CPU = cpu;
	}
}
