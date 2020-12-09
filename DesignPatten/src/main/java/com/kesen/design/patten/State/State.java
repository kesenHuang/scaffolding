package com.kesen.design.patten.State;

public enum State {
	SMALL(0),
	SUPPER(1),
	FIRE(2),
	CAPE(3);

	private int value;

	private  State(int value) {
		this.value =  value;
	}

	public int getValue() {
		return  this.value;
	}

}
