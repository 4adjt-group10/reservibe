package com.reservibe.domain.enums.review;

public enum ReviewStars {
    ONE(1),
    TWO(2),
    THREE(3),
    FOUR(4),
    FIVE(5);

    private final int value;

    ReviewStars(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
