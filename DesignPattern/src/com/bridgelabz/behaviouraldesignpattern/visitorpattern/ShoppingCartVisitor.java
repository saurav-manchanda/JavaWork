package com.bridgelabz.behaviouraldesignpattern.visitorpattern;

public interface ShoppingCartVisitor {

	int visit(Book book);
	int visit(Fruit fruit);
}
