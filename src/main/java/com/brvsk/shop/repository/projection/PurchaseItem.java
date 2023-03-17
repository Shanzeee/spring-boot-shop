package com.brvsk.shop.repository.projection;

import java.time.LocalDateTime;

public interface PurchaseItem {

    String getName();
    String getPrice();
    LocalDateTime getPurchaseTime();
}
