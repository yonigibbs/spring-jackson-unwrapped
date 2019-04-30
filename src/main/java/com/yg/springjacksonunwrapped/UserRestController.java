package com.yg.springjacksonunwrapped;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserRestController extends AbstractRestController<Integer, UserBasicInfo, UserExtendedInfo> {
    @PostMapping("/nested/concrete")
    public void handleNestedInConcreteClass(@RequestBody SavedItem<Integer, ItemInfo<UserBasicInfo, UserExtendedInfo>> item) throws Exception {
        // This works OK: we have values for basicInfo and extendedInfo
        if (item.getInfo().getBasicInfo() == null || item.getInfo().getExtendedInfo() == null)
            throw new Exception("Got null info");
    }
}
