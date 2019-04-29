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

import static com.yg.springjacksonunwrapped.Utils.getUserSavedItem;
import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class SpringJacksonUnwrappedApplicationTests {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void nonGenericShouldWork() throws Exception {
        post(getUserSavedItem(), "nongeneric");
    }

    @Test
    public void genericSimpleShouldWork() throws Exception {
        post(getUserSavedItem().getInfo(), "genericsimple");
    }

    // This is the failing unit test
    @Test
    public void genericExtendedShouldWork() throws Exception {
        post(getUserSavedItem(), "genericextended");
    }

    private void post(Object object, String urlPart) {
        ResponseEntity<String> response = restTemplate.postForEntity(
                "http://localhost:" + port + "/users/" + urlPart, object, String.class);
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(response.getBody()).isEqualTo("OK");
    }
}
