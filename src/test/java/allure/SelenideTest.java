package allure;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.*;
import static org.openqa.selenium.By.linkText;

public class SelenideTest {


    @BeforeAll
    static void beforeAll() {
        SelenideLogger.addListener("allure", new AllureSelenide());
        Configuration.browserSize = "1920x1080";
    }

    @Test
    public void testIssueSearch() {
        open("https://github.com/");
        $(".header-search-button").click();
        $("#query-builder-test").setValue("eroshenkoam/allure-example").submit();
        sleep(3000);
        $(linkText("eroshenkoam/allure-example")).click();

    }
}
