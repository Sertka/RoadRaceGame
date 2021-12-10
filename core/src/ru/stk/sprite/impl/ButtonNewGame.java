package ru.stk.sprite.impl;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;

import ru.stk.math.Rect;
import ru.stk.screen.impl.GameScreen;
import ru.stk.sprite.BaseButton;

public class ButtonNewGame extends BaseButton {

    private static final float HEIGHT = 0.05f;
    private static final float MARGIN = 0.03f;
    private final GameScreen gameScreen;

    public ButtonNewGame(TextureAtlas atlas, GameScreen gameScreen) {
        super(atlas.findRegion("button_new_game"));
        this.gameScreen = gameScreen;
    }

    @Override
    public void resize(Rect worldBounds) {
        super.resize(worldBounds);
        setHeightProportion(HEIGHT);
        setBottom(worldBounds.getBottom() + MARGIN);
    }

    @Override
    public void action() {
        gameScreen.newGame();
    }
}
