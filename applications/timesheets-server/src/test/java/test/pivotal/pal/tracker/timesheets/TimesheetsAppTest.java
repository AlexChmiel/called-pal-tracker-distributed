package test.pivotal.pal.tracker.timesheets;

import io.pivotal.pal.tracker.timesheets.App;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;

import static org.assertj.core.api.Assertions.assertThat;

public class TimesheetsAppTest {

    @Autowired
    private RestTemplate restTemplate;

    @Test
    public void embedded() {
        App.main(new String[]{});

        String response = restTemplate.getForObject("http://localhost:8181/time-entries?userId=0", String.class);

        assertThat(response).isEqualTo("[]");
    }
}
