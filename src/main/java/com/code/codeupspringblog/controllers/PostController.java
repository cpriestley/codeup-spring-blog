package com.code.codeupspringblog.controllers;

import com.code.codeupspringblog.models.Post;
import com.code.codeupspringblog.repositories.PostRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class PostController {
    PostRepository postRepo;
    PostController(PostRepository postRepo) {
        this.postRepo = postRepo;
    }
    @GetMapping("/posts")
    public String index(Model model) {
        List<Post> posts = new ArrayList<>(postRepo.getAll());
        model.addAttribute( "posts", posts);
        return "posts/index";
    }
    @GetMapping("/posts/{id}")
    public String getPost(@PathVariable long id, Model model) {
        model.addAttribute("post", postRepo.getPostById(id));
        return "posts/show";
    }
    @GetMapping("/posts/create")
    public String startPost(Model model) {
        model.addAttribute("post", new Post());
        return "posts/create";
    }
    @PostMapping("/posts/create")
    public String createPost(@ModelAttribute Post post) {
        postRepo.save(post);
        return "redirect:/posts";
    }
}
