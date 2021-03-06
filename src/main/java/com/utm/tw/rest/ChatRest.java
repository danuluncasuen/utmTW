package com.utm.tw.rest;

import com.utm.tw.entity.dto.AddPostDTO;
import com.utm.tw.service.ChatService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/chat")
@AllArgsConstructor
public class ChatRest {

    private final ChatService chatService;

    @GetMapping("/all")
    public ResponseEntity<Object> getChat() {
        try {
            String username;
            Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            if (principal instanceof UserDetails) {
                username = ((UserDetails)principal).getUsername();
            } else {
                username = principal.toString();
            }
            return new ResponseEntity<>(chatService.getChat(username), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Could not load the chat", HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/submit")
    public ResponseEntity<Object> submit(@RequestBody AddPostDTO addPostDTO, Authentication authentication) {
        try {
            chatService.submit(addPostDTO, authentication.getName());
            return new ResponseEntity<>("All good, post submitted", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Could submit a new post", HttpStatus.BAD_REQUEST);
        }
    }

}
