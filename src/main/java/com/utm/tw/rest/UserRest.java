package com.utm.tw.rest;

import com.utm.tw.entity.dto.ChatterFromDBDTO;
import com.utm.tw.entity.dto.RegisterDTO;
import com.utm.tw.service.ChatterService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserRest {

    private final ChatterService chatterService;

    @GetMapping("/all")
    public List<ChatterFromDBDTO> getAll(){
        return chatterService.getAllChatters();
    }

    @PostMapping("/register")
    public ResponseEntity<Object> register(@RequestBody RegisterDTO registerDTO) {
        try {
            chatterService.register(registerDTO);
            return new ResponseEntity<>("All good, you have been registred", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Bad request, you could not be registered", HttpStatus.BAD_REQUEST);
        }
    }
}
