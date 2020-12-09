package com.kesen.design.patten.Flyweight;

/**
 * @Auther: kesen
 * @Date: 2020/5/8 21:00
 * @Description: 采用享元模式的棋子类
 **/
public class ChessPiece2 {
	// 每个棋子共有属性
	private ChessPieceUnit chessPieceUnit;
	// 每个棋子特有属性
	private int positionX;
	private int positionY;

	public ChessPiece2(ChessPieceUnit unit, int positionX, int positionY) {
		this.chessPieceUnit = unit;
		this.positionX = positionX;
		this.positionY = positionY;
	}  // 省略getter、setter方法
}
