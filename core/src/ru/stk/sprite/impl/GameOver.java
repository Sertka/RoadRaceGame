package ru.stk.sprite.impl;

import com.badlogic.gdx.graphics.g2d.TextureAtlas;

import ru.stk.math.Rect;
import ru.stk.sprite.Sprite;

public class GameOver extends Sprite {

    private static final float HEIGHT = 0.08f;

    public GameOver(TextureAtlas atlas) {
        super(atlas.findRegion("message_game_over"));
    }

    @Override
    public void resize(Rect worldBounds) {
        setHeightProportion(HEIGHT);
    }
}
