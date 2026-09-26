
package maxAndMin;

public class Main {
    
    static int getMaxInArray(int[] array, int start, int end) {
        if (start == end) 
            return array[start];
        else {            
            int middle = (start + end) / 2;
            int leftNumber;
            int rightNumber;
                        
            return ((leftNumber = getMaxInArray(array, start, middle)) > 
                    (rightNumber = getMaxInArray(array, middle + 1, end))) ? leftNumber : rightNumber;
        }
    }
    
    static int getMinInArray(int[] array, int start, int end) {
        if (start == end) 
            return array[start];
        else {            
            int middle = (start + end) / 2;
            int leftNumber;
            int rightNumber;
                        
            return ((leftNumber = getMinInArray(array, start, middle)) <
                    (rightNumber = getMinInArray(array, middle + 1, end))) ? leftNumber : rightNumber;
        }
    }
    
    static int getPosMaxValueInArray(int[] array, int start, int end) {
        if (start == end) {
            return start;
        } else {
            int middle = (start + end) / 2;
            int leftPosition = getPosMaxValueInArray(array, start, middle);
            int rightPosition = getPosMaxValueInArray(array, middle + 1, end);
            
            return (array[leftPosition] > array[rightPosition]) ? leftPosition : rightPosition;
        }        
    }
    
    static int getPosMinValueInArray(int[] array, int start, int end) {
        if (start == end) {
            return start;
        } else {
            int middle = (start + end) / 2;
            int leftPosition = getPosMinValueInArray(array, start, middle);
            int rightPosition = getPosMinValueInArray(array, middle + 1, end);
            
            return (array[leftPosition] < array[rightPosition]) ? leftPosition : rightPosition;
        }        
    }
    
    static int[] getMaxAndMinInArray(int[] array, int posStart, int posEnd) {
        if (posStart == posEnd) 
            return new int[] {array[posStart], array[posStart]};
        else {
            int middle = (posStart + posEnd) / 2;
            
            int[] leftArray = getMaxAndMinInArray(array, posStart, middle);
            int[] rightArray = getMaxAndMinInArray(array, middle + 1, posEnd);
            
            int minValue = (leftArray[0] < rightArray[0]) ? leftArray[0] : rightArray[0];
            int maxValue = (leftArray[1] > rightArray[1]) ? leftArray[1] : rightArray[1];
                                    
            return new int[] {minValue, maxValue};
        }
    }
    
    public static void main(String[] args) {
        int[] arrayOfNumbers = {1, 20, 3000, 44, 554, -1, 10, 900};
        
        System.out.println("Max value: " + getMaxInArray(arrayOfNumbers, 0, arrayOfNumbers.length - 1));
        System.out.println("Position of maximum: " + getPosMaxValueInArray(arrayOfNumbers, 0, arrayOfNumbers.length - 1));
        System.out.println("Min value: " + getMinInArray(arrayOfNumbers, 0, arrayOfNumbers.length - 1));
        System.out.println("Position of minimum: " + getPosMinValueInArray(arrayOfNumbers, 0, arrayOfNumbers.length - 1));
        
        System.out.println("\nIn one only...");                
        int[] minMaxValue = getMaxAndMinInArray(arrayOfNumbers, 0, arrayOfNumbers.length - 1);
        System.out.println("Min = " + minMaxValue[0]);
        System.out.println("Max = " + minMaxValue[1]);
    }
    
}
