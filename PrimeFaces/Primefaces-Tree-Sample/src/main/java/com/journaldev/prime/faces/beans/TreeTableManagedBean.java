package com.journaldev.prime.faces.beans;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.primefaces.event.ColumnResizeEvent;
import org.primefaces.model.DefaultTreeNode;
import org.primefaces.model.TreeNode;

import com.journaldev.prime.faces.data.Document;

@ManagedBean
@SessionScoped
public class TreeTableManagedBean {
	
	private TreeNode root = new DefaultTreeNode("Root Node", null);
	private TreeNode singleSelectedNode;
	private TreeNode [] multipleSelectedNodes;
	private TreeNode [] checkboxSelectedNodes;

	public TreeTableManagedBean(){
		// Populate Document Instances
		Document doc01 = new Document("Primefaces Tutorial","1","Primefaces Company");	
		Document doc02 = new Document("Hibernate Tutorial","2","JournalDev");
		// Create Documents TreeNode
		TreeNode documents01 = new DefaultTreeNode(new Document("Documents","0","Documents"), this.root);
		// Create Document TreeNode
		TreeNode document01 = new DefaultTreeNode(doc01, documents01);
		TreeNode document02 = new DefaultTreeNode(doc02, documents01);
		
		// Create Documents TreeNode
		TreeNode documents02 = new DefaultTreeNode(new Document("Documents","0","Documents"), this.root);
		// Create Document TreeNode
		TreeNode document03 = new DefaultTreeNode(doc01, documents02);
		TreeNode document04 = new DefaultTreeNode(doc02, documents02);		
	}
	
	public TreeNode getRoot() {
		return root;
	}

	public void setRoot(TreeNode root) {
		this.root = root;
	}

	public TreeNode getSingleSelectedNode() {
		return singleSelectedNode;
	}

	public void setSingleSelectedNode(TreeNode singleSelectedNode) {
		this.singleSelectedNode = singleSelectedNode;
	}

	public TreeNode[] getMultipleSelectedNodes() {
		return multipleSelectedNodes;
	}

	public void setMultipleSelectedNodes(TreeNode[] multipleSelectedNodes) {
		this.multipleSelectedNodes = multipleSelectedNodes;
	}

	public TreeNode[] getCheckboxSelectedNodes() {
		return checkboxSelectedNodes;
	}

	public void setCheckboxSelectedNodes(TreeNode[] checkboxSelectedNodes) {
		this.checkboxSelectedNodes = checkboxSelectedNodes;
	}
	
	public String viewSelectedNodes(){
		String message = "You've selected documents :: ";
		message+="- "+((Document)this.singleSelectedNode.getData()).getName()+"\n";
		for(TreeNode node : this.multipleSelectedNodes){
			message+="- "+((Document)node.getData()).getName()+"\n";	
		}
		for(TreeNode node : this.checkboxSelectedNodes){
			message+="- "+((Document)node.getData()).getName()+"\n";	
		}		
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(message));
		return "";
	}
	
	public void colResizeListener(ColumnResizeEvent e){
		String message ="Column resize event is thrown";
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(message));
	}
}
