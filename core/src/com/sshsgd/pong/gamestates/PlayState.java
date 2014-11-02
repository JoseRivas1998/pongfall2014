package com.sshsgd.pong.gamestates;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.math.Vector2;
import com.sshsgd.pong.Game;
import com.sshsgd.pong.MyCamera;
import com.sshsgd.pong.entities.Ball;
import com.sshsgd.pong.managers.GameStateManager;

public class PlayState extends GameState {

	private Ball b;
	private MyCamera cam;
	
	public PlayState(GameStateManager gsm) {
		super(gsm);
	}

	@Override
	public void init() {
		b = new Ball(Game.CENTER, 25, 25);
		cam = new MyCamera(Game.SIZE);
		cam.translate(Game.CENTER);
		cam.update();
	}

	@Override
	public void update(float dt) {
		b.update();
	}

	@Override
	public void draw(SpriteBatch sb, ShapeRenderer sr) {
		
		sr.begin(ShapeType.Filled);
		sr.setProjectionMatrix(cam.combined);
		sr.setColor(Color.WHITE);
		b.draw(sr, sb);
		sr.end();

	}

	@Override
	public void handleInput() {
 	}

	@Override
	public void reszie(Vector2 size) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub

	}

}
