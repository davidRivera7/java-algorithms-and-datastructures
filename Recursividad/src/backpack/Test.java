//NO SE PERMITEN ELEMENTOS REPETIDOS
//aunque sean objetos dif pero si tienen mismos atributos entonces 
//se considera objeto repetido
package backpack;

public class Test {
    public static void main(String[] args) {
        Element[] e = {
            new Element(10, 12),
            new Element(2, 2),
            new Element(2, 1),
            new Element(1, 1),
            new Element(10, 3)            
        };
//        Element[] e = {
//            new Element(10, 1),
//            new Element(2, 1),
//            new Element(2, 2),
//            new Element(1, 2),
//            new Element(10, 2)            
//        };
        
        Backpack base = new Backpack(15, e.length);                                
        Backpack opt = new Backpack(15, e.length);
        
        fillBackpack(base, opt, e, false);
        System.out.println(opt);
        System.out.println("\n" + base);
    }
    
    /**
     * 
     * @param base
     * @param opt
     * @param e
     * @param full controla si ya se lleno por peso
     * base.getExistingItems() == e.length controla si ya tiene todos los elementos aunque no supere el peso.
     */
    public static void fillBackpack(Backpack base, Backpack opt, Element[] e, boolean full) {
        
        if (full || base.getExistingItems() == e.length) { 
            if (base.getBenefit() > opt.getBenefit()) {
                opt.empty();
                opt.changeBackpack(base);
            }
        } else {
            for (int i = 0; i < e.length; i++) {
                if (!base.existElement(e[i])) {

                    if (base.getWeight() + e[i].getWeight() <= base.getMaxWeight()) {
                        base.addElement(e[i]);
                        fillBackpack(base, opt, e, false);
                        base.eliminateElement(e[i]);
                    } else {
                        fillBackpack(base, opt, e, true);
                    }
                }
            }
        }                
    }        
    
}
