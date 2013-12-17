package com.journaldev.design.visitor;

public interface ItemElement {

	public int accept(ShoppingCartVisitor visitor);
}
