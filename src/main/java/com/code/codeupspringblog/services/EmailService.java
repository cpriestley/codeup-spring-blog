package com.code.codeupspringblog.services;

import com.code.codeupspringblog.models.Post;

public interface EmailService {
    void prepareAndSend(Post post, String subject, String body);
}
