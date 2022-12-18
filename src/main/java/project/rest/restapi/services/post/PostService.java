package project.rest.restapi.services.post;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import project.rest.restapi.entity.Post;
import project.rest.restapi.exceptions.NotFoundException;
import project.rest.restapi.repository.PostRepository;

import java.util.List;
@Service
public class PostService implements PostsInterface{

    private final PostRepository postRepository;

    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @Override
    public List<Post> getAllPosts() {
        return postRepository.findAll();
    }

    @Override
    public Post getPostById(int id) {
        return postRepository.findById(id).
                orElseThrow(() -> new NotFoundException("Post not found"));
    }

    @Override
    public Post addPost(Post post) {
        postRepository.save(post);
        return post;
    }

    @Override
    public Post updatePost(Post post, int id) {
        var updatePost = getPostById(id);
        updatePost.setBody(post.getBody());
        updatePost.setTitle(post.getTitle());
        return updatePost;
    }

    @Override
    public void deletePost(int id) {
        var deletePost = getPostById(id);
        postRepository.delete(deletePost);
        ResponseEntity.noContent().build();
    }

    public List<Post> getPostsByUserId(int userId) {
        return postRepository.findByUserId(userId);
    }

}
