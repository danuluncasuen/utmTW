package com.utm.tw.dao;

import com.utm.tw.entity.Chatter;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChatterRepository extends JpaRepository<Chatter, Long> {
    Chatter findByUsername(String username);
}
