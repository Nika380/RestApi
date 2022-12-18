package project.rest.restapi.controller;

import org.springframework.web.bind.annotation.*;
import project.rest.restapi.entity.Post;
import project.rest.restapi.services.post.PostService;

import java.util.List;

@RestController
@RequestMapping("/posts")
public class PostController {
    private final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping("")
    List<Post> getAllPost() {
        return postService.getAllPosts();
    }
    @PostMapping("")
    Post addPost(@RequestBody Post post) {
        return postService.addPost(post);
    }

    @PutMapping("/{id}")
    Post updatePost(@RequestBody Post post, @PathVariable int id) {
        return postService.updatePost(post, id);
    }
    @GetMapping("/{id}")
    Post getPosById(@PathVariable int id) {
        return postService.getPostById(id);
    }

    @DeleteMapping("/{id}")
    void deletePost(@PathVariable int id) {
        postService.deletePost(id);
    }

}
