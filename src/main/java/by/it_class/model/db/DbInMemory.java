package by.it_class.model.db;

import by.it_class.model.entities.User;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class DbInMemory {
    private static List<User> users = new ArrayList<>();

    static {
        users.add(new User(1, "Vasia Pupkin", "vasia@gmail.com"));
        users.add(new User(2, "Ivan Ivanov", "ivan@mail.ru"));
        users.add(new User(3, "Petr Petrov", "petr@yandex.ru"));
    }

    public static boolean isUserByName(String name) {
        return users.stream()
                .anyMatch(it -> it.getName().equalsIgnoreCase(name));//anyMatch- есть ли хотябы одно вхождение
    }

    public static User findUserByName(String name) {
        return users.stream()
                .filter(it -> it.getName().equalsIgnoreCase(name))
                .findFirst() // ищет первое вхождение
                .orElse(null); //если найдет, то вернет, а если нет , то вернет null
    }

    public static List<User> findUsersById(int fromId, int toId) {
        return users.stream()
                .filter(it -> it.getId() >= fromId && it.getId() <= toId)
                .collect(Collectors.toList());
    }
}
