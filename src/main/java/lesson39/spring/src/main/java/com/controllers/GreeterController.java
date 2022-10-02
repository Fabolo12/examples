package com.controllers;

import com.models.Greeter;
import com.repositories.GreeterRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.awt.print.Book;
import java.util.List;

@RestController
@RequestMapping("/greeter")
public class GreeterController {
    private final GreeterRepository greeterRepository;

    public GreeterController(GreeterRepository greeterRepository) {
        this.greeterRepository = greeterRepository;
    }


    @GetMapping
    public Iterable<Greeter> findAll() {
        return greeterRepository.findAll();
    }

    @GetMapping("/target/{target}")
    public List<Greeter> findByTarget(@PathVariable String target) {
        return greeterRepository.findByTarget(target);
    }

    @GetMapping("/{id}")
    public Greeter findOne(@PathVariable String id) {
        return greeterRepository.findById(id).orElseThrow(IllegalArgumentException::new);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Greeter create(@RequestBody Greeter greeter) {
        if (greeter.getGreeting() == null) {
            greeter.setGreeting("Hello");
        }
        return greeterRepository.save(greeter);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        greeterRepository.findById(id).orElseThrow(IllegalArgumentException::new);
        greeterRepository.deleteById(id);
    }

    @PutMapping
    public Greeter updateGreeter(@RequestBody Greeter greeter) {
        if (greeter.getIdentifier() == null) {
            throw new IllegalArgumentException();
        }
        greeterRepository.findById(greeter.getIdentifier()).orElseThrow(IllegalArgumentException::new);
        return greeterRepository.save(greeter);
    }
}
