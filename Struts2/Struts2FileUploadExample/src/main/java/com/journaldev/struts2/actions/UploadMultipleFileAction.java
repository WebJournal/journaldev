package com.journaldev.struts2.actions;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

import javax.servlet.ServletContext;

import org.apache.struts2.util.ServletContextAware;

import com.journaldev.struts2.util.FilesUtil;
import com.opensymphony.xwork2.ActionSupport;

public class UploadMultipleFileAction extends ActionSupport implements ServletContextAware{

	private static final long serialVersionUID = -4748500436762141236L;

	@Override
	public String execute(){
		System.out.println("No of files="+getFile().length);
		System.out.println("File Names are:"+Arrays.toString(getFileFileName()));
		
		for(int i=0; i < getFile().length; i++){
		System.out.println("File Name is:"+getFileFileName()[i]);
		System.out.println("File ContentType is:"+getFileContentType()[i]);
		System.out.println("Files Directory is:"+filesPath);
		try {
			FilesUtil.saveFile(getFile()[i], getFileFileName()[i], context.getRealPath("") + File.separator + filesPath);
		} catch (IOException e) {
			e.printStackTrace();
			return INPUT;
		}
		}
		return SUCCESS;
		
	}
	
	private File[] file;
	private String[] fileContentType;
	private String[] fileFileName;
	private String filesPath;
	/**
	 * We could use List also for files variable references and declare them as:
	 * 
	 * private List<File> file = new ArrayList<File>();
	 * private List<String> fileContentType = new ArrayList<String>();
	 * private List<String> fileFileName = new ArrayList<String>();
	 */
	
	
	private ServletContext context;


	public File[] getFile() {
		return file;
	}

	public void setFile(File[] file) {
		this.file = file;
	}

	public String[] getFileContentType() {
		return fileContentType;
	}

	public void setFileContentType(String[] fileContentType) {
		this.fileContentType = fileContentType;
	}

	public String[] getFileFileName() {
		return fileFileName;
	}

	public void setFileFileName(String[] fileFileName) {
		this.fileFileName = fileFileName;
	}

	public void setFilesPath(String filesPath) {
		this.filesPath = filesPath;
	}

	@Override
	public void setServletContext(ServletContext ctx) {
		this.context=ctx;
	}
	
}
