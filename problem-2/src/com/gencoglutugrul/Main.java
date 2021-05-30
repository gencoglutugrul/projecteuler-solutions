package com.gencoglutugrul;

public class Main {

    public static void main(String[] args) {
        System.out.println("Basic solution: ");
        AbstractSolution basicSolution = new BasicSolution();
        basicSolution.getResults();

        System.out.println("Improved solution: ");
        AbstractSolution improvedSolution = new ImprovedSolution();
        improvedSolution.getResults();

        System.out.println("Best solution: ");
        AbstractSolution bestSolution = new BestSolution();
        bestSolution.getResults();
    }
}
