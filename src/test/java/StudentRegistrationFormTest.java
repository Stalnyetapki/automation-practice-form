import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class StudentRegistrationFormTest {

    @BeforeAll
    static void setUp(){
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
        Configuration.holdBrowserOpen = true;
    }

    @Test
    void sendFormTest(){
        String name = "Harrier";
        String surname = "DuBois";
        String email = "harrier.duBois@gmail.com";
        String phoneNumber = "89969877898";
        String englishSubject = "English";
        String currentAddress = "street Pushkina, house Kolotushkina";
        String state = "NCR";
        String city = "Delhi";

        open("/automation-practice-form");
        $("#firstName").setValue(name);
        $("#lastName").setValue(surname);
        $("#userEmail").setValue(email);
        $x("//label[@class='custom-control-label'][text()='Male']").click();
        $("#userNumber").setValue(phoneNumber);
        $("#dateOfBirthInput").click();
        $(".react-datepicker__year-select").selectOptionByValue("1992");
        $(".react-datepicker__month-select").selectOptionByValue("2");
        $(".react-datepicker__week  div[aria-label='Choose Tuesday, March 3rd, 1992']").click();
        $("#subjectsInput").setValue(englishSubject).pressEnter();
        $$(".custom-control-label").findBy(text("Sports")).click();
        $$(".custom-control-label").findBy(text("Reading")).click();
        $("uploadPicture").uploadFromClasspath("2022-10-03_21h15_11.png");
    }
}
