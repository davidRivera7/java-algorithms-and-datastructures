
package becas;

import java.util.ArrayList;

public class Principal {
    
    public static void main(String[] args) {
        Beca[] becas = {
            new Beca(1, 5, 250),            
            new Beca(6, 12, 100),           
            new Beca(5, 8, 350),           
            new Beca(1, 4, 200)                      
        };                
        
        ArrayList<Beca> mejor = new ArrayList<>();                                                     
        mejoresBecas(becas, new ArrayList<>(), mejor, false);
        
        for (Beca b : mejor) 
            System.out.println(b);
        
        System.out.println("Total beneficio = " + getTotalBecas(mejor));
    }
    
    static void mejoresBecas(Beca[] becas, ArrayList<Beca> prueba, ArrayList<Beca> mejor,
            boolean revisar) {        
        
        if (revisar) {
            
            if (getTotalBecas(prueba) > getTotalBecas(mejor)) {               
                mejor.clear();                
                for (Beca b : prueba) 
                    mejor.add(b);                                
            }
            
        } else {
            
            for (int i = 0; i < becas.length; i++) {
                
                if (esBecaPermitida(becas[i], prueba)) {
                    prueba.add(becas[i]);
                    mejoresBecas(becas, prueba, mejor, false);
                    prueba.removeLast();
                } else {
                    mejoresBecas(becas, prueba, mejor, true);
                }
                                    
            }
            
        }                                                       
    }
    
    static int getTotalBecas(ArrayList<Beca> becas) {
        int total = 0;
        
        for (Beca b : becas) 
            total += b.getTotalBeca();
                
        return total;
    }
    
    static boolean esBecaPermitida(Beca becaNueva, ArrayList<Beca> becas) {
        if (becas.isEmpty())
            return true;
        
        return becaNueva.getMesInicio() > becas.getLast().getMesFin();        
    }
    
}
