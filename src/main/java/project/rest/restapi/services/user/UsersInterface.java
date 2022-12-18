package project.rest.restapi.services.user;

import project.rest.restapi.entity.Post;
import project.rest.restapi.entity.User;

import java.util.List;

public interface UsersInterface{
    List<User> getUsers();
    User getUserById(int id);
    User addUser(User user);
    User updateUSer(User user, int id);
    void deleteUser(int id);
    List<Post> getUserPosts(int userId);
}
