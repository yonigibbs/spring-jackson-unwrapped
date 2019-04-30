package com.yg.springjacksonunwrapped;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class SpringJacksonUnwrappedApplicationTests {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

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

    // This test works
    @Test
    public void unnestedHandledInAbstractClass() throws Exception {
        post(getUserSavedItem(), "unnested/abstract");
    }

    // This test works
    @Test
    public void nestedHandledInConcreteClass() throws Exception {
        post(getUserSavedItem().getInfo(), "nested/concrete");
    }

    // This is the failing unit test
    @Test
    public void nestedHandledInAbstractClass() throws Exception {
        post(getUserSavedItem(), "nested/abstract");
    }

    private void post(Object object, String urlPart) {
        ResponseEntity<String> response = restTemplate.postForEntity(
                "http://localhost:" + port + "/users/" + urlPart, object, String.class);
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
    }
}
