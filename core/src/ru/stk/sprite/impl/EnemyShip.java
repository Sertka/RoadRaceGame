package ru.stk.sprite.impl;

import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

import ru.stk.math.Rect;
import ru.stk.pool.impl.BulletPool;
import ru.stk.sprite.Ship;

public class EnemyShip extends Ship {
    private final Vector2 appearV = new Vector2(0, -0.8f);
    private Vector2 normalV;
    private boolean appearFlag;

    public EnemyShip(BulletPool bulletPool, Sound bulletSound, Rect worldBounds) {
        this.bulletPool = bulletPool;
        this.bulletSound = bulletSound;
        this.worldBounds = worldBounds;
        this.v = new Vector2();
        this.v0 = new Vector2();
        this.normalV = new Vector2();
        this.appearFlag = false;
    }

    @Override
    public void update(float delta) {
        super.update(delta);

       if ((getTop() < worldBounds.getTop())) {
            this.v.set(normalV);
        } else {
           reloadTimer = reloadInterval - 0.1f;
       }

        if (getBottom() < worldBounds.getBottom()) {
            destroy();
        }
    }

    public void set(
            TextureRegion[] regions,
            Vector2 v,
            TextureRegion bulletRegion,
            float bulletHeight,
            Vector2 bulletV,
            int damage,
            float reloadInterval,
            float height,
            int hp
    ) {
        this.regions = regions;
        this.normalV.set(v);
        this.v.set(appearV);
        this.bulletRegion = bulletRegion;
        this.bulletHeight = bulletHeight;
        this.bulletV = bulletV;
        this.damage = damage;
        this.reloadInterval = reloadInterval;
        setHeightProportion(height);
        this.hp = hp;
    }
}
