package com.sshsgd.pong.gamestates;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.math.Vector2;
import com.sshsgd.pong.Game;
import com.sshsgd.pong.MyCamera;
import com.sshsgd.pong.entities.*;
import com.sshsgd.pong.managers.GameStateManager;

public class PlayState extends GameState {

	private Ball b;
	private MyCamera cam;
	private float leftScore, rightScore;
	private Paddle player;
	
	public PlayState(GameStateManager gsm) {
		super(gsm);
	}

	@Override
	public void init() {
		b = new Ball(Game.CENTER, 25, 25, Ball.BOUNCE_TOP_BOTTOM);
		cam = new MyCamera(Game.SIZE);
		cam.translate(Game.CENTER);
		cam.update();
		leftScore = 0;
		rightScore = 0;
		player = new Player(25, 100, Paddle.LEFT);
	}

	@Override
	public void update(float dt) {
		b.update();
		player.update();
		b.collisions(player);
		scoreCheck();
	}
	
	private void scoreCheck() {
		if(b.getX() <= -50) {
			rightScore++;
		}
		if(b.getX() >= Game.SIZE.x - b.getWidth() + 50) {
			leftScore++;
		}
	}

	@Override
	public void draw(SpriteBatch sb, ShapeRenderer sr) {
		
		sr.begin(ShapeType.Filled);
		sr.setProjectionMatrix(cam.combined);
		sr.setColor(Color.WHITE);
		b.draw(sr, sb);
		player.draw(sr, sb);
		sr.end();

	}

	@Override
	public void handleInput() {
 	}

	@Override
	public void reszie(Vector2 size) {
		cam.resize(size, true);
		
	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub

	}

}
