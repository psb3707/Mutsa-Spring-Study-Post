package Mutsa_Spring.postexample.Service;

import Mutsa_Spring.postexample.Repository.PostRepository;
import Mutsa_Spring.postexample.entity.Post;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;

    @Transactional
    public void save(Post post) {
        postRepository.save(post);
    }

    public Post findById(Long id) {
        Post post = postRepository.findById(id);
        return post;
    }

    public List<Post> findAll() {
        return postRepository.findAll();
    }

    public List<Post> findAllByOrder(String order) {
        List<Post> allOrderByCreatedAtDesc = postRepository.findAllOrderByCreatedAtDesc(order);
        return allOrderByCreatedAtDesc;
    }
}
