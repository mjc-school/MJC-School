package school.mjc.application.service;

import school.mjc.application.model.User;

public interface UserService {

    User getUserById(Long id);

    User saveUser(User user);

    void deleteUserById(Long id);

    User updateUserById(Long id, User updatedUser);

}