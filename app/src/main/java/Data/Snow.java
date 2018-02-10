package Data;

import com.fasterxml.jackson.annotation.JsonSetter;

/**
 * Created by Anton on 09.02.2018.
 */

class Snow {

    private Double h;

    public Double getH() {
        return h;
    }

    @JsonSetter("3h")
    public void setH(Double h) {
        this.h = h;
    }
}
