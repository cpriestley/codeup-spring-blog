package com.code.codeupspringblog.services;

import com.code.codeupspringblog.models.Post;
import com.code.codeupspringblog.models.User;

public interface EmailService {
    void prepareAndSend(Post post, String subject, String body);
    void sendWelcomeEmail(User user, String subject, String body);
}
