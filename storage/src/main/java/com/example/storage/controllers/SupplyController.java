package com.example.storage.controllers;


import com.example.storage.models.Supply;
import com.example.storage.services.SupplyService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/supplies")
public class SupplyController {

    private final SupplyService supplyService;

    @GetMapping("/{id}")
    Supply getSupplyById(@PathVariable Long id){
        return supplyService.getSupplyById(id);
    }

    @PostMapping
    Supply createSupply(@RequestBody Supply supply){
        return supplyService.createSupply(supply);
    }

    @PutMapping
    Supply updateSupply(@RequestBody Supply supply){
        return supplyService.updateSupply(supply);
    }
    @DeleteMapping("/{id}")
    void deleteSupplyById(@PathVariable Long id){
        supplyService.deleteSupplyById(id);
    }

    @GetMapping("/{name}/count")
    Integer getCountFreeSupply(@PathVariable String name){
        return supplyService.getCountFreeSupply(name);
    }

    @GetMapping("/{name}/firstFree")
    Supply getFirstFreeSuppliesByName(@PathVariable String name){
        return supplyService.getFirstFreeSuppliesByName(name);
    }

}
