package com.kesen.design.patten.State;

/**
 * @Auther: kesen
 * @Date: 2020/5/14 07:19
 * @Description:
 **/
public class MarioStateMachine {

	private int score;

	private State currentState;

	public MarioStateMachine() {
		this.score = 0;
		this.currentState = State.SMALL;
	}

	public void obtainMushRoom() {

	}

	public void obtainCape() {

	}

	public void obtainFireFlower() {
		
	}

	public void meetMonster() {
	}

	public int getScore() {
		return score;
	}


	public State getCurrentState() {
		return currentState;
	}

}
