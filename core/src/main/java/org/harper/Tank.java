package org.harper;

import com.badlogic.gdx.math.Rectangle;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Map;

@Getter
@AllArgsConstructor
@NoArgsConstructor

public class Tank extends Rectangle {
    private String name;
    private Position position;
    private int angle;
    private Map<String, Integer> shells;

    public boolean load(ShellType shellType) {
        if (shells.get(shellType.name()) > 0) {
            shells.put(shellType.name(), shells.get(shellType.name()) - 1);
            return true;
        }
        return false;
    }
    public void moveLeft() {
       this.x -= 1;
    }
    public void moveRight() {
       this.x += 1;
    }

    public Shell fire() {
        return Shell.builder().build();
    }
}
