package gamestates;

import java.awt.event.MouseEvent;

import audio.AudioPlayer;
import main.Game;
import ui.ChoiceButton;
import ui.MenuButton;

public class State {
	
	protected Game game;
	
	public State(Game game) {
		
		this.game = game;
		
	}
	
	public boolean isIn(MouseEvent e, MenuButton mb) {
		return mb.getBounds().contains(e.getX(), e.getY());
		
	}
	
	public boolean isIn(MouseEvent e, ChoiceButton cb) {
		return cb.getBounds().contains(e.getX(), e.getY());
		
	}
	
	public Game getGame() {
		return game;
	}
	
	@SuppressWarnings("incomplete-switch")
	public void setGameState(Gamestate state) {
		switch(state) {
		case MENU -> game.getAudioPlayer().playSong(AudioPlayer.MENU);
		case PLAYING -> game.getAudioPlayer().setLevelSong(game.getPlaying().getLevelManager().getLevelIndex());	
		}
		Gamestate.state = state;
	}

}