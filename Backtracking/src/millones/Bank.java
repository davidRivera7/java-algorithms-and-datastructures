
package millones;

public class Bank {
    private int investment;
    private int id;
    private int[] benefit;

    public Bank(int id, int[] benefit) {        
        this.id = id;
        this.benefit = benefit;
    }

    public Bank() {
    }       

    public void setInvestment(int investment) {
        this.investment = investment;
    }   
    
    public int getInvestment() {
        return investment;
    }

    public int[] getBenefit() {
        return benefit;
    }

    public void setBenefit(int[] benefit) {
        this.benefit = benefit;
    }    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
           
    public int getCurrentBenefit() {
        return benefit[investment - 1];
    }           

    @Override
    public String toString() {
        return "Bank " + id + " -> investment = " + investment + ", benefit = " + benefit[investment - 1];
    }              
}
