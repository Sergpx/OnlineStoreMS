package com.example.storage.services.Impl;

import com.example.storage.models.Supply;
import com.example.storage.repositories.SupplyRepository;
import com.example.storage.services.SupplyService;
import jakarta.ws.rs.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SupplyServiceImpl implements SupplyService {

    private final SupplyRepository supplyRepository;

    @Override
    public Supply getSupplyById(Long id) {
        return supplyRepository.findById(id).orElseThrow(()->new NotFoundException("supply not found"));
    }

    @Override
    public Supply createSupply(Supply supply) {
        return supplyRepository.save(supply);
    }

    @Override
    public Supply updateSupply(Supply supply) {
        System.out.println(supply.getId());
        Supply owner = getSupplyById(supply.getId());
        if (supply.getName() != null) owner.setName(supply.getName());
        owner.setUsername(supply.getUsername());
        return supplyRepository.save(owner);
    }

    @Override
    public void deleteSupplyById(Long id) {
        supplyRepository.deleteById(id);
    }

    @Override
    public Integer getCountFreeSupply(String name) {
        return supplyRepository.countAllByNameAndUsernameIsNull(name);
    }

    @Override
    public Supply getFirstFreeSuppliesByName(String name) {
        return supplyRepository.getFirstByNameAndUsernameIsNull(name);
    }
}
