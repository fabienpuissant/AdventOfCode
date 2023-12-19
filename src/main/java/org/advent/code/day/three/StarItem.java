package org.advent.code.day.three;

import java.util.Objects;

public class StarItem {

    private Integer lineIndex;

    private Integer starIndex;

    public StarItem(Integer lineIndex, Integer starIndex) {
        this.lineIndex = lineIndex;
        this.starIndex = starIndex;
    }

    public Integer getLineIndex() {
        return lineIndex;
    }

    public Integer getStarIndex() {
        return starIndex;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        StarItem starItem = (StarItem) o;

        if (!Objects.equals(lineIndex, starItem.lineIndex)) return false;
        return Objects.equals(starIndex, starItem.starIndex);
    }

    @Override
    public int hashCode() {
        int result = lineIndex != null ? lineIndex.hashCode() : 0;
        result = 31 * result + (starIndex != null ? starIndex.hashCode() : 0);
        return result;
    }
}
