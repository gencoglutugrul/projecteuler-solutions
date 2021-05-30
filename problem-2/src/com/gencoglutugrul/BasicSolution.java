package com.gencoglutugrul;

public class BasicSolution extends AbstractSolution{
    /**
     * Complexity: O(n)
     * Needs to be loop over every fibonacci number up to 4m.
     */
    @Override
    protected void solve() {
        long item1 = 1;
        long item2 = 1;
        long sumOfEachEvenFibonacciNumbers = 0;
        long nowResult = 0;
        while(nowResult < 4 * Math.pow(10,6)){
            if (nowResult % 2 == 0) {
                sumOfEachEvenFibonacciNumbers += nowResult;
            }

            nowResult = item1 + item2;
            item2 = item1;
            item1 = nowResult;
        }

        this.result = sumOfEachEvenFibonacciNumbers;
    }
}