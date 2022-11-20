package guru.qa.pages;

import com.codeborne.selenide.SelenideElement;
import guru.qa.pages.components.CalendarComponent;
import guru.qa.pages.components.RegistrationResultsModal;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationPage {

    private CalendarComponent calendarComponent = new CalendarComponent();
    private RegistrationResultsModal registrationResultsModal = new RegistrationResultsModal();
    private final String TITLE_TEXT = "Student Registration Form";
    private SelenideElement
            firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            dateOfBirthInput = $("#dateOfBirthInput"),
            emailInput = $("#userEmail"),
            genderRadioButton = $("#genterWrapper"),
            phoneNumberInput = $("#userNumber"),
            subjectsInput = $("#subjectsInput"),
            hobbyCheckBoxes = $("#hobbiesWrapper"),
            uploadFileInput = $("#uploadPicture"),
            currentAddressTextArea = $("#currentAddress"),
            stateSelect = $("#state"),
            citySelect = $("#city"),
            cityAndStateList = $("#stateCity-wrapper"),
            SendFormButton = $("#submit");


    public RegistrationPage openPage() {
        open("/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text(TITLE_TEXT));
        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#fixedban').remove()");

        return this;
    }

    public RegistrationPage setFirstName(String name) {
        firstNameInput.setValue(name);

        return this;
    }

    public RegistrationPage setSecondName(String secondName) {
        lastNameInput.setValue(secondName);

        return this;
    }

    public RegistrationPage setEmail(String email) {
        emailInput.setValue(email);

        return this;
    }

    public RegistrationPage setGender(String gender) {
        genderRadioButton.$(byText(gender)).click();

        return this;
    }

    public RegistrationPage setPhoneNumber(String phoneNumber) {
        phoneNumberInput.setValue(phoneNumber);

        return this;
    }

    public RegistrationPage setBirthDate(String day, String month, String year) {
        dateOfBirthInput.click();
        calendarComponent.setDate(day, month, year);

        return this;
    }

    public RegistrationPage selectSubject(String subject) {
        subjectsInput.setValue(subject).pressEnter();

        return this;
    }

    public RegistrationPage selectHobby(String hobby) {
        hobbyCheckBoxes.$(byText(hobby)).click();
        return this;
    }

    public RegistrationPage uploadPicture(String fileNamePath) {
        uploadFileInput.uploadFromClasspath(fileNamePath);

        return this;
    }

    public RegistrationPage setCurrentAddress(String currentAddress) {
        currentAddressTextArea.setValue(currentAddress);

        return this;
    }

    public RegistrationPage setState(String state) {
        stateSelect.click();
        cityAndStateList.$(byText(state)).click();

        return this;
    }

    public RegistrationPage setCity(String city) {
        citySelect.click();
        cityAndStateList.$(byText(city)).click();

        return this;
    }

    public RegistrationPage sendForm() {
        SendFormButton.scrollTo().click();

        return this;
    }

    public RegistrationPage verifyResultsModalAppears() {
        registrationResultsModal.verifyModalAppears();

        return this;
    }

    public RegistrationPage verifyResult(String key, String value) {
        registrationResultsModal.verifyResult(key, value);

        return this;
    }

}
