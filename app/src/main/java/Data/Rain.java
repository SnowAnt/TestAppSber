package Data;

import com.fasterxml.jackson.annotation.JsonSetter;

/**
 * Created by Anton on 09.02.2018.
 */

class Rain {


    private Double hThree;

    public Double getHThree() {
        return hThree;
    }

    @JsonSetter("3h")
    public void setHThree(Double h) {
        this.hThree = h;
    }
}
