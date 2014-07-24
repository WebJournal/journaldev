package com.journaldev.prime.faces.beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ActionEvent;

import org.primefaces.event.NodeCollapseEvent;
import org.primefaces.event.NodeExpandEvent;
import org.primefaces.event.NodeSelectEvent;
import org.primefaces.event.NodeUnselectEvent;
import org.primefaces.model.DefaultTreeNode;
import org.primefaces.model.TreeNode;

@ManagedBean
@SessionScoped
public class TreeManagedBean {
	// TreeNode instance
	private TreeNode root;
	private TreeNode singleSelectedTreeNode;
	private TreeNode [] multipleSelectedTreeNodes;
	private TreeNode [] checkboxSelectedTreeNodes;
	
	public TreeManagedBean(){
		// This is the root node, so it's data is root and its parent is null
		this.root = new DefaultTreeNode("Root Node", null);
		// Create documents node
		TreeNode documents = new DefaultTreeNode("Documents", this.root);
		// Create document node
		TreeNode document01 = new DefaultTreeNode("document","Expenses.doc", documents);
		// Create images node
		TreeNode images = new DefaultTreeNode("Images", this.root);
		// Create image node
		TreeNode image01 = new DefaultTreeNode("image","Travel.gif", images);
		// Create videos node
		TreeNode videos = new DefaultTreeNode("Videos", this.root);
		// Create video node
		TreeNode video01 = new DefaultTreeNode("video","Play.avi", videos);
	}

	public TreeNode getRoot() {
		return root;
	}

	public void setRoot(TreeNode root) {
		this.root = root;
	}
	
	public TreeNode getSingleSelectedTreeNode() {
		return singleSelectedTreeNode;
	}

	public void setSingleSelectedTreeNode(TreeNode singleSelectedTreeNode) {
		this.singleSelectedTreeNode = singleSelectedTreeNode;
	}

	public TreeNode[] getMultipleSelectedTreeNodes() {
		return multipleSelectedTreeNodes;
	}

	public void setMultipleSelectedTreeNodes(TreeNode[] multipleSelectedTreeNodes) {
		this.multipleSelectedTreeNodes = multipleSelectedTreeNodes;
	}

	public TreeNode[] getCheckboxSelectedTreeNodes() {
		return checkboxSelectedTreeNodes;
	}

	public void setCheckboxSelectedTreeNodes(TreeNode[] checkboxSelectedTreeNodes) {
		this.checkboxSelectedTreeNodes = checkboxSelectedTreeNodes;
	}

	public void onNodeSelect(NodeSelectEvent event){
		System.out.println("Node Data ::"+event.getTreeNode().getData()+" :: Selected");
	}
	
	public void onNodeUnSelect(NodeUnselectEvent event){
		System.out.println("Node Data ::"+event.getTreeNode().getData()+" :: UnSelected");
	}
	
	public void onNodeExpand(NodeExpandEvent event){
		System.out.println("Node Data ::"+event.getTreeNode().getData()+" :: Expanded");
	}
	
	public void onNodeCollapse(NodeCollapseEvent event){
		System.out.println("Node Data ::"+event.getTreeNode().getData()+" :: Collapsed");
	}
	
	public String printSelectedNodes(){
		System.out.println("Single Selection Is :: "+this.singleSelectedTreeNode.getData());
		for(TreeNode n : this.multipleSelectedTreeNodes){
			System.out.println("Multiple Selection Are :: "+n.getData());	
		}
		for(TreeNode n : this.checkboxSelectedTreeNodes){
			System.out.println("CheckBox Selection Are :: "+n.getData());	
		}		
		return "";
	}
	
	public void view(ActionEvent e){
		System.out.println("View action has invoked against node :: "+this.singleSelectedTreeNode.getData());
	}
	
}
