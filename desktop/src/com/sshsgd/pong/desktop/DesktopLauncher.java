package com.sshsgd.pong.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.sshsgd.pong.Game;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.width = (int) java.awt.Toolkit.getDefaultToolkit().getScreenSize().getWidth();
		config.height = (int) java.awt.Toolkit.getDefaultToolkit().getScreenSize().getHeight();
		config.fullscreen = true;
		new LwjglApplication(new Game(), config);
	}
}
