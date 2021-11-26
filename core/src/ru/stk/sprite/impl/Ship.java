package ru.stk.sprite.impl;

import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

import ru.stk.math.Rect;
import ru.stk.sprite.Sprite;

public class Ship extends Sprite {

    protected Rect worldBounds;
    private static final float HEIGHT = 0.1f;
    private static final float B_MARGIN = 0.05f;
    protected Vector2 v;
    protected Vector2 vRight;
    protected Vector2 vLeft;
    protected Vector2 vStop;

    public Ship(TextureAtlas atlas) {
        super(atlas.findRegion("main_ship_color"));
        this.v = new Vector2(0, 0);
        this.vRight = new Vector2(0.3f, 0);
        this.vLeft = new Vector2(-0.3f, 0);
        this.vStop = new Vector2(0f, 0f);
    }

    @Override
    public void resize(Rect worldBounds) {
        super.resize(worldBounds);
        this.worldBounds = worldBounds;
        setHeightProportion(HEIGHT);
        setBottom(worldBounds.getBottom() + B_MARGIN);

    }

    @Override
    public void update(float delta) {
        super.update(delta);
        pos.mulAdd(v, delta);
    }

    public boolean keyDown(int keycode) {
        switch (keycode) {
            case Input.Keys.LEFT:
                v.set(vLeft);
                break;
            case Input.Keys.RIGHT:
                v.set(vRight);
                break;
        }
        return false;
    }

    public boolean keyUp(int keycode) {
        v.set(vStop);
        return false;
    }

}