package com.gencoglutugrul;

public class ImprovedSolution extends AbstractSolution{
    /**
     * Complexity: O(n)
     * Needs to be loop over every fibonacci number up to 4m.
     * But checking if number even not necessary. The sequence repeats like
     * even - odd - odd - even - odd - odd ...
     * Proof: the first number is 1 (odd) second is 1 too (odd) and the third is 2 (even)
     * odd + odd = even, even + odd = odd, odd + even = odd, odd + odd = even (repeats)
     */
    @Override
    protected void solve() {
        long item1 = 1;
        long item2 = 1;
        long sumOfEachEvenFibonacciNumbers = 0;
        long nowResult = 0;

        // 1+1 = 2: this is second term of sequence ( 0. = 1, 1. = 1, 2. = 2 , 3. = 3, 4. = 5 ...)
        int evenCounter = 2;

        while(nowResult < 4 * Math.pow(10,6)){
            if (evenCounter == 3) {
                sumOfEachEvenFibonacciNumbers += nowResult;
                evenCounter = 0;
            }

            nowResult = item1 + item2;
            item2 = item1;
            item1 = nowResult;

            evenCounter++;
        }

        this.result = sumOfEachEvenFibonacciNumbers;
    }
}