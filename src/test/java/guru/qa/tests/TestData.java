package guru.qa.tests;

import com.github.javafaker.Faker;

import java.util.HashMap;
import java.util.Map;

import static guru.qa.utils.DataGenerator.*;

public class TestData {

    static String[] subjects = {"English", "Chemistry", "Computer Science", "Commerce", "Economics", "Social Studies"};
    static String[] ncrCities = {"Delhi", "Gurgaon", "Noida"};
    static String[] months = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
    static String[] hobbies = {"Reading", "Sports", "Music"};
    static String[] genders = {"Male", "Female"};

    static Faker faker = new Faker();
    public static String name = faker.name().firstName(),
    surname = faker.name().lastName(),
    email = getRandomEmail(10),
    phoneNumber = String.valueOf(getRandomNumber(1000000000L, 9999999999L)),
    englishSubject = randomListItem(subjects),
    currentAddress = faker.address().fullAddress(),
    state = "NCR",
    city = randomListItem(ncrCities),
    yearOfBirth = String.valueOf(getRandomNumber(1900L, 2100L)),
    monthOfBirth = randomListItem(months),
    dayOfBirth = "03",
    hobby = randomListItem(hobbies),
    filename = "2022-10-03_21h15_11.png",
    pathFileName = "images/" + filename,
    gender = randomListItem(genders);
}
