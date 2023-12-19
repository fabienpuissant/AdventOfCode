package org.advent.code.day.three;

import java.util.Objects;

public class LineWithValue {

    private Integer lineIndex;

    private Integer value;

    public LineWithValue(Integer lineIndex, Integer value) {
        this.lineIndex = lineIndex;
        this.value = value;
    }

    public Integer getLineIndex() {
        return lineIndex;
    }

    public Integer getValue() {
        return value;
    }


    @Override
    public String toString() {
        return "LineWithValue{" +
                "lineIndex=" + lineIndex +
                ", value=" + value +
                '}';
    }
}
