package ru.stk.screen.impl;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;

import ru.stk.screen.BaseScreen;

public class MenuScreen extends BaseScreen {

    private Texture img;
    private Vector2 touch;
    private Vector2 pic;
    private Vector2 inc;
    final Integer STEPS = 100;
    final float FLOAT_DIFF = 0.5f;

    @Override
    public void show() {
        super.show();
        img = new Texture("badlogic.jpg");
        touch = new Vector2();
        pic = new Vector2(1, 1);
        inc = new Vector2(0, 0);
    }

    @Override
    public void render(float delta) {
        super.render(delta);
        batch.begin();
        batch.draw(img, pic.x, pic.y);
        batch.end();
        if (Math.abs(pic.x - touch.x) > 1 || Math.abs(pic.y - touch.y) > 1){
            pic.add(inc);
        }
    }

    @Override
    public void dispose() {
        super.dispose();
        img.dispose();
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        touch.set(screenX, Gdx.graphics.getHeight() - screenY);
        inc.set((touch.x - pic.x)/STEPS, (touch.y - pic.y)/STEPS);
        return super.touchDown(screenX, screenY, pointer, button);
    }
}
