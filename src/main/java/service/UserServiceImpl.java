package service;

import lombok.AllArgsConstructor;

import lombok.NoArgsConstructor;
import model.User;
import repository.UserRepository;

import java.util.List;
import java.util.Map;

@AllArgsConstructor
@NoArgsConstructor
public class UserServiceImpl implements UserService {
    private UserRepository userRepository;

    @Override
    public User registerUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User fetchUser(String userId) {
        return userRepository.findById(userId);
    }

    @Override
    public List<User> fetchAll(List<String> users) {
        return userRepository.findAll(users);
    }

    @Override
    public void saveAll(List<User> users) {
        userRepository.saveAll(users);
    }

    @Override
    public String getUserIdByName(String name) {
        return userRepository.findIdByName(name);
    }


}
