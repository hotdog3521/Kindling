package model.kindling;

import java.io.Serializable;

public class Range implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private final int start, finish;

    public Range(int _start, int _finish){
        this.start = _start;
        this.finish = _finish;
    }

    public int getStart(){
        return start;
    }

    public int getFinish(){
        return finish;
    }
    
    public boolean inRange(int n) {
    	return (n >= start) && (n <= finish);
    }
}
