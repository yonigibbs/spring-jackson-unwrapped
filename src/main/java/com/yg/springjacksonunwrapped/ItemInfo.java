package com.yg.springjacksonunwrapped;

import com.fasterxml.jackson.annotation.JsonUnwrapped;

public class ItemInfo<Basic, Extended> {
    @JsonUnwrapped
    private Basic basicInfo;
    @JsonUnwrapped
    private Extended extendedInfo;

    public Basic getBasicInfo() {
        return basicInfo;
    }

    public void setBasicInfo(Basic basicInfo) {
        this.basicInfo = basicInfo;
    }

    public Extended getExtendedInfo() {
        return extendedInfo;
    }

    public void setExtendedInfo(Extended extendedInfo) {
        this.extendedInfo = extendedInfo;
    }

    @Override
    public String toString() {
        return "ItemInfo{" +
                "basicInfo=" + basicInfo +
                ", extendedInfo=" + extendedInfo +
                '}';
    }
}
