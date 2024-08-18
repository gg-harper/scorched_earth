package org.harper;

import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Pool;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class Shell extends Rectangle implements Pool.Poolable {

    private static final Vector2 ACCELERATION = new Vector2(0, -10);

    private int caliber;
    private String name; // name of the shell
    private int maxVelocity;
    private int damage;
    private int blastRadius;
    private Vector2 velocity;
    private boolean alive;

    private Tank tank;

    Shell(int x, int y, int caliber, String name, int maxVelocity, int damage, int blastRadius) {
        this.caliber = caliber;
        this.name = name;
        this.maxVelocity = maxVelocity;
        this.damage = damage;
        this.alive = false;
        this.velocity = new Vector2(0, 0);
        this.blastRadius = blastRadius;
        this.x = x;
        this.y = y;
    }

    public boolean fire() {
        alive = true;
        velocity.setAngleDeg(45 ); //= maxVelocity tank.getAngle();
        return true;
    }

    public void update(Vector2 acceleration) {
        x += velocity.x;
        y += velocity.y;
        velocity.add(acceleration);
        checkPosition();
    }

    private void checkPosition() {
        if (velocity.x <= 0 || this.y <= 0) {
            alive = false;
        }
    }

    @Override
    public void reset() {
        alive = false;
        velocity.set(0, 0);
        this.x = tank.getX();
        this.y = tank.getY();
    }
}
