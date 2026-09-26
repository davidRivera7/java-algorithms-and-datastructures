
package backtrackingdados;

public class Main {
    
    public static void main(String[] args) {                
        diceCombinations(0, new int[3], 0, 6);
    }               
    
    /**
     * Los dados no tienen identificadores
     * @param iterator para recorrer la combinacion (cada dado)
     * @param combination simula guardando los dados y el valor del tiro
     * @param sum para saber cuanto suman mis tiros
     * @param value valor a formar la combinacion
     */
    public static void diceCombinations(int iterator, int[] combination, int sum, int value) {

        if (iterator > combination.length - 1) {
            
            if (sum == value) {
                for (int i : combination) {
                    System.out.print(i + " ");
                }
                System.out.println("");
            }                                        

        } else {

            for (int shot = 1; shot <= 6; shot++) {//tiros                                                                         
                combination[iterator] = shot;
                sum += shot;
                diceCombinations(iterator + 1, combination, sum, value);  
                sum -= shot;
            }

        }
    }
    
    /**
     * //muestra el dado y el valor que lanzo pero es como si nos importara 
     * si primero se lanza el dado 1 o el dado n
     * @param dices arreglo que guarda todos mis dados id 1, id 2, id3
     * @param value valor que tendran que sumar mis n dados para obtenerlo 
     * @param combination guarda las diferentes combinaciones (dados) en poder obtener el valor
     */
    public static void diceCombinationsV2(Dice[] dices, int value, Combination combination) {
        
        if (combination.busyDice(dices) && combination.getSumDices(combination.getDices()) == value) {                        
            
            System.out.println(combination);
            
        } else {
            for (int currentDice = 0; currentDice < dices.length; currentDice++) {
                
                if (!dices[currentDice].isBusy()) {     
                    
                    for (int shot = 1; shot <= 6; shot++) {//tiros                         
                        dices[currentDice].setValue(shot);
                        dices[currentDice].setBusy(true);      
                        combination.addDice(dices[currentDice]);
                        
                        diceCombinationsV2(dices, value, combination);                        
                        
                        dices[currentDice].setBusy(false);
                        dices[currentDice].setValue(0);
                        combination.removeDice(dices[currentDice]);
                    }
                }
            }
        }        
    }
            
}
