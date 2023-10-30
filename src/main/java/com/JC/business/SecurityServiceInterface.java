package com.JC.business;

import javax.validation.Valid;

import com.JC.model.LoginModel;

public interface SecurityServiceInterface {

    boolean isAuthenticated(@Valid LoginModel loginModel);
    
}
