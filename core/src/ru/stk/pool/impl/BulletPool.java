package ru.stk.pool.impl;

import ru.stk.pool.SpritesPool;
import ru.stk.sprite.impl.Bullet;

public class BulletPool extends SpritesPool<Bullet> {
    @Override
    protected Bullet newObject() {
        return new Bullet();
    }
}
