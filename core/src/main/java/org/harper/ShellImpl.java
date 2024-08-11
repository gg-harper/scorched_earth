package org.harper;

import com.badlogic.gdx.math.Vector2;

public class ShellImpl extends Shell {


    public ShellImpl() {
        position = new Vector2(0, 0);
        alive = false;
    }

    public void init() {
        position.set(0, 0);
        velocity.set(0, 0);
        acceleration.set(0, 0);
        alive = true;
    }

    @Override
    public void shoot() {
        position.add(velocity);
    }

    @Override
    public void reset() {
        position.set(0, 0);
        alive = false;
    }
}
