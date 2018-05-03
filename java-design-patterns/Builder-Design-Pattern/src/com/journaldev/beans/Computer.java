package com.journaldev.beans;

public class Computer {

	//required parameters
	private String RAM;
	private String HDD;
	private String CPU;
	
	
	//optional parameters
	private boolean isGraphicsCardEnabled;
	private boolean isBluetoothEnabled;
	
	private Computer(Builder builder) {
		this.HDD = builder.HDD;
		this.CPU = builder.CPU;
		this.RAM = builder.RAM;
		this.isBluetoothEnabled = builder.isBluetoothEnabled;
		this.isGraphicsCardEnabled = builder.isGraphicsCardEnabled;
	}
	
	public String getRAM() {
		return RAM;
	}
	public String getHDD() {
		return HDD;
	}
	public String getCPU() {
		return CPU;
	}
	public boolean isGraphicsCardEnabled() {
		return isGraphicsCardEnabled;
	}
	public boolean isBluetoothEnabled() {
		return isBluetoothEnabled;
	}
	
	public static class Builder{
		//required parameters
		private String RAM;
		private String HDD;
		private String CPU;
		
		
		//optional parameters
		private boolean isGraphicsCardEnabled;
		private boolean isBluetoothEnabled;
		
		public Builder(String ram, String hdd, String cpu) {
			this.RAM = ram;
			this.HDD = hdd;
			this.CPU = cpu;
		}

		public Builder setGraphicsCardEnabled(boolean isGraphicsCardEnabled) {
			this.isGraphicsCardEnabled = isGraphicsCardEnabled;
			return this;
		}

		public Builder setBluetoothEnabled(boolean isBluetoothEnabled) {
			this.isBluetoothEnabled = isBluetoothEnabled;
			return this;
		}
		
		public Computer build() {
			return new Computer(this);
		}
	}

}
