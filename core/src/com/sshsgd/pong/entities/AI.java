package com.sshsgd.pong.entities;

public class AI extends Paddle {

	Ball b;
	
	public AI(float width, float height, int side, Ball b) {
		super(width, height, side);
		this.b = b;
	}

	@Override
	public void behave() {
		if(b.getY() > getY() + getHeight()) {
			yVel = 10;
		}else if(b.getY() < getY()) {
			yVel = -10;
		}
	}

}
