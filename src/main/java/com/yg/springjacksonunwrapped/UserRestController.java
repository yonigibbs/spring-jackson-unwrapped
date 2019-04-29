package com.yg.springjacksonunwrapped;

import org.springframework.web.bind.annotation.*;

import static com.yg.springjacksonunwrapped.Utils.getUserSavedItem;

@RestController
@RequestMapping("/users")
public class UserRestController extends AbstractRestController<Integer, UserBasicInfo, UserExtendedInfo> {
    public SavedItem<Integer, ItemInfo<UserBasicInfo, UserExtendedInfo>> get() {
        return getUserSavedItem();
    }

    @PostMapping("/nongeneric")
    public String create(@RequestBody SavedItem<Integer, ItemInfo<UserBasicInfo, UserExtendedInfo>> item) throws Exception {
        if (item.getInfo().getBasicInfo() == null || item.getInfo().getExtendedInfo() == null)
            throw new Exception("Got null info");
        System.out.println("About to create " + item);
        return "OK";
    }
}
