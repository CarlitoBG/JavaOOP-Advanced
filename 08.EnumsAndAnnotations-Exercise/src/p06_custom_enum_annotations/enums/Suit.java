package p06_custom_enum_annotations.enums;

import p06_custom_enum_annotations.CustomAnnotation;

@CustomAnnotation(type = "Enumeration", category = "Suit", description = "Provides suit constants for a Card class.")
public enum Suit {
    CLUBS(0), DIAMONDS(13), HEARTS(26), SPADES(39);

    private int value;

    Suit(int value) {
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }
}