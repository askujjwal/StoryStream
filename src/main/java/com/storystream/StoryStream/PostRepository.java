package com.storystream.StoryStream;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

/**
 * JPA repository for Post entities.
 * Supports search by title, content, or category.
 */
@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
    List<Post> findByTitleContainingIgnoreCaseOrContentContainingIgnoreCaseOrCategoryContainingIgnoreCase(
        String title, String content, String category
    );
}
