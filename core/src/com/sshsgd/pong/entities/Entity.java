package com.sshsgd.pong.entities;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public abstract class Entity {

	protected Rectangle bounds;
	
	public Entity(float x, float y, float width, float height) {
		bounds = new Rectangle(x, y, width, height);
	}
	
	public abstract void draw(ShapeRenderer sr, SpriteBatch sb);
	
	public boolean collidingWith(Entity e) {
		return this.getBounds().overlaps(e.getBounds());
	}

	public Rectangle getBounds() {
		return bounds;
	}

	public void setBounds(Rectangle bounds) {
		this.bounds = bounds;
	}

	public float getX() {
		return bounds.x;
	}
	
	public void setX(float x) {
		bounds.x = x;
	}
	
	public float getY() {
		return bounds.y;
	}
	
	public void setY(float y) {
		bounds.x = y;
	}
	
	public float getWidth() {
		return bounds.width;
	}
	
	public void setWidth(float width) {
		bounds.width = width;
	}
	
	public float getHeight() {
		return bounds.height;
	}
	
	public void setHeight(float height) {
		bounds.height = height;
	}
	
	public Vector2 getPosition() {
		return new Vector2(getX(), getY());
	}
	
	public void setPosition(Vector2 point) {
		setX(point.x);
		setY(point.y);
	}
	
	public Vector2 getDimension() {
		return new Vector2(getWidth(), getHeight());
	}
	
	public void setDimension(Vector2 dim) {
		setWidth(dim.x);
		setHeight(dim.y);
	}
	
}