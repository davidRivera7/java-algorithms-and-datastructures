//solucion correcta
package becasYetapas;

import java.util.ArrayList;

public class Main {    
    public static void main(String[] args) {        
        Scholarship[] scholarships = {
            new Scholarship(1, 5, 250), 
            new Scholarship(6, 12, 100),
            new Scholarship(5, 8, 350),
            new Scholarship(1, 4, 150)
        };
        
        ArrayList<Scholarship> best = new ArrayList<>();
        
        bestCombination(scholarships, new ArrayList<>(), best);
        
        System.out.println(best);   
        System.out.println("total benefit: " + calculateBenefit(best));      
    }
    
    public static void bestCombination(Scholarship[] scholarships, ArrayList<Scholarship> test,
            ArrayList<Scholarship> best) {

        if (calculateBenefit(test) > calculateBenefit(best)) {
            best.clear();
            for (Scholarship s : test) 
                best.add(s);            
        }

        for (int i = 0; i < scholarships.length; i++) {

            if (addScholarship(test, scholarships[i])) {
                test.add(scholarships[i]);
                bestCombination(scholarships, test, best);
                test.remove(test.size() - 1);
            }
        }
    }
    
    /**
     * 
     * @param schs
     * @param scholarship
     * @return true si ya existe el elemento en los elementos guardados anteriormente, false 
     * caso contrario
     */
     public static boolean exist(ArrayList<Scholarship> schs, Scholarship scholarship) {
        
        for (Scholarship s : schs) {            
            if (s.equals(scholarship)) 
                return true;            
        }
        
        return false;        
    }
         
    /**
     * 
     * @param scholarships
     * @param newSch
     * @return true si se puede anadir una beca nueva, false caso contrario
     */
    public static boolean addScholarship(ArrayList<Scholarship> scholarships, 
            Scholarship newSch) {
        
        if (exist(scholarships, newSch)) 
            return false;                
                    
            int oldEnd = 0;                    
            int newStart = newSch.getStart();                                                   
            
            if (scholarships.size() > 0) 
                oldEnd = scholarships.get(scholarships.size() - 1).getEnd();            
                
            if (oldEnd >= newStart)
                return false;                                                    
                        
            return true;
    }
    
    /**
     * calcula el beneficio total de todas las becas actuales
     * @param schs
     * @return 
     */
    public static int calculateBenefit(ArrayList<Scholarship> schs) {
        int total = 0;
                        
        for (Scholarship s: schs) {
            total += s.getTotalBenefit();
        }
        
        return total;
    }                            
}
