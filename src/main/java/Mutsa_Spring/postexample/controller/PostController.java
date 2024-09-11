package Mutsa_Spring.postexample.controller;

import Mutsa_Spring.postexample.Service.PostService;
import Mutsa_Spring.postexample.dto.PostCreateDto;
import Mutsa_Spring.postexample.entity.Post;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;

    @PostMapping("/api/posts")
    public ResponseEntity<Post> createPost(@RequestBody PostCreateDto request) {
        Post post = new Post(request.getTitle(), request.getContent());
        postService.save(post);
        return ResponseEntity.ok().body(post);
    }

    @GetMapping("/api/posts")
    public ResponseEntity<List<Post>> getPostsByOrder(@RequestParam(name = "order", defaultValue = "latest") String order) {
        List<Post> allByOrder = postService.findAllByOrder(order);
        return ResponseEntity.ok(allByOrder);
    }

    @GetMapping("/api/posts/{id}")
    public ResponseEntity<Post> getPost(@PathVariable Long id) {
        Post post = postService.findById(id);
        if (post == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(post);
    }
}
