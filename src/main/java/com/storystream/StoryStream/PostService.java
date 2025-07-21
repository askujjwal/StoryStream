package com.storystream.StoryStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

/**
 * Service layer for managing blog posts.
 */
@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;

    public Post savePost(Post post) {
        return postRepository.save(post);
    }

    public Optional<Post> updatePost(Long id, Post postData) {
        return postRepository.findById(id).map(existingPost -> {
            existingPost.setTitle(postData.getTitle());
            existingPost.setContent(postData.getContent());
            existingPost.setCategory(postData.getCategory());
            existingPost.setTags(postData.getTags());
            // updatedAt handled by @PreUpdate in Post
            return postRepository.save(existingPost);
        });
    }

    public List<Post> getAllPosts() {
        return postRepository.findAll();
    }

    public Optional<Post> getPostById(Long id) {
        return postRepository.findById(id);
    }

    public void deletePost(Long id) {
        postRepository.deleteById(id);
    }

    public List<Post> searchPosts(String term) {
        if (term == null || term.trim().isEmpty()) {
            return postRepository.findAll();
        }
        return postRepository.findByTitleContainingIgnoreCaseOrContentContainingIgnoreCaseOrCategoryContainingIgnoreCase(term, term, term);
    }
}
