package com.example.storage.services;

import com.example.storage.models.Supply;

public interface SupplyService {

    Supply getSupplyById(Long id);
    Supply createSupply(Supply supply);

    Supply updateSupply(Supply supply);

    void deleteSupplyById(Long id);

    Integer getCountFreeSupply(String name);

    Supply getFirstFreeSuppliesByName(String name);



}
