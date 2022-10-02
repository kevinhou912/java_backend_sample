package levvel.io.controller;

import levvel.io.model.Blog;
import levvel.io.model.Comment;
import levvel.io.service.BlogService;
import lombok.AllArgsConstructor;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/blog")
public class BlogController {

    private BlogService blogService;

    @PostMapping("/post")
    public ResponseEntity<Blog> addBlog(@RequestBody Blog blog) {
        blogService.addBlog(blog);
        return ResponseEntity.ok().body(blog);
    }

    @GetMapping("/post/{id}")
    public ResponseEntity<Blog> getBlog(@PathVariable String id) {
        Blog blog = blogService.getBlog(id);
        return ResponseEntity.ok().body(blog);
    }

    @PostMapping("/post/{id}/comment")
    public ResponseEntity<Blog> addComment(@RequestBody Comment comment, @PathVariable String id) {

        blogService.addComment(id, comment);
        Blog blog = blogService.getBlog(id);
        return ResponseEntity.ok().body(blog);
    }

    @GetMapping("/post/{id}/comment")
    public ResponseEntity<List<Comment>> getComment(@PathVariable String id) {
        Blog blog = blogService.getBlog(id);
        List<Comment> comments = blog.getComment();
        return ResponseEntity.ok().body(comments);
    }
  
}
