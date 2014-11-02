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
	
	public Ball(Vector2 position, float width, float height) {
		bounds = new Rectangle(position.x, position.y, width, height);
		spawn = new Vector2(position);
		init();
	}

	public Ball(float x, float y, float width, float height) {
		bounds = new Rectangle(x, y, width, height);
		spawn = new Vector2(x, y);
		init();
	}

	@Override
	protected void init() {
		vel = new Vector2();
		reset();
		
	}
	
	@Override
	public void draw(ShapeRenderer sr, SpriteBatch sb) {

		sr.ellipse(getX(), getY(), getWidth(), getHeight());
		
	}
	
	public void update() {
		wallCollisions();
		bounds.x += vel.x;
		bounds.y += vel.y;
	}
	
	private void wallCollisions() {
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
	
	public void collisions() {}
	
	public void bounceX() {
		vel.x *= -1;
	}
	
	public void bounceY() {
		vel.y *= -1;
	}
	
	public void reset() {
		speed = 10;
		radians = MathUtils.random(2 * MathUtils.PI);
		vel.set(0, 0);
		bounds.x = spawn.x;
		bounds.y  = spawn.y;
		vel.x = MathUtils.cos(radians) * speed;
		vel.y = MathUtils.sin(radians) * speed;
	}

}
