package guru.qa.tests;

import org.junit.jupiter.api.Test;

public class StudentRegistrationFormTest extends TestBase {

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
        String monthOfBirth = "March";
        String dayOfBirth = "03";
        String readingHobby = "Reading";
        String sportsHobby = "Sports";
        String filename = "2022-10-03_21h15_11.png";
        String pathFileName = "images/" + filename;
        String maleGender = "Male";

        registrationPage.openPage()
                .setFirstName(name)
                .setSecondName(surname)
                .setEmail(email)
                .setGender(maleGender)
                .setPhoneNumber(phoneNumber)
                .setBirthDate(dayOfBirth, monthOfBirth, yearOfBirth)
                .selectSubject(englishSubject)
                .selectHobby(sportsHobby)
                .selectHobby(readingHobby)
                .uploadPicture(pathFileName)
                .setCurrentAddress(currentAddress)
                .setState(state)
                .setCity(city)
                .sendForm()
                .verifyResultsModalAppears()
                .verifyResult("Student Name", name + " " + surname)
                .verifyResult("Student Email", email)
                .verifyResult("Gender", maleGender)
                .verifyResult("Mobile", phoneNumber)
                .verifyResult("Date of Birth", dayOfBirth + " " + monthOfBirth + "," + yearOfBirth)
                .verifyResult("Subjects", englishSubject)
                .verifyResult("Hobbies", sportsHobby + ", " + readingHobby)
                .verifyResult("Picture", filename)
                .verifyResult("Address", currentAddress)
                .verifyResult("State and City", state + " " + city);

    }
}
