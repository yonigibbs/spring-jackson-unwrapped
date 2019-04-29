package com.yg.springjacksonunwrapped;

public class UserExtendedInfo {
    private String roleName;

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    @Override
    public String toString() {
        return "UserExtendedInfo{" +
                "roleName='" + roleName + '\'' +
                '}';
    }
}
