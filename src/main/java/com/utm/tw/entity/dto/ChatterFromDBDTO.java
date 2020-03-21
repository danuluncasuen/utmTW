package com.utm.tw.entity.dto;

import com.utm.tw.entity.Chatter;
import lombok.Data;

@Data
public class ChatterFromDBDTO {
    private String username;
    private String email;

    public ChatterFromDBDTO(Chatter chatter) {
        this.username = chatter.getUsername();
        this.email = chatter.getEmail();
    }
}
