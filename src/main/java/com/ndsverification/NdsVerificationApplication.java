package com.ndsverification;

import com.example.consumingwebservice.wsdl.NdsResponse2;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class NdsVerificationApplication {

    public static void main(String[] args) {
        SpringApplication.run(NdsVerificationApplication.class, args);
    }

    @Bean
    CommandLineRunner lookup(NdsClient quoteClient) {
        return args -> {
            String inn = "555555555555";

            if (args.length > 0) {
                inn = args[0];
            }
            NdsResponse2 response = quoteClient.getNp(inn);
            System.err.println(response.getNP().get(0).getState());
        };
    }
}
