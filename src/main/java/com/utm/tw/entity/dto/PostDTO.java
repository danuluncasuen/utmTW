package com.utm.tw.entity.dto;

import com.utm.tw.entity.Post;
import lombok.Data;

@Data
public class PostDTO {
    public String title;
    public String content;
    public String author;

    public PostDTO(Post post) {
        this.title = post.getTitle();
        this.content = post.getMessage();
        this.author = post.getAuthor().getUsername();
    }
}
