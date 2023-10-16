package com.santos.hexagonal.config;

import com.santos.hexagonal.adapters.out.FindAddressByZipCodeAdapter;
import com.santos.hexagonal.adapters.out.InsertCustomerAdapter;
import com.santos.hexagonal.adapters.out.SendCpfValidationAdapter;
import com.santos.hexagonal.application.core.usecase.InsertCustomerUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class InsertCustomerConfig {

    @Bean
    public InsertCustomerUseCase insertCustomerUseCase(
            FindAddressByZipCodeAdapter findAddressByZipCodeAdapter,
            InsertCustomerAdapter insertCustomerAdapter,
            SendCpfValidationAdapter sendCpfValidationAdapter
    ) {
        return new InsertCustomerUseCase(findAddressByZipCodeAdapter, insertCustomerAdapter, sendCpfValidationAdapter);
    }
}
