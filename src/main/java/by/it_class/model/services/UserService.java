package by.it_class.model.services;

import by.it_class.model.dao.UserDao;
import by.it_class.model.db.DbInMemory;
import by.it_class.model.entities.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

public class UserService {
    private UserDao userDao;

    public UserService() {
        userDao = new UserDao();
    }

    public List<User> getUserByCriteria(Map<String, String[]> params) {
        List<User> users = new ArrayList<>();
        String criteria = params.get("criteria")[0];
        switch (criteria) {
            case "name": {
                String name = params.get("name")[0];
                //users.add(DbInMemory.findUserByName(name));
                users.add(userDao.findByName(name));
                users = users.stream()
                        .filter(Objects::nonNull)
                        .collect(Collectors.toList());
                break;
            }

            case "id": {
                String fromId = params.get("fromId")[0];
                String toId = params.get("toId")[0];
                int from = Integer.parseInt(fromId);
                int to = Integer.parseInt(toId);
                // users = DbInMemory.findUsersById(from, to);
                users = userDao.findByIds(from, to);
                break;
            }

            default:
                break;
        }
        return users;
    }
}
