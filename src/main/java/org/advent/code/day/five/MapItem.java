package org.advent.code.day.five;

public class MapItem {

    private final double destinationRangeStart;
    private final double sourceRangeStart;
    private final double rangeLength;

    public MapItem(double destinationRangeStart, double sourceRangeStart, double rangeLength) {
        this.destinationRangeStart = destinationRangeStart;
        this.sourceRangeStart = sourceRangeStart;
        this.rangeLength = rangeLength;
    }

    public double getDestinationRangeStart() {
        return destinationRangeStart;
    }

    public double getSourceRangeStart() {
        return sourceRangeStart;
    }

    public double getRangeLength() {
        return rangeLength;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MapItem mapItem = (MapItem) o;

        if (Double.compare(destinationRangeStart, mapItem.destinationRangeStart) != 0) return false;
        if (Double.compare(sourceRangeStart, mapItem.sourceRangeStart) != 0) return false;
        return Double.compare(rangeLength, mapItem.rangeLength) == 0;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        temp = Double.doubleToLongBits(destinationRangeStart);
        result = (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(sourceRangeStart);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(rangeLength);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }
}
