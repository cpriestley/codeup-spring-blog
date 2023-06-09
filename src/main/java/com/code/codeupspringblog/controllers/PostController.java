package com.code.codeupspringblog.controllers;

import com.code.codeupspringblog.models.Post;
import com.code.codeupspringblog.models.User;
import com.code.codeupspringblog.repositories.PostRepository;
import com.code.codeupspringblog.repositories.UserRepository;
import com.code.codeupspringblog.services.EmailService;
import lombok.AllArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@AllArgsConstructor
public class PostController {
    PostRepository postRepo;
    UserRepository userRepo;
    EmailService emailService;
    @GetMapping("/posts")
    public String index(Model model) {
        List<Post> posts = new ArrayList<>(postRepo.getAll());
        model.addAttribute( "posts", posts);
        return "/posts/index";
    }
    @GetMapping("/posts/{slug}")
    public String getPostBySlug(@PathVariable String slug, Model model) {
        model.addAttribute("post", postRepo.getPostBySlug(slug));
        return "/posts/show";
    }
//    @GetMapping("/posts/{id}")
//    public String getPostById(@PathVariable long id, Model model) {
//        model.addAttribute("post", postRepo.getPostById(id));
//        return "/posts/show";
//    }
    @GetMapping("/posts/{id}/delete")
    public String deletePost(@PathVariable long id) {
        Post post = postRepo.getPostById(id);
        postRepo.delete(post);
        return "redirect:/posts";
    }
    @GetMapping("/posts/{id}/edit")
    public String editPost(@PathVariable long id, Model model) {
        return showEditOrCreateView(model, postRepo.getPostById(id));
    }
    @GetMapping("/posts/create")
    public String startPost(Model model) {
        return showEditOrCreateView(model, new Post());
    }
    @PostMapping("/posts/create")
    public String createPost(@ModelAttribute Post post) {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        post.setUser(userRepo.findById(user.getId()));
        postRepo.save(post);
        emailService.prepareAndSend(
                post,
                "Post Created [%s]".formatted(post.getTitle()),
                "Your post has been created"
        );
        return "redirect:/posts";
    }
    private String showEditOrCreateView(Model model, Post post) {
        model.addAttribute("post", post);
        return "posts/create";
    }
}
