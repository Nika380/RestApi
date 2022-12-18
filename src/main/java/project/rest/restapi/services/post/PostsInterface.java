package project.rest.restapi.services.post;


import project.rest.restapi.entity.Post;

import java.util.List;

public interface PostsInterface {
    List<Post> getAllPosts();
    Post getPostById(int id);
    Post addPost(Post post);
    Post updatePost(Post post, int id);
    void deletePost(int id);
}
