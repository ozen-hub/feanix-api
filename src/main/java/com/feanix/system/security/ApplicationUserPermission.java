package com.feanix.system.security;

public enum ApplicationUserPermission {
    PRODUCT_READ("product:read"),
    PRODUCT_WRITE("product:write"),
    ORDER_READ("order:read"),
    ORDER_WRITE("order:write");

    private final String permission;


    ApplicationUserPermission(String permission) {
        this.permission = permission;
    }

    public String getPermission(){
        return permission;
    }
}
