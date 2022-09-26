package com.example.auto.service;

import com.example.auto.model.Auto;
import com.example.auto.repository.AutoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@AllArgsConstructor
public class AutoService {
   public final AutoRepository autoRepository;
    public List<Auto> getAll() {
        return autoRepository.findAll();
    }

    public Auto getById(Long id) {
        return autoRepository.findById(id).orElseThrow();
    }

    public void createAuto(Auto auto) {
        Auto newAuto = Auto.builder()
                .brand(auto.getBrand())
                .model(auto.getModel())
                .colour(auto.getColour())
                .build();
        autoRepository.save(newAuto);
    }

    public Auto autoUpdate (Long id, Auto auto) {
        Auto oldOne = getById(id);
        Auto newAuto = Auto.builder()
                .id(id)
                .brand(auto.getBrand())
                .model(auto.getModel())
                .colour(auto.getColour())
                .build();
        return autoRepository.save(newAuto);
    }
    public void delete(Long id) {
        getById(id);
        autoRepository.deleteById(id);
    }
}
