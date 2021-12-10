package repository;

import model.User;

import java.util.List;

public interface UserRepository {
    User save(User user);
    User findById(String userId);
    List<User> findAll(List<String> userIds);

    void saveAll(List<User> updatedUsers);
    String findIdByName(String name);
}
