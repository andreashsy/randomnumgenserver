package rngserver.first.model;

import java.io.Serializable;
// model in MVC
public class Generate implements Serializable {
    private Integer numberVal;

    public void setNumberVal(Integer numberVal) {
        this.numberVal = numberVal;
    }

    public Integer getNumberVal() {
        return this.numberVal;
    }
    
}
