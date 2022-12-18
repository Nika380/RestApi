package project.rest.restapi.services.user;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import project.rest.restapi.entity.Post;
import project.rest.restapi.entity.User;
import project.rest.restapi.exceptions.NotFoundException;
import project.rest.restapi.repository.UserRepository;

import java.util.List;

@Service
public class UserService implements UsersInterface{
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> getUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getUserById(int id) {
        return userRepository.findById(id).
                orElseThrow(() -> new NotFoundException("User not found"));
    }

    @Override
    public User addUser(User user) {
        userRepository.save(user);
        return user;
    }

    @Override
    public User updateUSer(User user, int id) {
        var update = getUserById(id);
        update.setUsername(user.getUsername());
        update.setPassword(user.getPassword());
        update.setEmail(user.getEmail());
        userRepository.save(update);
        return update;
    }

    @Override
    public void deleteUser(int id) {
        var delete = getUserById(id);
        userRepository.delete(delete);
        ResponseEntity.noContent().build();

    }

    @Override
    public List<Post> getUserPosts(int userId) {
        return null;
    }
}
