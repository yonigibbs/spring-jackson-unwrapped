package com.yg.springjacksonunwrapped;

public abstract class AbstractRestController<Id, Basic, Extended> implements RestApi<Id, Basic, Extended> {
    @Override
    public String createSimple(ItemInfo<Basic, Extended> item) throws Exception {
        if (item.getBasicInfo() == null || item.getExtendedInfo() == null)
            throw new Exception("Got null info");
        System.out.println("About to create " + item);
        return "OK";
    }

    @Override
    public String createExtended(SavedItem<Id, ItemInfo<Basic, Extended>> item) throws Exception {
        if (item.getInfo().getBasicInfo() == null || item.getInfo().getExtendedInfo() == null)
            throw new Exception("Got null info");
        System.out.println("About to create " + item);
        return "OK";
    }
}
