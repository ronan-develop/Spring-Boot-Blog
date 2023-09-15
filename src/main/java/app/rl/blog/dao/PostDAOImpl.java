package app.rl.blog.dao;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.rl.blog.entity.Post;
import app.rl.blog.repository.PostRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Service
public class PostDAOImpl implements PostDAO {

    @Autowired
    public PostRepository postRepository;
    private EntityManager em;

    @Override
    public Post savePost(Post post) {

        return postRepository.save(post);
    }

    @Override
    public List<Post> fetchPostList() {

        return postRepository.findAll();
    }

    @Override
    public void deletePostById(Long id) {

        postRepository.deleteById(id);
    }

    public List<Post> fetchPostsByCategoryId(Long id) {

        TypedQuery<Post> query = em.createQuery(
                "from Post where category.id = :data",
                Post.class);

        query.setParameter("data", id);

        return query.getResultList();
    }

    @Override
    @Transactional
    public Post updatePost(Long id, Post post) {

        // Buffered Object
        Post postDB = postRepository.findById(id).get();

        if (Objects.nonNull(post.getTitle()) &&
                !"".equalsIgnoreCase(post.getTitle())) {

            postDB.setTitle(post.getTitle());
        }

        if (Objects.nonNull(postDB.getContent()) &&
                !"".equalsIgnoreCase(post.getContent())) {

            postDB.setContent(post.getContent());
        }

        if (Objects.nonNull(post.getSlug()) &&
                !"".equalsIgnoreCase(post.getSlug())) {

            postDB.setSlug(post.getSlug());
        }

        postDB.setUpdatedAt(LocalDateTime.now());

        return postRepository.save(postDB);
    }
}
