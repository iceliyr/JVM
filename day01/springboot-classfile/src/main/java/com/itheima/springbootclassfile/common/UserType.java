package com.itheima.springbootclassfile.common;

public enum UserType {
    REGULAR(1001),VIP(1002);
    Integer type;

    UserType(int type) {
        this.type = type;
    }

    public Integer getType() {
        return type;
    }
}
