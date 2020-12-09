package com.kesen.design.patten.Flyweight;

/**
 * @Auther: kesen
 * @Date: 2020/5/8 20:55
 * @Description:
 **/
public class ChessPieceUnit {
	private int id;
	private String text;
	private Color color;

	public ChessPieceUnit(int id, String text, Color color) {
		this.id = id;
		this.text = text;
		this.color = color;
	}

	public static enum Color {RED, BLACK}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}
}
