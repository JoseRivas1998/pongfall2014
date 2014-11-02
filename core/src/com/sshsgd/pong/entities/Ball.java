package com.sshsgd.pong.entities;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector2;

public class Ball extends Entity {

	public Ball(Vector2 position, float width, float height) {
		super(position.x, position.y, width, height);
	}

	public Ball(float x, float y, float width, float height) {
		super(x, y, width, height);
	}

	@Override
	public void draw(ShapeRenderer sr, SpriteBatch sb) {

		sr.rect(getX(), getY(), getWidth(), getHeight());
		
	}

}
