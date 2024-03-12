package ru.netology.data;

import com.github.javafaker.Faker;
import lombok.Value;
import lombok.val;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Random;

public class DataGenerator {
    private DataGenerator() {
    }
    public static String generateDate(int shift) {
        return LocalDate.now().plusDays(shift).format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
    }

    public static String generateCity() {
        var cities = new String[]{
                "Белгород", "Брянск", "Владимир", "Воронеж", "Иваново", "Калуга", "Кострома", "Курск",
                "Липецк", "Москва", "Москва", "Орел", "Рязань", "Смоленск", "Тамбов", "Тверь", "Тула",
                "Ярославль", "Архангельск", "Вологда", "Калининград", "Петрозаводск", "Сыктывкар", "Санкт-Петербург",
                "Мурманск", "Салехард", "Великий Новгород", "Псков", "Санкт-Петербург", "Уфа", "Киров", "Йошкар-Ола",
                "Саранск", "Нижний Новгород", "Оренбург", "Пенза", "Пермь", "Самара", "Саратов", "Казань", "Ижевск",
                "Ульяновск", "Чебоксары", "Курган", "Екатеринбург", "Тюмень", "Ханты-мансийск", "Челябинск",
                "Салехард", "Горно-Алтайск", "Барнаул", "Улан-Удэ", "Чита", "Иркутск", "Кемерово", "Красноярск",
                "Новосибирск", "Омск", "Томск", "Кызыл", "Абакан", "Благовещенск", "Биробиджан",
                "Петропавловск-Камчатский", "Магадан", "Владивосток", "Якутск", "Южно-Сахалинск", "Хабаровск",
                "Анадырь", "Майкоп", "Астрахань", "Волгоград", "Элиста", "Краснодар", "Ростов", "Махачкала", "Магас",
                "Нальчик", "Черкесск", "Владивкавказ", "Ставрополь", "Грозный"
        };
        return cities[new Random().nextInt(cities.length)];
    }
    public static class Registration {
        private Registration() {
        }
        public static UserInfo generateUser(String locale) {
            Faker faker = new Faker(new Locale(locale));
            UserInfo user = new UserInfo(generateCity(), faker.name().firstName() + " " + faker.name().lastName(), faker.phoneNumber().phoneNumber());
            return user; //faker.address().city()
        }
    }
    @Value
    public static class UserInfo {
        String city;
        String name;
        String phone;

    }

}
