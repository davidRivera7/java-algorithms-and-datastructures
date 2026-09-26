//solucion correcta y bonita
package millones;

public class Main {
    public static void main(String[] args) {                
//        Bank[] banks = {
//            new Bank(1, new int[]{3, 5, 6, 7}),
//            new Bank(2, new int[]{1, 2, 5, 9}),
//            new Bank(3, new int[]{1, 3, 4, 8})
//        };
        
        Bank[] banks = {
            new Bank(1, new int[]{2, 5, 6, 7}),            
            new Bank(2, new int[]{1, 3, 6, 7}),
            new Bank(3, new int[]{1, 2, 5, 8})
        };
        
        Bank[] best = new Bank[banks.length];
        bestInvestment(banks, 0, 4, new Bank[banks.length], best);
        
        for (Bank b : best) {
            System.out.println(b);
        }
        System.out.println("Rentabilidad sumada: " + revenue(best));
    }
    
    /**
     * 
     * @param banks bancos existentes
     * @param stage la cantidad de veces que se ha invertido: 0 = no hay inversiones,
     * 1 = un banco invertido, 2 = llevamos dos bancos y en la siguiente inversion tenemos 
     * que terminar de invertir todo. (no me puedo quedar con millones sin invertir)
     * @param millions cantidad de millones que tenemos
     * @param inverted bancos en los que estare invirtiendo
     * @param best la mejor inversion
     */
    public static void bestInvestment(Bank[] banks, int stage, int millions, 
            Bank[] inverted, Bank[] best) {
        
        if (millions == 0) {
            
            if (revenue(inverted) > revenue(best)) {
                
                for (int i = 0; i < inverted.length; i++) {
                    
                    if (inverted[i] != null) {
                        best[i] = new Bank(); //hago una copia del objeto ya que el objeto se toca constantemente
                        best[i].setId(inverted[i].getId());
                        best[i].setInvestment(inverted[i].getInvestment());
                        best[i].setBenefit(inverted[i].getBenefit());//no se toca el arreglo, si se tocara, entonces haria una copia aparte tambien de este arreglo. Y si el areglo fuera de objetos y esos objetos se tocaran, tambien se tendria que hacer otra copia de ese objeto, miembro por miembro
                    } else {
                        best[i] = null;
                    }
                    
                }                                                
            }
            
        } else {
            
            for (int b = 0; b < banks.length; b++) {//recorremos los bancos
                                                
                for (int m = 1; m <= millions; m++) {//invertimos

                    //consideraciones:
                    if (!existBank(inverted, banks[b])) {
                        
                        inverted[b] = banks[b]; //agregamos banco
                        
                        if (millions - m > 0 && stage == 2) {  //terminamos de invertir todo lo que nos sobra                            
                            inverted[b].setInvestment(millions);
                            bestInvestment(banks, stage + 1, millions - millions, inverted, best);
                            
                        } else if (millions - m < 0) { //no tenemos millones
                            inverted[b] = null;
                            break;
                            
                        } else {                            
                            inverted[b].setInvestment(m); //invertimos 'm' millones
                            bestInvestment(banks, stage + 1, millions - m, inverted, best);
                        }                        
                        inverted[b] = null;
                        
                    } else {
                        break; //pasamos al siguiente banco
                    }

                }
                                
            }
            
        }       
    }
    
    public static boolean existBank(Bank[] banks, Bank b) {
        
        for (Bank i : banks) {
            if (i == b) 
                return true;
        }
        
        return false;        
    }
    
    public static int revenue(Bank[] banks) {        
        int sum = 0;                
        for (Bank b : banks) {
            if (b != null) 
                sum += b.getCurrentBenefit();            
        }        
        return sum;
    }
        
}
