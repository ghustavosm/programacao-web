package br.edu.uepb.coffee.controller;

import java.util.List;
import java.util.Optional;

import br.edu.uepb.coffee.domain.Coffee;
import br.edu.uepb.coffee.repository.CoffeeRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/coffees")
public class CoffeeController {

    @Autowired
    private CoffeeRepository coffeeRepository;

    @GetMapping
    public List<Coffee> getCoffees() {
        return coffeeRepository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Coffee> getCoffeeById(@PathVariable Long id) {
        return coffeeRepository.findById(id);
    }

    @PostMapping
    public Coffee createCoffee(@RequestBody Coffee coffee) {
        return coffeeRepository.save(coffee);
    }

    @PutMapping("/{id}")
    public Coffee updateCoffee(@PathVariable("id") Long id, @RequestBody Coffee coffee) {
        return coffeeRepository.save(coffee);
    }

    @DeleteMapping("/{id}")
    public void deleteCoffee(@PathVariable Long id) {
        coffeeRepository.delete(coffeeRepository.findById(id).get());
    }
}