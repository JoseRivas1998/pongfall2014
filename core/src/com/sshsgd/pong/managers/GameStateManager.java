package com.sshsgd.pong.managers;

import com.sshsgd.pong.gamestates.*;

public class GameStateManager {

	GameState state;
	
	public static final int TITLE = 0;
	public static final int PLAY = 1;
	
	public GameStateManager() {
		setState(PLAY);
	}
	
	public void setState(int newState) {
		if(state != null) state.dispose();
		if(newState == TITLE) {
			
		} 
		if(newState == PLAY) {
			
		}
	}

}
