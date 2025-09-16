package allure;

import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LabelTest {


    //BDD два варианта

    @Test
    @Feature("Issue в репо")
    @Story("Создание Issue")
    @Owner("AButor")
    @Severity(SeverityLevel.BLOCKER)
    @Link(value = "Testing", url = "https://github.com")
    @DisplayName("Создание Issue для авторизованного пользователя")
    public void testStaticLabels() {

    }

    @Test
    public void testAnnotatedStep() {
       Allure.getLifecycle().updateTestCase(
               t->t.setName("Создание Issue для авторизованного пользователя")
       );
       Allure.feature("Issue в репо");
       Allure.story("Создание Issue");
       Allure.label("Owner", "AButor");
       Allure.label("severity", SeverityLevel.BLOCKER.value());
       Allure.link("Testing", "https://github.com");
    }
}
