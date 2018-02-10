package Data;

import com.fasterxml.jackson.annotation.JsonSetter;

/**
 * Created by Anton on 10.02.2018.
 */

public class Snow {


        private Double h;

        public Double getH() {
            return h;
        }

        @JsonSetter("3h")
        public void setH(Double h) {
            this.h = h;
        }

}
