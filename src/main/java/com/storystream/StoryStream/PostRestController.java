package com.storystream.StoryStream;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.net.URI;
import java.util.List;

/**
 * REST controller for Post entity.
 * All endpoints are under /api/posts.
 */
@RestController
@RequestMapping("/api/posts")    // <--- UPDATED LINE
public class PostRestController {

    @Autowired
    private PostService postService;

    @PostMapping
    public ResponseEntity<Post> createPost(@Valid @RequestBody Post post) {
        Post savedPost = postService.savePost(post);
        return ResponseEntity.created(URI.create("/api/posts/" + savedPost.getId())).body(savedPost);
    }

    @GetMapping
    public List<Post> getAllPosts(@RequestParam(value = "term", required = false) String term) {
        return postService.searchPosts(term);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Post> getPostById(@PathVariable Long id) {
        return postService.getPostById(id)
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Post> updatePost(@PathVariable Long id, @Valid @RequestBody Post post) {
        return postService.updatePost(id, post)
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePost(@PathVariable Long id) {
        if (postService.getPostById(id).isPresent()) {
            postService.deletePost(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
