package Mutsa_Spring.postexample.Repository;

import Mutsa_Spring.postexample.entity.Post;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class PostRepository {
    private final EntityManager em;

    public void save(Post post) {
        em.persist(post);
    }

    public List<Post> findAll() {
        List resultList = em.createQuery("select p from Post p ORDER BY p.createdAt DESC ").getResultList();
        return resultList;
    }

    public Post findById(Long id) {
        return em.find(Post.class, id);
    }

    public List<Post> findAllOrderByCreatedAtDesc(String order) {
        if (order.equals("latest")) {
            List<Post> resultList = em.createQuery("select p from Post p order by p.createdAt desc ", Post.class).getResultList();
            return resultList;
        } else {
            List<Post> resultList = em.createQuery("select p from Post p order by p.createdAt asc ", Post.class).getResultList();
            return resultList;
        }

    }
}
