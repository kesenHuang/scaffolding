package com.kesen.design.patten.Flyweight;

import java.util.HashMap;
import java.util.Map;

/**
 * @Auther: kesen
 * @Date: 2020/5/8 21:01
 * @Description:
 **/
public class ChessBoard2 {
	private Map<Integer, ChessPiece2> chessPieces = new HashMap<>();

	public ChessBoard2() {
		init();
	}

	private void init() {
		chessPieces.put(1, new ChessPiece2(ChessPieceUnitFactory.getChessPiece(1), 0, 0));
		chessPieces.put(1, new ChessPiece2(ChessPieceUnitFactory.getChessPiece(2), 1, 0));    //...省略摆放其他棋子的代码...  }
	}

	public void move(int chessPieceId, int toPositionX, int toPositionY) {
		//...省略...
	}
}
