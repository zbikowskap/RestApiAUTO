package com.example.auto.controller;

import com.example.auto.model.Auto;
import com.example.auto.service.AutoService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping(path = "/cars") // ścieżka zawsze wliczbie mnogiej
public class AutoController {
    private final AutoService autoService;

   /* @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Auto> getAllCars() {
        return autoService.getAll();
    }*/

    @GetMapping("/{id}")
    public Auto getAutoByID(@PathVariable Long id) {
        return autoService.getById(id);
    }

    @GetMapping
    public List<Auto> getAutoByColour(@RequestParam String colour) {
        return autoService.autoRepository.findByColourName(colour);
    }
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void addAuto(@RequestBody Auto auto) {
        autoService.createAuto(auto);

    }
    @PutMapping("/{id}")
    public Auto updateAuto(@PathVariable Long id,
                           @RequestBody Auto auto) {
        return autoService.autoUpdate(id, auto);
    }
   /* @PatchMapping("/{id}") // todo wybrane pole
    public Auto selectedUpdateAuto(@PathVariable Long id,
                           @RequestBody Auto auto) {
        return autoService.autoUpdate(id, auto);
    }*/
    @DeleteMapping("/{id}")
    public void deleteById (@PathVariable Long id) {
        autoService.delete(id);

    }



}
