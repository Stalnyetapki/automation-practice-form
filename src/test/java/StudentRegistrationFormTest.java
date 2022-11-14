
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class StudentRegistrationFormTest {

    @BeforeAll
    static void setUp() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1100";
        Configuration.holdBrowserOpen = true;
    }

    @Test
    void sendFormTest() {
        String name = "Harrier";
        String surname = "DuBois";
        String email = "harrier.duBois@gmail.com";
        String phoneNumber = "9969877898";
        String englishSubject = "English";
        String currentAddress = "street Pushkina, house Kolotushkina";
        String state = "NCR";
        String city = "Delhi";
        String yearOfBirth = "1992";
        String monthOfBirth = "2";
        String readingSubject = "Reading";
        String sportsSubject = "Sports";
        String filename = "2022-10-03_21h15_11.png";
        String maleGender = "Male";

        open("/automation-practice-form");
        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#fixedban').remove()");
        $("#firstName").setValue(name);
        $("#lastName").setValue(surname);
        $("#userEmail").setValue(email);
        $x("//label[@class='custom-control-label'][text()='" + maleGender + "']").click();
        $("#userNumber").setValue(phoneNumber);
        $("#dateOfBirthInput").click();
        $(".react-datepicker__year-select").selectOptionByValue(yearOfBirth);
        $(".react-datepicker__month-select").selectOptionByValue(monthOfBirth);
        $(".react-datepicker__week  div[aria-label='Choose Tuesday, March 3rd, 1992']").click();
        $("#subjectsInput").setValue(englishSubject).pressEnter();
        $$(".custom-control-label").findBy(text(sportsSubject)).click();
        $$(".custom-control-label").findBy(text(readingSubject)).click();
        $("#uploadPicture").uploadFromClasspath(filename);
        $("#currentAddress").setValue(currentAddress);
        $("#react-select-3-input").setValue(state).pressEnter();
        $("#react-select-4-input").setValue(city).pressEnter();
        $("#submit").scrollTo().click();

        $(".fade.modal.show").shouldBe(appear);
        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
        $(".table-responsive tr:nth-child(1)>td:nth-child(2)").shouldHave(text(name + " " + surname));
        $(".table-responsive tr:nth-child(2)>td:nth-child(2)").shouldHave(text(email));
        $(".table-responsive tr:nth-child(3)>td:nth-child(2)").shouldHave(text(maleGender));
        $(".table-responsive tr:nth-child(4)>td:nth-child(2)").shouldHave(text(phoneNumber));
        $(".table-responsive tr:nth-child(5)>td:nth-child(2)").shouldHave(text("3 March," + yearOfBirth));
        $(".table-responsive tr:nth-child(6)>td:nth-child(2)").shouldHave(text(englishSubject));
        $(".table-responsive tr:nth-child(7)>td:nth-child(2)").shouldHave(text(sportsSubject + ", " + readingSubject));
        $(".table-responsive tr:nth-child(8)>td:nth-child(2)").shouldHave(text(filename));
        $(".table-responsive tr:nth-child(9)>td:nth-child(2)").shouldHave(text(currentAddress));
        $(".table-responsive tr:nth-child(10)>td:nth-child(2)").shouldHave(text(state + " " + city));
    }
}
