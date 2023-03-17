package com.brvsk.shop.service.interfaces;

import com.brvsk.shop.model.User;

public interface AuthenticationServiceInterface {
    User signInAndReturnJWT(User signInRequest);
}
