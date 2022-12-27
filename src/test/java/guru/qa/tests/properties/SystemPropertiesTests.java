package guru.qa.tests.properties;

import org.junit.jupiter.api.Test;

public class SystemPropertiesTests {


    @Test
    void simplePropertyTest() {
        System.setProperty("browser", "opera");
        String browserName = System.getProperty("browser");
        System.out.println(browserName);
    }
}
