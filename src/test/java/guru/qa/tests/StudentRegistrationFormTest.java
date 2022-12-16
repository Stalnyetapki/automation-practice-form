package guru.qa.tests;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static guru.qa.tests.TestData.*;

public class StudentRegistrationFormTest extends TestBase {

    @Test
    @Feature("Student Registration form")
    @Story("Sending Student Registration form with all fields")
    @Severity(SeverityLevel.BLOCKER)
    @DisplayName("E2E sending form test")
    void sendFormTest() {

        registrationPage.openPage()
                .setFirstName(name)
                .setSecondName(surname)
                .setEmail(email)
                .setGender(gender)
                .setPhoneNumber(phoneNumber)
                .setBirthDate(dayOfBirth, monthOfBirth, yearOfBirth)
                .selectSubject(englishSubject)
                .selectHobby(hobby)
                .uploadPicture(pathFileName)
                .setCurrentAddress(currentAddress)
                .setState(state)
                .setCity(city)
                .sendForm()
                .verifyResultsModalAppears()
                .verifyResult("Student Name", name + " " + surname)
                .verifyResult("Student Email", email)
                .verifyResult("Gender", gender)
                .verifyResult("Mobile", phoneNumber)
                .verifyResult("Date of Birth", dayOfBirth + " " + monthOfBirth + "," + yearOfBirth)
                .verifyResult("Subjects", englishSubject)
                .verifyResult("Hobbies", hobby)
                .verifyResult("Picture", filename)
                .verifyResult("Address", currentAddress)
                .verifyResult("State and City", state + " " + city);

    }
}
