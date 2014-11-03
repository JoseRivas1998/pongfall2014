package com.sshsgd.pong.entities;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.sshsgd.pong.Game;

public class Ball extends Entity {
	
	private float speed, radians;
	private Vector2 vel;
	private Vector2 spawn;
	
	public static final int BOUNCE_TOP_BOTTOM = 0;
	public static final int BOUNCE_ALL_SIDES = 1;
	
	private int bounceMode;
	
	public Ball(Vector2 position, float width, float height, int bounceMode) {
		bounds = new Rectangle(position.x, position.y, width, height);
		spawn = new Vector2(position);
		this.bounceMode = bounceMode;
		init();
	}

	public Ball(float x, float y, float width, float height, int bounceMode) {
		bounds = new Rectangle(x, y, width, height);
		spawn = new Vector2(x, y);
		this.bounceMode = bounceMode;
		init();
	}

	@Override
	protected void init() {
		vel = new Vector2();
		reset();
		
	}
	
	@Override
	public void draw(ShapeRenderer sr, SpriteBatch sb) {

		sr.rect(getX(), getY(), getWidth(), getHeight());
		
	}
	
	public void update() {
		if(bounceMode == Ball.BOUNCE_ALL_SIDES) {
			bounceAllSides();
		}
		if(bounceMode == Ball.BOUNCE_TOP_BOTTOM) {
			bounceTopBottom();
		}
		bounds.x += vel.x;
		bounds.y += vel.y;
	}
	
	private void bounceAllSides() {
		if(getX() >= Game.SIZE.x - getWidth()) {
			bounds.x--;
			bounceX();
		}
		if(getX() <= 0) {
			bounds.x++;
			bounceX();
		}
		if(getY() >= Game.SIZE.y - getHeight()) {
			bounds.y--;
			bounceY();
		}
		if(getY() <= 0) {
			bounds.y++;
			bounceY();
		}
	
	}
	
	private void bounceTopBottom() {
		if(getX() >= Game.SIZE.x - getWidth() + 50) {
			reset();
		}
		if(getX() <= -50) {
			reset();
		}
		if(getY() >= Game.SIZE.y - getHeight()) {
			bounds.y--;
			bounceY();
		}
		if(getY() <= 0) {
			bounds.y++;
			bounceY();
		}
	
	
	}
	
	public void collisions(Paddle p) {
		if(collidingWith(p)) {
			if(p.getSide() == Paddle.LEFT) {
				bounds.x = p.getX() + p.getWidth() + 1;
				bounceX();
			}
			if(p.getSide() == Paddle.RIGHT) {
				bounds.x = p.getX() - getWidth() - 1;
				bounceX();
			}
		}
	}
	
	public void bounceX() {
		Game.res.getSound("beep").play();
		vel.x *= -1;
		if(vel.x > 0) {
			vel.x++;
		} else {
			vel.x--;
		}
	}
	
	public void bounceY() {
		Game.res.getSound("plop").play();
		vel.y *= -1;
		if(vel.y > 0) {
			vel.y++;
		} else {
			vel.y--;
		}
	}
	
	public void reset() {
		Game.res.getSound("peep").play();
		speed = 10;
		do {
			radians = MathUtils.random(2 * MathUtils.PI);
		} while(Math.abs(MathUtils.cos(radians) * speed) < 1.5);
		vel.set(0, 0);
		bounds.x = spawn.x;
		bounds.y  = spawn.y;
		vel.x = MathUtils.cos(radians) * speed;
		vel.y = MathUtils.sin(radians) * speed;
	}

	public Vector2 getSpawn() {
		return spawn;
	}

	public void setSpawn(Vector2 spawn) {
		this.spawn = spawn;
	}

}
