package com.utm.tw.config;

import com.utm.tw.dao.ChatterRepository;
import com.utm.tw.entity.Chatter;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Objects;

@AllArgsConstructor
@Service
public class ChatDetailsService implements UserDetailsService {

    private final ChatterRepository chatterRepository;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        Chatter chatter = chatterRepository.findByUsername(s);
        if (!Objects.nonNull(chatter)) {
            throw new UsernameNotFoundException("User not found");
        }
        return new Principal(chatter);
    }
}
