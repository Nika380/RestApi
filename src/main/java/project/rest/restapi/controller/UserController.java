package project.rest.restapi.controller;

import org.springframework.web.bind.annotation.*;
import project.rest.restapi.entity.Post;
import project.rest.restapi.entity.User;
import project.rest.restapi.services.post.PostService;
import project.rest.restapi.services.user.UserService;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;
    private final PostService postService;

    public UserController(UserService userService, PostService postService) {
        this.userService = userService;
        this.postService = postService;
    }

    @GetMapping("")
    List<User> getUsers() {
        return userService.getUsers();
    }

    @GetMapping("/{id}")
    User userById(@PathVariable int id) {
        return userService.getUserById(id);
    }
    @PostMapping("")
    User addUser(@RequestBody User user) {
        return userService.addUser(user);
    }

    @PutMapping("/{id}")
    User updateUSerInfo(@RequestBody User user, @PathVariable int id) {
        return userService.updateUSer(user, id);
    }

    @DeleteMapping("/{id}")
    void deleteUser(@PathVariable int id) {
        userService.deleteUser(id);
    }

    @GetMapping("/{userId}/posts")
    List<Post> getUserPosts(@PathVariable int userId) {
        return postService.getPostsByUserId(userId);
    }
}
