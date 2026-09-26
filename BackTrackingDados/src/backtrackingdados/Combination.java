
package backtrackingdados;

public class Combination {
    
    private Dice[] dices;

    public Combination(int n) {
        dices = new Dice[n];
    }
    
    public void addDice(Dice dice) {
        for (int i = 0; i < dices.length; i++) {
            if (dices[i] == null) {
                dices[i] = dice;
                break;
            }
        }
    }
    
    public void removeDice(Dice dice) {
        for (int i = 0; i < dices.length; i++) {
            if (dices[i] == dice) {
                dices[i] = null;
            }
        }
    }        

    public Dice getDiceAt(int n) {
        return dices[n];
    }

    public Dice[] getDices() {
        return dices;
    }    
    
    //retorna si todos los dados se usaron
    public boolean busyDice(Dice[] dices) {
        for (Dice i : dices) {
            if (!i.isBusy()) return false;
        }
        return true;
    }
    
    public int getSumDices(Dice[] dices) {
        int sum = 0;
        for (Dice i : dices) {
            sum += i.getValue();
        }
        return sum;
    }
    
    @Override
    public String toString() {
        String txtDice = "";
        for (int i = 0; i < dices.length; i++) {
            txtDice += dices[i] + " ";
        }
        txtDice += "\n";
        return txtDice;
    }               
    
}
