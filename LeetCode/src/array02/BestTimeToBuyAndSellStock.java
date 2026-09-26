
package array02;

public class BestTimeToBuyAndSellStock {
    
    //solution recursive:
    //is an answer correct but the time limit exceeded.
    public static int maxProfit(int[] prices) {
        return maxProfit(prices, 0, new int[2], new int[2], 0);
    }
    
    private static int maxProfit(int[] prices, int iterator, int[] testTwoDays, 
            int[] maxTwoDays, int i) {
        
        if (iterator == 2) {
            
            int sumMaxSale;           
            int sumTestSale;
            
            if ((sumTestSale = calculateSale(testTwoDays)) > (sumMaxSale = calculateSale(maxTwoDays))) {
                
                for (int d = 0; d < testTwoDays.length; d++)
                    maxTwoDays[d] = testTwoDays[d];        
                
                return sumTestSale;
            }
            
            return sumMaxSale;//i keep my biggest.
                            
        } else {
            
            int max = 0;
            
            for (; i < prices.length; i++) {                
                testTwoDays[iterator] = prices[i];                                
                
                if (iterator == 0 && i == prices.length - 1) //<-- The last element of price cannot invest in the future
                    return max;
                
                max = maxProfit(prices, iterator + 1, testTwoDays, maxTwoDays, i + 1);
                testTwoDays[iterator] = 0;
            }
            
            return max;
            
        }
    }
    
    private static int calculateSale(int[] twoDays) {
        return twoDays[1] - twoDays[0];
    }        
            
    
    /////////////////////
    //is correct but Time Limit Exceeded too.
    public static int maxProfitLoops(int[] prices) {
        
        int[] days = new int[2];
        int best = 0;
        int aux;
        
        for (int i = 0; i < prices.length - 1; i++) {
            days[0] = prices[i];
            for (int j = i + 1; j <= prices.length - 1; j++) {
                days[1] = prices[j];
                best = ((aux = calculateSale(days)) > best) ? aux : best;                
            }                        
        }
        
        return best;        
    }
    
    //------In the two previous methods I am making combinations but that takes me too much time.
    
    //The following method is done in a much more intelligent way without having to make combinations. It is more fast
    
    //Note very important: Simply, when we find low price of stock, 
    //we should buy it so that we can get maximum profit in a later day.
    //this solution is accepted in leetcode:
    public static int maxProfitAnalyzedSolution(int[] prices) {
        
        int lowInvestment = prices[0];
        int futureInvestment;
        int best = 0;
        int aux;
        
        for (int i = 1; i < prices.length; i++) {

            futureInvestment = prices[i];
            
            if (futureInvestment < lowInvestment && i < prices.length - 1) { //I compare if there is something cheaper to invest but also if in the future I have something to receive
                lowInvestment = futureInvestment;
            } else {//I invest with the values ​​that I currently have and it is saved if it is a good investment, then I continue reviewing future investments with which I invest less money.
                best = ((aux = calculateInvestment(lowInvestment, futureInvestment)) > best) ? aux : best;
            }

        }
        
        return best;        
    }
    
    private static int calculateInvestment(int lowInvestment, int futureInvestment) {
        return futureInvestment - lowInvestment;
    }            
    
    public static void main(String[] args) {
        int[] prices = {7,1,5,3,6,4};
        
//        System.out.println("BestRecursive: " + maxProfit(prices));
//        System.out.println("BestLoops: " + maxProfitLoops(prices));
        System.out.println("BestAnalyzedSolution: " + maxProfitAnalyzedSolution(prices));
    }
    
}
