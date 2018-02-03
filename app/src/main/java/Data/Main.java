package Data;

/**
 * Created by Anton on 03.02.2018.
 */

public class Main {

    Double temp;
    Double pressure;
    Integer humidity;
    Double tempMin;
    Double tempMax;
    Double seaLevel;
    Double grnd;

    public Double getTemp() {
        return temp;
    }

    public Double getPressure() {
        return pressure;
    }

    public Integer getHumidity() {
        return humidity;
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

    public Double getGrnd() {
        return grnd;
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

    public void setTempMin(Double tempMin) {
        this.tempMin = tempMin;
    }

    public void setTempMax(Double tempMax) {
        this.tempMax = tempMax;
    }

    public void setSeaLevel(Double seaLevel) {
        this.seaLevel = seaLevel;
    }

    public void setGrnd(Double grnd) {
        this.grnd = grnd;
    }
}
