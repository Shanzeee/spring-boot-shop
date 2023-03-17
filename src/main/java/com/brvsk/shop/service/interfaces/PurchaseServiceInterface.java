package com.brvsk.shop.service.interfaces;

import com.brvsk.shop.model.Purchase;
import com.brvsk.shop.repository.projection.PurchaseItem;

import java.util.List;

public interface PurchaseServiceInterface {
    Purchase savePurchase(Purchase purchase);

    List<PurchaseItem> findPurchaseItemsOfUser(Long userid);
}
