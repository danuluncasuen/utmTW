package com.utm.tw.service;

import com.utm.tw.dao.ChatRepository;
import com.utm.tw.dao.ChatterRepository;
import com.utm.tw.entity.Post;
import com.utm.tw.entity.dto.AddPostDTO;
import com.utm.tw.entity.dto.PostDTO;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class ChatService {

    private final ChatRepository chatRepository;
    private final ChatterRepository chatterRepository;

    public List<PostDTO> getChat(String username) {
        List<Post> posts = chatRepository.findAll();
        List<PostDTO> toBeReturned = new ArrayList<>();
        for (Post post : posts) {
            PostDTO currentPost = new PostDTO(post);
            if (post.getAuthor().getUsername().equals(username)) {
                currentPost.setCurrent(true);
            }
            toBeReturned.add(currentPost);
        }
        return toBeReturned;
    }

    public void submit(AddPostDTO addPostDTO, String username) {
        if (!addPostDTO.getContent().isEmpty() && !addPostDTO.getTitle().isEmpty()) {
            Post toBeSaved = new Post();
            toBeSaved.setMessage(addPostDTO.getContent());
            toBeSaved.setTitle(addPostDTO.getTitle());
            toBeSaved.setAuthor(chatterRepository.findByUsername(username));
            chatRepository.save(toBeSaved);
        }
    }

}
