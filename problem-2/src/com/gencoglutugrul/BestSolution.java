package com.gencoglutugrul;

public class BestSolution extends AbstractSolution{
    /**
     * Complexity: O(n)
     * Needs to be loop over *only* even fibonacci number up to 4m.
     * Logic: If we got something like fn that n%3 = 0, we need to deal with only even numbers.
     * So fn = fn-1 + fn-2, and thats equal
     * fn = fn-2 + fn-3 + fn-3 + fn-4
     * fn-3 is good we just need to change fn-2 and fn-4
     * fn = fn-3 + fn-4 + 2fn-3 + fn-5 + fn-6
     * fn-6 is good too. So we need to get rid of fn-4 and fn-5 luckily fn-4+fn-5=fn-3
     * fn = 4fn-3 + fn-6
     */
    @Override
    protected void solve() {
        long fn3 = 2;
        long fn6 = 0;
        long sumOfEachEvenFibonacciNumbers = 0;
        long nowResult = 2;

        while(nowResult < 4 * Math.pow(10,6)){
            sumOfEachEvenFibonacciNumbers += nowResult;

            nowResult = 4*fn3 + fn6;
            fn6 = fn3;
            fn3 = nowResult;
        }

        this.result = sumOfEachEvenFibonacciNumbers;
    }
}