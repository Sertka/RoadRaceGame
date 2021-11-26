package ru.stk;

import com.badlogic.gdx.Game;
import ru.stk.screen.impl.MenuScreen;

public class RoadRace extends Game {

	@Override
	public void create() {
		setScreen(new MenuScreen(this));
	}

}
