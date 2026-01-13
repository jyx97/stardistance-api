package com.stardistance.stardistance.controller;

import com.stardistance.stardistance.dto.DistanceResponseDTO;
import com.stardistance.stardistance.dto.StarRequestDTO;
import com.stardistance.stardistance.dto.StarResponseDTO;
import com.stardistance.stardistance.model.Star;
import com.stardistance.stardistance.service.StarService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/stars")
@RequiredArgsConstructor
public class StarController {

    private final StarService starService;

    @PostMapping
    public StarResponseDTO createStar(@RequestBody StarRequestDTO dto){
        return starService.createStar(dto);
    }

    @GetMapping
    public List<StarResponseDTO> getAllStars(){
        return starService.getAllStars();
    }

    @GetMapping("/distance")
    public DistanceResponseDTO getDistance(
            @RequestParam String fromStar,
            @RequestParam String toStar
    ){
        return starService.calculateDistance(fromStar, toStar);
    }

}
