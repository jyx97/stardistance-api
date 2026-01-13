package com.stardistance.stardistance.service;

import com.stardistance.stardistance.dto.DistanceResponseDTO;
import com.stardistance.stardistance.dto.StarRequestDTO;
import com.stardistance.stardistance.dto.StarResponseDTO;
import com.stardistance.stardistance.model.Star;
import com.stardistance.stardistance.repository.StarRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StarService {

    private final StarRepository starRepository;

    public StarService(StarRepository starRepository ){
        this.starRepository = starRepository;
    }

    public StarResponseDTO createStar(StarRequestDTO dto){
    Star star = new Star();
    star.setName(dto.getName());
    star.setX(dto.getX());
    star.setY(dto.getY());
    star.setZ(dto.getZ());

    Star saved = starRepository.save(star);

    return toResponseDTO(saved);
    }

    public List<StarResponseDTO> getAllStars(){
        return starRepository.findAll()
                .stream()
                .map(this::toResponseDTO)
                .collect(Collectors.toList());
    }

    public DistanceResponseDTO calculateDistance(String fromStar, String toStar){
        Star starA = starRepository.findByName(fromStar)
                .orElseThrow(() -> new RuntimeException("Estrela:" + fromStar+ " não encontrada"));
        Star starB = starRepository.findByName(toStar)
                .orElseThrow(() -> new RuntimeException("Estrela:" + toStar+ " não encontrada"));

        double dx = starB.getX() - starA.getX();
        double dy = starB.getY() - starA.getY();
        double dz = starB.getZ() - starA.getZ();

        double distance = Math.sqrt(dx*dx + dy*dy + dz*dz );

        return new DistanceResponseDTO(starA.getName(), starB.getName(), distance);
    }

    private StarResponseDTO toResponseDTO(Star star){
            return new StarResponseDTO(
                    star.getId(),
                    star.getName(),
                    star.getX(),
                    star.getY(),
                    star.getZ()
            );

    }
}
