package com.code.codeupspringblog.controllers;

import com.code.codeupspringblog.models.Post;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class PostController {

    private final String BODY_1 = "Lorem ipsum dolor sit amet, consectetur adipisicing elit. A minus neque quam! Architecto blanditiis ea fuga magnam minima possimus repellendus, sint temporibus. Consectetur eius eligendi est, in laborum nihil quam qui quo vel veritatis! Animi aut consectetur consequatur cumque dignissimos dolore enim expedita iusto magni, molestias natus pariatur perferendis quasi ratione, unde voluptates voluptatum! Ab aspernatur corporis fuga impedit libero minus molestiae molestias necessitatibus quia rem sapiente, tempora, veniam. Asperiores aspernatur at autem consequatur dolor facilis maxime qui, quos suscipit velit. Illum possimus quae voluptatem. A ab aliquam asperiores dolore dolorum enim expedita impedit mollitia odio omnis, praesentium veritatis voluptatum?";

    @GetMapping("/posts")
    public String index(Model model) {
        final String BODY_2 = "Lorem ipsum dolor sit amet, consectetur adipisicing elit. Accusamus animi assumenda at consequuntur cum cupiditate distinctio doloribus, eos et excepturi fuga fugit hic ipsum laboriosam maxime nam nemo nisi nostrum odio odit omnis pariatur recusandae repellat reprehenderit totam voluptate voluptates? Accusamus amet in natus similique? A, consequatur ducimus error, eveniet libero, maxime pariatur placeat quasi totam ut velit voluptate. Dolore earum fuga ipsam modi porro. Ad assumenda, consectetur consequatur cupiditate, deserunt illo magni optio pariatur placeat provident quaerat quam quod, rem repudiandae sunt velit voluptates. Deleniti fugit iusto libero minus ratione sapiente sunt ut. Asperiores atque doloremque qui repudiandae totam.";
        final String BODY_3 = "Lorem ipsum dolor sit amet, consectetur adipisicing elit. Asperiores aspernatur at distinctio doloremque omnis, sapiente sint sunt ullam voluptate? Ab, alias aliquid animi commodi dolor error est, eum ex harum incidunt molestiae nam omnis porro quas sapiente soluta veniam. Aliquid, amet blanditiis, culpa doloremque, impedit libero modi nemo numquam officiis perferendis quisquam sapiente tempora unde veniam voluptates? Architecto beatae consequatur cumque cupiditate incidunt iste obcaecati reprehenderit sunt, voluptatem? Accusamus asperiores, blanditiis dolorum earum enim eos fugiat iusto molestias necessitatibus nulla, officiis quidem recusandae reiciendis sunt temporibus! Ad aperiam consequatur, expedita impedit inventore laboriosam perspiciatis, possimus, quae rerum unde ut voluptatibus.";
        List<Post> posts = List.of(
                Post.builder().id(1L).title("Title 1").body(BODY_1).build(),
                Post.builder().id(2L).title("Title 2").body(BODY_2).build(),
                Post.builder().id(3L).title("Title 3").body(BODY_3).build());
        model.addAttribute("posts", posts);
        return "posts/index";
    }
    @GetMapping("/posts/{id}")
    public String getPost(@PathVariable long id, Model model) {
        model.addAttribute("post",
                Post.builder()
                        .id(1L)
                        .title("Title 1")
                        .body(BODY_1)
                        .build());
        return "posts/show";
    }
    @GetMapping("/posts/create")
    @ResponseBody
    public String startPost() {
        return "view the form for creating a post";
    }
    @PostMapping("/posts/create")
    @ResponseBody
    public String createPost() {
        return "create a new post";
    }
}
