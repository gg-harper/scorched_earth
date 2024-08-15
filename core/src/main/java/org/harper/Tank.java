package org.harper;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Tank {
    private String name;
    private Position position;
    private int angle;

    public Shell fire() {
        return Shell.builder().build();
    }
}
