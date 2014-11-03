package com.sshsgd.pong;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.math.Vector2;
import com.sshsgd.pong.managers.Content;
import com.sshsgd.pong.managers.GameStateManager;
import com.sshsgd.pong.managers.MyInput;
import com.sshsgd.pong.managers.MyInputProcessor;

public class Game extends ApplicationAdapter {
	
	private GameStateManager gsm;
	
	public static Vector2 SIZE, CENTER;
	
	public static Content res;
	
	@Override
	public void create () {
		
		int width, height;
		width = Gdx.graphics.getWidth();
		height = Gdx.graphics.getHeight();
		
		SIZE = new Vector2(width, height);
		CENTER = new Vector2(width * .5f, height * .5f);
		
		res = new Content();
		res.loadSound("sound", "ping_pong_8bit_beeep.ogg", "beep");
		res.loadSound("sound", "ping_pong_8bit_peeeeeep.ogg", "peep");
		res.loadSound("sound", "ping_pong_8bit_plop.ogg", "plop");
		res.loadBitmapFont("font", "prstartk.ttf", "main", 26, Color.WHITE);
		
		gsm = new GameStateManager();
		
		Gdx.input.setInputProcessor(new MyInputProcessor());
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		gsm.handleInput();
		gsm.update(Gdx.graphics.getDeltaTime());
		gsm.draw();
		
		MyInput.update();
	}

	@Override
	public void resize(int width, int height) {
		Game.SIZE.set(width, height);
		Game.CENTER.set(width * .5f, height * .5f);
		gsm.resize(Game.SIZE);
	}

	@Override
	public void dispose() {
		gsm.dispose();
	}
	
}
