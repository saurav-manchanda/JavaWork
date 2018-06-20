package com.bridgelabz.behaviouraldesignpattern.visitorpattern;

public interface ItemElement {
	public int accept(ShoppingCartVisitor visitor);
}
