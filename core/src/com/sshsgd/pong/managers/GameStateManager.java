package com.sshsgd.pong.managers;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector2;
import com.sshsgd.pong.gamestates.*;

public class GameStateManager {

	SpriteBatch sb;
	ShapeRenderer sr;
	
	GameState state;
	
	public static final int TITLE = 0;
	public static final int PLAY = 1;
	
	public GameStateManager() {
		sb = new SpriteBatch();
		sr = new ShapeRenderer();
		setState(PLAY);
	}
	
	public void setState(int newState) {
		if(state != null) state.dispose();
		if(newState == TITLE) {
			
		} 
		if(newState == PLAY) {
			state = new PlayState(this);
		}
	}
	
	public void update(float dt) {
		state.update(dt);
	}
	
	public void draw() {
		state.draw(sb, sr);
	}
	
	public void handleInput() {
		state.handleInput();
	}
	
	public void resize(Vector2 size) {
		state.reszie(size);
	}
	
	public void dispose() {
		state.dispose();
		sb.dispose();
		sr.dispose();
	}

}
