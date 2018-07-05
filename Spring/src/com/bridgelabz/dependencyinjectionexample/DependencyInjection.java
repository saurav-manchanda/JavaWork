package com.bridgelabz.dependencyinjectionexample;

public class DependencyInjection {
	public static void main(String[] args) {
		Triange triange=new Triange();
		DrawingClass d=new DrawingClass();
		d.setShape(triange);
		d.drawShape();
	}
}
