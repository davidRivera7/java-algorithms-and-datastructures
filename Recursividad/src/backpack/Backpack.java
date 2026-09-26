
package backpack;

public class Backpack {
    private int maxWeight;
    private Element[] elements;
    
    private int weight;
    private int benefit;

    public Backpack(int maxWeight, int nElem) {
        this.maxWeight = maxWeight;
        elements = new Element[nElem];
        weight = 0;
        benefit = 0;
    }

    public int getMaxWeight() {
        return maxWeight;
    }

    public Element[] getElements() {
        return elements;
    }

    public int getWeight() {
        return weight;
    }

    public int getBenefit() {
        return benefit;
    }
    
    public void addElement(Element e) {
        for (int i = 0; i < elements.length; i++) {
            if (elements[i] == null) {
                elements[i] = e;
                weight += e.getWeight();
                benefit += e.getBenefit();
                break;
            }
        }
    }
    
    public boolean existElement(Element e) {
        for (Element i : elements) {
            if (i != null && i.equals(e)) {
                return true;
            }
        }
        return false;
    }
    
    public void eliminateElement(Element e) {
        for (int i = 0; i < elements.length; i++) {
            if (elements[i].equals(e)) {
                elements[i] = null;
                weight -= e.getWeight();
                benefit -= e.getBenefit();
                break;
            }
        }
    }
    
    public void changeBackpack(Backpack change) {
        Element[] elem = change.getElements();
        
        for (int i = 0; i < elem.length; i++) {
            if (elem[i] != null) {
                addElement(elem[i]);
            }
        }
    }
    
    public void empty() {
        weight = 0;
        benefit = 0;
        for (int i = 0; i < elements.length; i++) {
            elements[i] = null;
        }
    }
    
    public int getExistingItems() {
        int n = 0;
        for (int i = 0; i < elements.length; i++) {
            if (elements[i] != null) {
                n++;
            }
        }
        return n;
    }

    @Override
    public String toString() {
        String content = "";
        for (Element i : elements) {
            content += i + "\n";
        }
        content += "weight = " + weight + ", benefit = " + benefit;
        return content;
    }
            
}
