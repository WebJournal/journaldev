package com.journaldev.test;

import com.journaldev.abstractfactory.ComputerFactory;
import com.journaldev.abstractfactory.LaptopFactory;
import com.journaldev.abstractfactory.PCFactory;
import com.journaldev.abstractfactory.ServerFactory;
import com.journaldev.beans.Computer;

public class ComputerClient {

	public static void main(String[] args) {

		Computer pc = ComputerFactory.createComputer(new PCFactory("2 GB","500 GB","2.4 GHz"));
		
		Computer server = ComputerFactory.createComputer(new ServerFactory("2 GB","500 GB","2.4 GHz"));
		
		Computer laptop = ComputerFactory.createComputer(new LaptopFactory());
	}

}
