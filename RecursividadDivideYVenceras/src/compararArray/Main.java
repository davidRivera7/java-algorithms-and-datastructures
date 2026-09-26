
package compararArray;

public class Main {
    
    static boolean compareArrays(int[] arrayOne, int[] arrayTwo, int startPosition,
            int endPosition) {
    
        if (arrayOne.length != arrayTwo.length)
            return false;
        
        if (startPosition == endPosition) 
            return arrayOne[startPosition] == arrayTwo[startPosition];
        
        else {
            int middle = (startPosition + endPosition) / 2;
            
            boolean leftSide = compareArrays(arrayOne, arrayTwo, startPosition, middle);
            boolean rightSide = true;            
            
            if (leftSide) 
                rightSide = compareArrays(arrayOne, arrayTwo, middle + 1,
                        endPosition);            
            
            return leftSide && rightSide;
        }
    }
    
    /**
     * 
     * @param arrayOne
     * @param arrayTwo
     * @param posStart
     * @param posEnd
     * @return -1 if they are equals, pos where is different or 1010 if lenght is different in both
     */
    static int compareArraysWithPosition(int[] arrayOne, int[]arrayTwo, int posStart, int posEnd) {
        if (arrayOne.length != arrayTwo.length)
            return 1010;
        
        if (posStart == posEnd) {
            if (arrayOne[posStart] != arrayTwo[posStart])
                return posStart;
            
            return -1;
        } else {
            
            int middle = (posStart + posEnd) / 2;
            
            int leftSide = compareArraysWithPosition(arrayOne, arrayTwo, posStart, middle);                        
                        
            if (leftSide > -1)
                return leftSide;
                
            int rightSide = compareArraysWithPosition(arrayOne, arrayTwo, middle + 1, posEnd);
            
            if (rightSide > -1)
                return rightSide;
            
            return - 1;            
        }
    }
    
    public static void main(String[] args) {
        int[] arrayOne = {1, 2, 3, 4, 5, 7};
        int[] arrayTwo = {1, 2, 3, 4, 5, 9};
        
        System.out.println("For boolean expresion...");
        System.out.println("Equal Arrays: " + compareArrays(arrayOne, arrayTwo, 0, arrayOne.length - 1));
        System.out.println("For position...");        
        
        int differentPosition;
        switch ((differentPosition = compareArraysWithPosition(arrayOne, arrayTwo, 0, arrayOne.length - 1))) {
            case 1010: System.out.println("different arrays for lenght"); break;
            case -1: System.out.println("Equal arrays"); break;            
            default: System.out.println("different position: " + differentPosition); break;            
        }                
    }
    
}
