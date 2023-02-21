import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class PracticeForm extends BaseConfig {

    @ParameterizedTest
    @ValueSource(strings = {"Male", "Female", "Other", ""})
    void createNewUserTest(String str) {
        Selenide.open(Constant.BASE_URL.getUrl());
        Selenide.executeJavaScript("$('#fixedban').remove()");
        Selenide.executeJavaScript("$('footer').remove()");
        $x("//input[@id = 'firstName']").setValue("Oleg");
        $x("//input[@id = 'lastName']").setValue("Petrov");
        $x("//input[@id = 'userEmail']").setValue("PetrovOleg@mail.ru");
        $x(String.format("//label[text() = '%s']", str)).click();
        $("#userNumber").setValue("9168130220");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-dropdown-container").$(byText("March")).click();
        $(".react-datepicker__year-dropdown-container").$(byText("1980")).click();
        $(".react-datepicker__month-container").$(byText("13")).click();
        $("#subjectsInput").setValue("English").pressEnter();
        $("#hobbies-checkbox-3").parent().$(byText("Music")).click();
        $("#uploadPicture").uploadFromClasspath("pictures/e4.jpeg");
        $("#currentAddress").setValue("Victory cq 5");
        $("#state").click();
        $("#stateCity-wrapper").$(byText("Uttar Pradesh")).click();
        $("#city").click();
        $("#stateCity-wrapper").$(byText("Agra")).click();
        $("#submit").click();
        $(".modal-open").shouldHave(text("Thanks for submitting the form"));
        $(".modal-body").shouldHave(text("Oleg Petrov"));
        $(".modal-body").shouldHave(text("PetrovOleg@mail.ru"));
        $(".modal-body").shouldHave(text(str));
        $(".modal-body").shouldHave(text("9168130220"));
        $(".modal-body").shouldHave(text("13 March,1980"));
        $(".modal-body").shouldHave(text("English"));
        $(".modal-body").shouldHave(text("Music"));
        $(".modal-body").shouldHave(text("Victory cq 5"));
        $(".modal-body").shouldHave(text("Uttar Pradesh Agra"));
        $("#closeLargeModal").click();
    }
}
