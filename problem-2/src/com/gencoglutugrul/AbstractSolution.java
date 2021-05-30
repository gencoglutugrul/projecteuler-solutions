package com.gencoglutugrul;



public abstract class AbstractSolution {
    protected long result;

    public void getResults(){
        long start = System.nanoTime();
        this.solve();
        long executionTime = System.nanoTime() - start;

        System.out.printf("Result: %d, Time Estimated: %dns\n", this.result, executionTime);
    }

    protected abstract void solve();
}
