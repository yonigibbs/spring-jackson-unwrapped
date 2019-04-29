package com.yg.springjacksonunwrapped;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public interface RestApi<Id, Basic, Extended> {
    @GetMapping
    SavedItem<Id, ItemInfo<Basic, Extended>> get();

    @PostMapping(value = "/genericsimple")
    String createSimple(@RequestBody ItemInfo<Basic, Extended> item) throws Exception;

    @PostMapping(value = "/genericextended")
    String createExtended(@RequestBody SavedItem<Id, ItemInfo<Basic, Extended>> item) throws Exception;
}
