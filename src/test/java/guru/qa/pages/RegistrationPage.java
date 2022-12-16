package guru.qa.pages;

import com.codeborne.selenide.SelenideElement;
import guru.qa.pages.components.CalendarComponent;
import guru.qa.pages.components.RegistrationResultsModal;
import io.qameta.allure.Step;

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

    @Step("Open 'automation-practice-form' form")
    public RegistrationPage openPage() {
        open("/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text(TITLE_TEXT));
        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#fixedban').remove()");

        return this;
    }

    @Step("Set {name} value in firstname input")
    public RegistrationPage setFirstName(String name) {
        firstNameInput.setValue(name);

        return this;
    }

    @Step("Set {secondName} value in secondname input")
    public RegistrationPage setSecondName(String secondName) {
        lastNameInput.setValue(secondName);

        return this;
    }

    @Step("Set {email} value in email input")
    public RegistrationPage setEmail(String email) {
        emailInput.setValue(email);

        return this;
    }

    @Step("Select {gender} gender")
    public RegistrationPage setGender(String gender) {
        genderRadioButton.$(byText(gender)).click();

        return this;
    }

    @Step("Set {phoneNumber} in phoneNumber input")
    public RegistrationPage setPhoneNumber(String phoneNumber) {
        phoneNumberInput.setValue(phoneNumber);

        return this;
    }

    @Step("Set user birth date - {day}.{month}.{year}")
    public RegistrationPage setBirthDate(String day, String month, String year) {
        dateOfBirthInput.click();
        calendarComponent.setDate(day, month, year);

        return this;
    }

    @Step("Set the next subject {subject}")
    public RegistrationPage selectSubject(String subject) {
        subjectsInput.setValue(subject).pressEnter();

        return this;
    }

    @Step("Select user hobby - {hobby}")
    public RegistrationPage selectHobby(String hobby) {
        hobbyCheckBoxes.$(byText(hobby)).click();
        return this;
    }

    @Step("Upload user avatar")
    public RegistrationPage uploadPicture(String fileNamePath) {
        uploadFileInput.uploadFromClasspath(fileNamePath);

        return this;
    }

    @Step("Set user address")
    public RegistrationPage setCurrentAddress(String currentAddress) {
        currentAddressTextArea.setValue(currentAddress);

        return this;
    }

    @Step("Select user state")
    public RegistrationPage setState(String state) {
        stateSelect.click();
        cityAndStateList.$(byText(state)).click();

        return this;
    }

    @Step("Select user city")
    public RegistrationPage setCity(String city) {
        citySelect.click();
        cityAndStateList.$(byText(city)).click();

        return this;
    }

    @Step("Send form")
    public RegistrationPage sendForm() {
        SendFormButton.scrollTo().click();

        return this;
    }

    @Step("Check if a modal window appears for a successful form submission")
    public RegistrationPage verifyResultsModalAppears() {
        registrationResultsModal.verifyModalAppears();

        return this;
    }

    @Step("Match the field values entered in the form with the data in the modal window")
    public RegistrationPage verifyResult(String key, String value) {
        registrationResultsModal.verifyResult(key, value);

        return this;
    }

}
