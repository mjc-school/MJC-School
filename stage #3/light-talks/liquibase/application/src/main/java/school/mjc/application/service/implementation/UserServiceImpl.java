package school.mjc.application.service.implementation;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import school.mjc.application.exception.UserNotFoundException;
import school.mjc.application.model.User;
import school.mjc.application.repository.UserRepository;
import school.mjc.application.service.UserService;

import java.util.Optional;

@Service
@Slf4j
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User getUserById(Long id) {
        Optional<User> user = userRepository.findById(id);

        if (!user.isPresent()) {
            throw new UserNotFoundException("User doesn’t exist with given id: " + id);
        }
        return user.get();
    }

    @Override
    @Transactional
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    @Override
    @Transactional
    public void deleteUserById(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    @Transactional
    public User updateUserById(Long id, User updatedUser) {
        User existingUser = getUserById(id);
        if (existingUser.getId() != null) {
            updatedUser.setId(existingUser.getId());
            return saveUser(updatedUser);
        }
        return null;
    }
}
