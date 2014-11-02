package com.sshsgd.pong.entities;

import com.sshsgd.pong.managers.MyInput;

public class Player extends Paddle {

	public Player(float width, float height, int side) {
		super(width, height, side);
	}

	@Override
	public void behave() {
		if(MyInput.isDown(MyInput.UP)) {
			yVel = 10;
		} else if(MyInput.isDown(MyInput.DOWN)) {
			yVel = -10;
		} else {
			yVel = 0;
		}
	}

}
