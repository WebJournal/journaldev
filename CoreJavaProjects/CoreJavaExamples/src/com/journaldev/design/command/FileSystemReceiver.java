package com.journaldev.design.command;

public interface FileSystemReceiver {

	void openFile();
	void writeFile();
	void closeFile();
}
