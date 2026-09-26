//esta mal, pasa 160 de 180 tests
package array06;

public class MaximumProductSubarray {
    
    public static int maxProduct(int[] nums) {        
        
        int i = 0;
        int longerProduct = nums[i];
        int product = 1;                
        
        while (i < nums.length) {//recorremos arreglo                                                
            
            if (product * nums[i] > longerProduct) //obtenemos el mayor
                longerProduct = product * nums[i];
            
            if (product * nums[i] < 0) { //verificar si mas adelante hay otro numero negativo
                
                int testProduct = product * nums[i];//considero el producto con el num negativo de esa posicion sin tocar 'product'
                boolean twoNegatives = false;                
                int iNegative = i + 1;
                
                while (iNegative < nums.length && !twoNegatives) {
                    
                    testProduct *= nums[iNegative];                        
                    
                    if (nums[iNegative] == 0) {
                        i = iNegative;//reestablecemos product y saltamos cero.
                        break;
                    }
                                            
                    if (nums[iNegative] < 0) {
                        twoNegatives = true;  
                        break;
                    }
                    
                    iNegative++;
                }                     
                
                if (twoNegatives) {
                    i = iNegative;
                    product = testProduct;
                } else {//terminamos de recorrer o encontramos un cero
                    product = 1;//me salto el num[i] 'negativo' o num[i] 'cero' y comienzo a calcular el producto de un nuevo subarreglo
                }
                
                if (testProduct > longerProduct) longerProduct = testProduct;
                
            } else if (product * nums[i] == 0)
                product = 1;
            else
                product *= nums[i];//sigue siendo positivo
            
            i++;                        
        }
        
        return longerProduct;        
    }        
    
    public static void main(String[] args) {
        int[] nums = {-3,0,1,-2};
               
        System.out.println(maxProduct(nums));
    }
}
