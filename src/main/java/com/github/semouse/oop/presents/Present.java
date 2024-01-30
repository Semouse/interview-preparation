package com.github.semouse.oop.presents;

import java.util.ArrayList;
import java.util.List;

public class Present {

    private final List<Sweet> sweets;

    public Present() {
        sweets = new ArrayList<>();
    }

    public Present(List<Sweet> sweets) {
        this.sweets = sweets;
    }

    public void addSweet(Sweet sweet) {
        if (sweet != null) {
            sweets.add(sweet);
        }
    }

    public double calculateTotalWeight() {
        return sweets.stream().mapToDouble(Sweet::getWeight).sum();
    }

    public Sweet[] filterSweetsBySugarRange(double minSugarWeight, double maxSugarWeight) {
        return sweets.stream().filter(sweet -> sweet.getSugarWeight() >= minSugarWeight
                && sweet.getSugarWeight() <= maxSugarWeight)
            .toArray(Sweet[]::new);
    }

    public Sweet[] getSweets() {
        return sweets.toArray(Sweet[]::new);
    }
}
