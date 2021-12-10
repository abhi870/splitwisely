package repository;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import model.User;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@AllArgsConstructor
@NoArgsConstructor
public class UserRepositoryImpl implements UserRepository {
    private Map<String, User> users;
    private Map<String, User> usersByName;

    @Override
    public User save(User user) {
        return users.put(user.getId(), user);
    }

    @Override
    public User findById(String userId) {
        return users.get(userId);
    }

    @Override
    public List<User> findAll(List<String> userIds) {
        return userIds.stream()
                .filter(userId -> users.containsKey(userId))
                .map(userId -> users.get(userId))
                .collect(Collectors.toList());
    }

    @Override
    public void saveAll(List<User> updatedUsers) {
        updatedUsers.forEach(user -> {
            users.put(user.getId(), user);
            usersByName.put(user.getName(), user);
        });
    }

    @Override
    public String findIdByName(String name) {
        return usersByName.get(name).getId();
    }

}
