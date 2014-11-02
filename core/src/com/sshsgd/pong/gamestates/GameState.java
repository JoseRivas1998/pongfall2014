package com.sshsgd.pong.gamestates;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.sshsgd.pong.managers.GameStateManager;

public abstract class GameState {

	protected GameStateManager gsm;
	
	protected GameState(GameStateManager gsm) {
		this.gsm = gsm;
		init();
	}
	
	public abstract void init();
	public abstract void update(float dt);
	public abstract void draw(SpriteBatch sb, ShapeRenderer sr);
	public abstract void handleInput();
	public abstract void dispose();
}
