package service;

import model.User;

import java.util.List;

public interface UserService {
    User registerUser(User user);
    User fetchUser(String id);
    List<User> fetchAll(List<String> users);
    void saveAll(List<User> users);
    String getUserIdByName(String name);
}
