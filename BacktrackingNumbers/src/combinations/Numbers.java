//mostrando combinaciones posibles a obtener un numero, sin repetir casos
//por ejemplo: no se repite 2, 1, 1 con 1, 2, 1
package combinations;

public class Numbers {
    
    public static void main(String[] args) {
        int number = 5; //<- modificar aqui
        int[] numbers = new int[number];
        
        for (int i = 0; i < number; i++) {
            numbers[i] = i + 1;
        }
        
        combination(number, 0, numbers, 0, new int[number]);
        
    }
    
    public static void combination(int number, int sum, 
            int[] numbers, int stage, int[] combination) {
        
        if (stage == numbers.length || sum == number) {
            
            if (sum == number)
                showCombination(combination, numbers);
            
        } else {
            
            for (int i = 0; i <= number; i++) {
                
                sum += numbers[stage] * i;                
                
                if (sum <= number) {                   
                    combination[stage] = i;
                    combination(number, sum, numbers, stage + 1, combination);
                    combination[stage] = 0;
                    sum -= numbers[stage] * i;   
                    
                } else 
                    break;                
                                                             
            }
            
        }
        
    }
    
    public static void showCombination(int[] combination, int[] numbers) {
        
        for (int i = 0; i < numbers.length; i++) {
            
            for (int j = 0; j < combination[i]; j++) {
                System.out.print(numbers[i] + " ");
            }            
        }
        System.out.println("");
    }
    
}
