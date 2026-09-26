
package becasYetapas;

public class Scholarship {

    private final int start;
    private final int end;
    private final int benefit;    

    public Scholarship(int start, int end, int benefit) {
        this.start = start;
        this.end = end;
        this.benefit = benefit;
    }
    
    public int getTotalBenefit() {
        int totalBenefit = 0;
        
        for (int i = start; i <= end; i++) {
            totalBenefit += benefit;
        }
        
        return totalBenefit;
    }

    public int getStart() {
        return start;
    }

    public int getEnd() {
        return end;
    }   

    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Scholarship other = (Scholarship) obj;
        if (this.start != other.start) {
            return false;
        }
        if (this.end != other.end) {
            return false;
        }
        return this.benefit == other.benefit;
    }       

    @Override
    public String toString() {
        return "start = " + start + ", end = " + end + ", benefit = " + benefit + ", total = " + getTotalBenefit() + "\n";
    }            
}
