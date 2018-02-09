package Data;

/**
 * Created by Anton on 03.02.2018.
 */

public class Main {

    private Double temp;
    private Double pressure;
    private Integer humidity;
    private Double temp_min;
    private Double temp_max;
    private Double sea_level;
    private Double grnd_level;

    public Double getTemp() {
        return temp;
    }

    public Double getPressure() {
        return pressure;
    }

    public Integer getHumidity() {
        return humidity;
    }

    public Double getTemp_min() {
        return temp_min;
    }

    public Double getTemp_max() {
        return temp_max;
    }

    public Double getSea_level() {
        return sea_level;
    }

    public Double getGrnd_level() {
        return grnd_level;
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

    public void setTemp_min(Double temp_min) {
        this.temp_min = temp_min;
    }

    public void setTemp_max(Double temp_max) {
        this.temp_max = temp_max;
    }

    public void setSea_level(Double sea_level) {
        this.sea_level = sea_level;
    }

    public void setGrnd_level(Double grnd_level) {
        this.grnd_level = grnd_level;
    }
}
