package org.harper;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Pool;

public abstract class Shell implements Pool.Poolable {
    private int caliber;
    private String name; // name of the shell
    private int maxVelocity;
    private int damage;
    private int blastRadius;
    private Vector2 position;
    private Vector2 velocity = new Vector2(0, 0);
    private Vector2 acceleration = new Vector2(0, 0);
    private boolean alive;

    public abstract void shoot();
}
