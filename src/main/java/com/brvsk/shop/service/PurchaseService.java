package com.brvsk.shop.service;

import com.brvsk.shop.model.Purchase;
import com.brvsk.shop.repository.PurchaseRepository;
import com.brvsk.shop.repository.projection.PurchaseItem;
import com.brvsk.shop.service.interfaces.PurchaseServiceInterface;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@AllArgsConstructor

public class PurchaseService implements PurchaseServiceInterface {

    private final PurchaseRepository purchaseRepository;

    @Override
    public Purchase savePurchase(Purchase purchase){
        purchase.setPurchaseTime(LocalDateTime.now());

        return purchaseRepository.save(purchase);
    }

    @Override
    public List<PurchaseItem> findPurchaseItemsOfUser(Long userId){

        return purchaseRepository.findAllPurchasesOfUser(userId);
    }
}
