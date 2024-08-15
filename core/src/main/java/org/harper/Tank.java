package org.harper;

import com.badlogic.gdx.math.Rectangle;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor

public class Tank extends Rectangle {
    private String name;
    private Position position;
    private int angle;

    public Shell fire() {
        return Shell.builder().build();
    }
}
