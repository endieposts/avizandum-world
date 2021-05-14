package com.endie.avizandum.world.security;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.env.Environment;
import org.springframework.test.context.ActiveProfiles;

import javax.annotation.PostConstruct;

import static org.junit.Assert.assertEquals;

@ActiveProfiles("test")
@SpringBootTest
public class VaultTest {
    @Autowired
    Environment env;

    //@Value("${spring.profiles.active:test}")
    //private String profiles;

    @Value("${config.spring.datasource.integrationtestvalue}")
    private String testValue = "test";

    @Test
    public void whenGenericBackendEnabled_thenEnvHasAccessToVaultSecrets() {
        //System.out.println("profiles: " + profiles);
        System.out.println("testValue: " + testValue);
    }

}
