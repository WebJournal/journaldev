package com.journaldev.abstractfactory;

import com.journaldev.beans.Computer;
import com.journaldev.beans.Server;

public class ServerFactory implements ComputerAbstractFactory {

	@Override
	public Computer createComputer() {
		return new Server(this.RAM, this.HDD, this.CPU);
	}

	private String RAM;
	private String HDD;
	private String CPU;

	public ServerFactory(String ram, String hdd, String cpu) {
		this.RAM = ram;
		this.HDD = hdd;
		this.CPU = cpu;
	}
}
