package com.yg.springjacksonunwrapped;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public abstract class AbstractRestController<Id, Basic, Extended> {
    @PostMapping(value = "/unnested/abstract")
    public void handleUnnested(@RequestBody ItemInfo<Basic, Extended> item) throws Exception {
        // This works OK: we have values for basicInfo and extendedInfo
        if (item.getBasicInfo() == null || item.getExtendedInfo() == null)
            throw new Exception("Got null info");
    }

    @PostMapping(value = "/nested/abstract")
    public void handleNested(@RequestBody SavedItem<Id, ItemInfo<Basic, Extended>> item) throws Exception {
        // This fails: basicInfo and extendedInfo are both null
        if (item.getInfo().getBasicInfo() == null || item.getInfo().getExtendedInfo() == null)
            throw new Exception("Got null info");
    }
}
