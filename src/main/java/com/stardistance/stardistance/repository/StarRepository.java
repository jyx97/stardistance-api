package com.stardistance.stardistance.repository;

import com.stardistance.stardistance.model.Star;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface StarRepository extends JpaRepository<Star, Long> {
    Optional<Star> findByName(String name);

}
