package com.journaldev.design.memento;

public class FileWriterUtil {

	private String fileName;
	private StringBuilder content;
	
	public FileWriterUtil(String file){
		this.fileName=file;
		this.content=new StringBuilder();
	}
	
	@Override
	public String toString(){
		return this.content.toString();
	}
	
	public void write(String str){
		content.append(str);
	}
	
	public Memento save(){
		return new Memento(this.fileName,this.content);
	}
	
	public void undoToLastSave(Object obj){
		Memento memento = (Memento) obj;
		this.fileName= memento.fileName;
		this.content=memento.content;
	}
	
	
	private class Memento{
		private String fileName;
		private StringBuilder content;
		
		public Memento(String file, StringBuilder content){
			this.fileName=file;
			//notice the deep copy so that Memento and FileWriterUtil content variables don't refer to same object
			this.content=new StringBuilder(content);
		}
	}
}
