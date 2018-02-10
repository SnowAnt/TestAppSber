package Data;

import com.fasterxml.jackson.annotation.JsonSetter;

/**
 * Created by Anton on 03.02.2018.
 */

public class Main {

    private Double temp;
    private Double pressure;
    private Integer humidity;
    private Double tempMin;
    private Double tempMax;
    private Double seaLevel;
    private Double grndLevel;

    public Double getTemp() {
        return temp;
    }

    public Double getPressure() {
        return pressure;
    }

    public Integer getHumidity() {
        return humidity;
    }



    public void setTemp(Double temp) {
        this.temp = temp;
    }

    public void setPressure(Double pressure) {
        this.pressure = pressure;
    }

    public void setHumidity(Integer humidity) {
        this.humidity = humidity;
    }

    public Double getTempMin() {
        return tempMin;
    }

    public Double getTempMax() {
        return tempMax;
    }

    public Double getSeaLevel() {
        return seaLevel;
    }

    public Double getGrndLevel() {
        return grndLevel;
    }
    @JsonSetter("temp_min")
    public void setTempMin(Double tempMin) {
        this.tempMin = tempMin;
    }
    @JsonSetter("temp_max")
    public void setTempMax(Double tempMax) {
        this.tempMax = tempMax;
    }
    @JsonSetter("sea_level")
    public void setSeaLevel(Double seaLevel) {
        this.seaLevel = seaLevel;
    }
    @JsonSetter("grnd_level")
    public void setGrndLevel(Double grndLevel) {
        this.grndLevel = grndLevel;
    }

}
