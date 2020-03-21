package com.utm.tw.service;

import com.utm.tw.dao.ChatterRepository;
import com.utm.tw.entity.Chatter;
import com.utm.tw.entity.dto.ChatterFromDBDTO;
import com.utm.tw.entity.dto.RegisterDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ChatterService {

    private final ChatterRepository chatterRepository;
    private final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public void register(RegisterDTO registerDTO) {
        registerDTO.setPassword(passwordEncoder.encode(registerDTO.getPassword()));
        Chatter toBeRegistred = new Chatter(registerDTO);
        chatterRepository.save(toBeRegistred);
    }

    public List<ChatterFromDBDTO> getAllChatters() {
        List<Chatter> chatterList = chatterRepository.findAll();
        List<ChatterFromDBDTO> toBeReturned = new ArrayList<>();
        for (Chatter chatter : chatterList) {
            toBeReturned.add(new ChatterFromDBDTO(chatter));
        }
        return toBeReturned;
    }

}
