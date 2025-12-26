package com.chiranjeevkashyap.springboot.entities.types;

import lombok.Getter;

@Getter
public enum BloodGroup {
    A_POSITIVE("A+"),
    A_NEGATIVE("A-"),
    B_POSITIVE("B+"),
    B_NEGATIVE("B-"),
    AB_POSITIVE("AB+"),
    AB_NEGATIVE("AB-"),
    O_POSITIVE("O+"),
    O_NEGATIVE("O-");

    private final String value;

    BloodGroup(String value) {
        this.value = value;
    }

    public static BloodGroup fromValue(String value) {
        for (BloodGroup bloodGroup : BloodGroup.values()) {
            if (bloodGroup.value.equalsIgnoreCase(value)) return bloodGroup;
        }
        throw new IllegalArgumentException("Unknown blood group: " + value);
    }
}
