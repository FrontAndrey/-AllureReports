package allure;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;
import static org.openqa.selenium.By.linkText;

public class StepsSelenideTest {
    private  static final  String Repository = "eroshenkoam/allure-example";

    @BeforeAll
    static void beforeAll() {
        SelenideLogger.addListener("allure", new AllureSelenide());
        Configuration.browserSize = "1920x1080";
    }

    @Test
    public void testIssueSearchLambda() {
        step("Открываем главную страницу", () -> {
            open("https://github.com/");
        });
        step("Ищем репозиторий " + Repository, () -> {
            $(".header-search-button").click();
            $("#query-builder-test").setValue(Repository).submit();
        });
        step("Ищем нужную issue " + Repository, () -> {
            $(linkText(Repository)).click();
        });
    }

    @Test
    public void testAnnotatedStep() {
        WebSteps steps = new WebSteps();

        steps.openMainPage();
        steps.searchForRepo(Repository);
        steps.openIssueTab(Repository);
    }
}
