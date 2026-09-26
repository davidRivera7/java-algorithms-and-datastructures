
package backpack;

public class Element {    
     private int benefit;
     private int weight;

    public Element(int benefit, int weight) {
        this.benefit = benefit;
        this.weight = weight;
    }

    public int getBenefit() {
        return benefit;
    }

    public int getWeight() {
        return weight;
    }

    @Override
    public String toString() {
        return "benefit = " + benefit + ", weight = " + weight;
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
        final Element other = (Element) obj;
        if (this.benefit != other.benefit) {
            return false;
        }
        return this.weight == other.weight;
    }            

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 59 * hash + this.benefit;
        hash = 59 * hash + this.weight;
        return hash;
    }
                         
}
