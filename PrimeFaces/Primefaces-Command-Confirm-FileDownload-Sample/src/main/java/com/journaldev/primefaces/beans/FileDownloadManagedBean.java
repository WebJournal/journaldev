package com.journaldev.primefaces.beans;

import java.io.File;
import java.io.FileInputStream;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

@ManagedBean
@SessionScoped
public class FileDownloadManagedBean {
	private StreamedContent content;
	
	{	
		try {
			content = new DefaultStreamedContent(new FileInputStream(
					new File("D:\\primefaces\\primefaces_user_guide_5_0.pdf")),"application/pdf","primefaces_5");
		}
		catch(Exception e){
			// Nothing
		}
	}

	public StreamedContent getContent() {
		return content;
	}

	public void setContent(StreamedContent content) {
		this.content = content;
	}
	
}
