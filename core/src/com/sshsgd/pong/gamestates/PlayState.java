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
	private int leftScore, rightScore;
	private Paddle player, opponent;
	
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
		opponent = new AI(25, 100, Paddle.RIGHT, b);
	}

	@Override
	public void update(float dt) {
		b.update();
		player.update();
		opponent.update();
		b.collisions(player);
		b.collisions(opponent);
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
		opponent.draw(sr, sb);
		sr.end();

		sb.begin();
		drawScore(sb);
		sb.end();
	}
	
	private void drawScore(SpriteBatch sb) {
		String right, left;
		left = "" + leftScore;
		right = "" + rightScore;
		float lX, lY, lW, lH, rX, rY, rW, rH;
		lW = Game.res.getFont("main").getBounds(left).width;
		lH = Game.res.getFont("main").getBounds(left).height - Game.res.getFont("main").getDescent();
		rW = Game.res.getFont("main").getBounds(right).width;
		rH = Game.res.getFont("main").getBounds(right).height - Game.res.getFont("main").getDescent();
		lX = (Game.SIZE.x * .25f) - (lW * .5f);
		lY = (Game.SIZE.y * .75f) + (lH * .5f);
		rX = (Game.SIZE.x * .75f) - (rW * .5f);
		rY = (Game.SIZE.y * .75f) + (rH * .5f);
		Game.res.getFont("main").draw(sb, left, lX, lY);
		Game.res.getFont("main").draw(sb, right, rX, rY);
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
