package com.yg.springjacksonunwrapped;

public class Utils {
    public static SavedItem<Integer, ItemInfo<UserBasicInfo, UserExtendedInfo>> getUserSavedItem() {
        UserBasicInfo basicInfo = new UserBasicInfo();
        basicInfo.setName("user1");
        UserExtendedInfo extendedInfo = new UserExtendedInfo();
        extendedInfo.setRoleName("role1");
        ItemInfo<UserBasicInfo, UserExtendedInfo> info = new ItemInfo<>();
        info.setBasicInfo(basicInfo);
        info.setExtendedInfo(extendedInfo);
        SavedItem<Integer, ItemInfo<UserBasicInfo, UserExtendedInfo>> savedItem = new SavedItem<>();
        savedItem.setId(1);
        savedItem.setInfo(info);
        return savedItem;
    }
}
