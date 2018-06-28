package com.bridgelabz.initializinglist;

import java.util.List;

public class Triangle {
	private List<Point> list;

	public List<Point> getList() {
		return list;
	}

	public void setList(List<Point> list) {
		this.list = list;
	}
	
	public void draw() {
		for(int i=0;i<list.size();i++) {
			System.out.println("Point = ("+list.get(i).getX()+","+list.get(i).getY()+")");
		}
		
	}
}
