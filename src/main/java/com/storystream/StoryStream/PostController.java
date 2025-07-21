package com.storystream.StoryStream;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;

/**
 * MVC Controller for Thymeleaf blog UI.
 */
@Controller
@RequestMapping("/posts")
public class PostController {

    @Autowired
    private PostService postService;

    @GetMapping
    public String viewPostList(Model model) {
        List<Post> posts = postService.getAllPosts();
        model.addAttribute("posts", posts);
        return "post-list";
    }

    @GetMapping("/new")
    public String showCreateForm(Model model) {
        model.addAttribute("post", new Post());
        return "post-form";
    }

    @PostMapping
    public String createPost(@Valid @ModelAttribute("post") Post post) {
        postService.savePost(post);
        return "redirect:/posts";
    }

    @GetMapping("/{id}/edit")
    public String showEditForm(@PathVariable Long id, Model model) {
        Post post = postService.getPostById(id)
            .orElseThrow(() -> new IllegalArgumentException("Invalid post Id:" + id));
        model.addAttribute("post", post);
        return "post-form";
    }

    @PostMapping("/{id}")
    public String updatePost(@PathVariable Long id, @Valid @ModelAttribute("post") Post post) {
        postService.updatePost(id, post);
        return "redirect:/posts";
    }

    @GetMapping("/{id}/delete")
    public String deletePost(@PathVariable Long id) {
        postService.deletePost(id);
        return "redirect:/posts";
    }

    @GetMapping("/{id}/view")
    public String viewSinglePost(@PathVariable Long id, Model model) {
        Post post = postService.getPostById(id)
            .orElseThrow(() -> new IllegalArgumentException("Invalid post Id:" + id));
        model.addAttribute("post", post);
        return "post-view";
    }
}
