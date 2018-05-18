package com.journaldev.abstractfactory;

import com.journaldev.beans.Computer;

public class ComputerFactory {

	public static Computer createComputer(ComputerAbstractFactory caf) {
		return caf.createComputer();
	}
}
