package com.sshsgd.pong.gamestates;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.math.Vector2;
import com.sshsgd.pong.Game;
import com.sshsgd.pong.MyCamera;
import com.sshsgd.pong.entities.Ball;
import com.sshsgd.pong.managers.GameStateManager;
import com.sshsgd.pong.managers.MyInput;

public class TitleState extends GameState {
	
	MyCamera cam;

	private String s, g, p, e;
	private float sX, sY, sH, sW;
	private float gX, gY, gH, gW;
	private float pX, pY, pH, pW;
	private float eX, eY, eW;
	private Ball b;
	private float time, timer;
	
	public TitleState(GameStateManager gsm) {
		super(gsm);
	}

	@Override
	public void init() {
		cam = new MyCamera(Game.SIZE);
		cam.translate(Game.CENTER);
		cam.update();
		s = "Santa Susana High School";
		g = "Game Dev. Club Presents";
		p = "Pong";
		e = "Press Enter to begin";
		b = new Ball(Game.CENTER, 25, 25, Ball.BOUNCE_ALL_SIDES);
		timer = 30;
	}

	@Override
	public void update(float dt) {
		sW = Game.res.getFont("title").getBounds(s).width;
		sH = Game.res.getFont("title").getBounds(s).height - Game.res.getFont("title").getDescent();
		sX = Game.CENTER.x - (sW * .5f);
		sY = (Game.SIZE.y * .75f) + (sH * .75f);
		
		gW = Game.res.getFont("title").getBounds(g).width;
		gH = Game.res.getFont("title").getBounds(g).height - Game.res.getFont("title").getDescent();
		gX = Game.CENTER.x - (gW * .5f);
		gY = sY - (sH * 3);
		
		pW = Game.res.getFont("title").getBounds(p).width;
		pH = Game.res.getFont("title").getBounds(p).height - Game.res.getFont("title").getDescent();
		pX = Game.CENTER.x - (pW * .5f);
		pY = gY - (gH * 3);
		
		eW = Game.res.getFont("title").getBounds(e).width;
		eX = Game.CENTER.x - (eW * .5f);
		eY = pY - (pH * 3);
		
		b.update();
		time += dt;
		if(time > timer) {
			time = 0;
			b.reset();
		}
	}

	@Override
	public void draw(SpriteBatch sb, ShapeRenderer sr) {
		
		sr.begin(ShapeType.Filled);
		sr.setProjectionMatrix(cam.combined);
		b.draw(sr, sb);
		sr.end();
		
		sb.begin();
		sb.setProjectionMatrix(cam.combined);
		Game.res.getFont("title").draw(sb, s, sX, sY);
		Game.res.getFont("title").draw(sb, g, gX, gY);
		Game.res.getFont("title").draw(sb, p, pX, pY);
		Game.res.getFont("title").draw(sb, e, eX, eY);
		sb.end();
		
	}

	@Override
	public void handleInput() {
		if(MyInput.isPressed(MyInput.ENTER)) {
			gsm.setState(gsm.PLAY);
		}
		if(MyInput.isPressed(MyInput.ESCAPE)) {
			Gdx.app.exit();
		}
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
