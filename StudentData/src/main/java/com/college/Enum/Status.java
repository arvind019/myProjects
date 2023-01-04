package com.college.Enum;

public enum Status {
    ACTIVE("ACTIVE"),
    INACTIVE("INACTIVE");
    private String name;

    Status(String name) {
        this.name = name;
    }

    public static String getStatusByCode(Status status) {
        return status.name;
    }

    @Override
    public String toString() {
        return name();
    }
}
