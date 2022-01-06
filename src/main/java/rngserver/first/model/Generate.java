package rngserver.first.model;

import java.io.Serializable;
// form
public class Generate implements Serializable {
    private int numberVal;
    public void setNumberVal(int numberVal) {
        this.numberVal = numberVal;
    }

    public int getNumberVal() {
        return this.numberVal;
    }
    
}
