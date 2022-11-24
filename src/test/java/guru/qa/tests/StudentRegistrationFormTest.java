package guru.qa.tests;

import org.junit.jupiter.api.Test;
import static guru.qa.tests.TestData.*;

public class StudentRegistrationFormTest extends TestBase {

    @Test
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
