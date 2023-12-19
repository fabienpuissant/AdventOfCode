package org.advent.code.day.two;

import java.util.List;
import java.util.Objects;

public class GameItem {

    private Integer id;
    private List<Integer> redCubes;
    private List<Integer> greenCubes;
    private List<Integer> blueCubes;

    public GameItem(Integer id, List<Integer> redCubes, List<Integer> greenCubes, List<Integer> blueCubes) {
        this.id = id;
        this.redCubes = redCubes;
        this.greenCubes = greenCubes;
        this.blueCubes = blueCubes;
    }

    public GameItem() { }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<Integer> getRedCubes() {
        return redCubes;
    }

    public void setRedCubes(List<Integer> redCubes) {
        this.redCubes = redCubes;
    }

    public List<Integer> getGreenCubes() {
        return greenCubes;
    }

    public void setGreenCubes(List<Integer> greenCubes) {
        this.greenCubes = greenCubes;
    }

    public List<Integer> getBlueCubes() {
        return blueCubes;
    }

    public void setBlueCubes(List<Integer> blueCubes) {
        this.blueCubes = blueCubes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        GameItem gameItem = (GameItem) o;

        if (!Objects.equals(id, gameItem.id)) return false;
        if (!Objects.equals(redCubes, gameItem.redCubes)) return false;
        if (!Objects.equals(greenCubes, gameItem.greenCubes)) return false;
        return Objects.equals(blueCubes, gameItem.blueCubes);
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (redCubes != null ? redCubes.hashCode() : 0);
        result = 31 * result + (greenCubes != null ? greenCubes.hashCode() : 0);
        result = 31 * result + (blueCubes != null ? blueCubes.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "GameItem{" +
                "id=" + id +
                ", redCubes=" + redCubes +
                ", greenCubes=" + greenCubes +
                ", blueCubes=" + blueCubes +
                '}';
    }
}
