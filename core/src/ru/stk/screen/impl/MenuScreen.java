package ru.stk.screen.impl;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;

import ru.stk.math.Rect;
import ru.stk.screen.BaseScreen;
import ru.stk.sprite.impl.Background;
import ru.stk.sprite.impl.Logic;

public class MenuScreen extends BaseScreen {

    private Texture img;
    private Texture bg;
    private Vector2 pos;
    private Vector2 touch;
    private Vector2 v;
    private Vector2 tmp;

    private Background background;
    private Logic logic;
    private Rect log;

    private final float  V_LEN = 0.01f;

    @Override
    public void show() {
        super.show();
        img = new Texture("badlogic.jpg");
        bg = new Texture("textures/bg.png");
        pos = new Vector2();
        v = new Vector2();
        tmp = new Vector2();
        touch = new Vector2();

        background = new Background(bg);
        logic = new Logic(img);
        log = new Rect(0, 0, 0.1f, 0.1f);
    }

    @Override
    public void resize(Rect worldBounds) {
        super.resize(worldBounds);
        background.resize(worldBounds);
        logic.resize(log);
    }

    @Override
    public void render(float delta) {
        super.render(delta);
        batch.begin();
        background.draw(batch);
        logic.move(pos);
        logic.draw(batch);
        batch.end();

        tmp.set(touch);
        if (tmp.sub(pos).len() > V_LEN){
            pos.add(v);
        }else{
            pos.set(touch);
        }
    }

    @Override
    public void dispose() {
        super.dispose();
        img.dispose();
        bg.dispose();
    }

    @Override
    public boolean touchDown(Vector2 t, int pointer, int button) {
        touch.set(t);
        v.set(t.sub(pos).setLength(V_LEN));
        //System.out.println("touchDown touchX = " + pos.x + " touchY = " + pos.y);
        return super.touchDown(touch, pointer, button);

    }
}
