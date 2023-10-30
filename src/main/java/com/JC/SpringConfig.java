package com.JC;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import com.JC.business.HousesBusinessService;
import com.JC.business.SecurityServiceInterface;
import com.JC.business.ValidLogins;

@Configuration
public class SpringConfig {

    @Bean
    @Primary
    public HousesBusinessService myHousesBusinessService() {
        return new HousesBusinessService();
    }
    
    
    @Bean(name="securityService")
    public SecurityServiceInterface getSecurityService() 
    {
        return new ValidLogins();
    }
}
