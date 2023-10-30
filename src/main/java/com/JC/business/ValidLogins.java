package com.JC.business;

import javax.validation.Valid;

import com.JC.model.LoginModel;

public class ValidLogins implements SecurityServiceInterface {

    @Override
    public boolean isAuthenticated(@Valid LoginModel loginModel) {
        
        String[][] validLogins = new String[][] {
            {"Jac", "123"}
        };

        // Check to see if login matches valid logins
        boolean success = false;

        for (int i = 0; i < validLogins.length; i++)
        {
            if(loginModel.getUsername().equals(validLogins[i][0]) && loginModel.getPassword().equals(validLogins[i][1]))
            {
                success = true;
            }
        }

        if(success)
        {
            // Successful login
            return true;
        }
        else
        {
            // Failed login
            return false;
        }
    }
    
}
