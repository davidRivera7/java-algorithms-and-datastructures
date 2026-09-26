/*
Dice un valor y 3 dados, queremos sacar todas las combinaciones que superen 
a ese valor dado.
*/
package backtrackingdados;

public class Dice {
    
    private int id;
    private boolean busy;
    private int value;

    public Dice(int id) {
        busy = false;
        this.id = id;
    }        

    public boolean isBusy() {
        return busy;
    }

    public void setBusy(boolean busy) {
        this.busy = busy;
    }                        

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
    
    public int getSumDices(int[] combinations) {
        int sum = 0;
        for (int i : combinations) {
            sum += i;
        }
        return sum;
    }        

    @Override
    public String toString() {
        return "D" + id + ": " + value;
    }              
    
}
