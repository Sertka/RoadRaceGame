package ru.stk;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;

public class RoadRace extends ApplicationAdapter {
	SpriteBatch batch;
	Texture img;
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		img = new Texture("pixel5.png");
	}

	@Override
	public void render () {
		ScreenUtils.clear(1, 0.45f, 0, 1);
	//	Gdx.graphics.getHeight() размер экрана
		batch.begin();
		batch.draw(img, 0, 0);
		batch.end();
	}


	@Override
	public void dispose () {
		batch.dispose();
		img.dispose();
	}
}
