package org.advent.code.day.five;

public class Seed {
    private double seedId;
    private double soilId;
    private double fertilizerId;
    private double waterId;
    private double lightId;
    private double temperatureId;
    private double humidityId;
    private double locationId;

    public Seed(Double seedId) {
        this.seedId = seedId;
    }

    public double getSeedId() {
        return seedId;
    }

    public double getSoilId() {
        return soilId;
    }

    public void setSoilId(double soilId) {
        this.soilId = soilId;
    }

    public double getFertilizerId() {
        return fertilizerId;
    }

    public void setFertilizerId(double fertilizerId) {
        this.fertilizerId = fertilizerId;
    }

    public double getWaterId() {
        return waterId;
    }

    public void setWaterId(double waterId) {
        this.waterId = waterId;
    }

    public double getLightId() {
        return lightId;
    }

    public void setLightId(double lightId) {
        this.lightId = lightId;
    }

    public double getTemperatureId() {
        return temperatureId;
    }

    public void setTemperatureId(double temperatureId) {
        this.temperatureId = temperatureId;
    }

    public double getHumidityId() {
        return humidityId;
    }

    public void setHumidityId(double humidityId) {
        this.humidityId = humidityId;
    }

    public double getLocationId() {
        return locationId;
    }

    public void setLocationId(double locationId) {
        this.locationId = locationId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Seed seed = (Seed) o;

        if (Double.compare(seedId, seed.seedId) != 0) return false;
        if (Double.compare(soilId, seed.soilId) != 0) return false;
        if (Double.compare(fertilizerId, seed.fertilizerId) != 0) return false;
        if (Double.compare(waterId, seed.waterId) != 0) return false;
        if (Double.compare(lightId, seed.lightId) != 0) return false;
        if (Double.compare(temperatureId, seed.temperatureId) != 0) return false;
        if (Double.compare(humidityId, seed.humidityId) != 0) return false;
        return Double.compare(locationId, seed.locationId) == 0;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        temp = Double.doubleToLongBits(seedId);
        result = (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(soilId);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(fertilizerId);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(waterId);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(lightId);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(temperatureId);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(humidityId);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(locationId);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Override
    public String toString() {
        return "Seed{" +
                "seedId=" + seedId +
                '}';
    }
}
