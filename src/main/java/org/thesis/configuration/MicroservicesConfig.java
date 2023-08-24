package org.thesis.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MicroservicesConfig {

    @Value("${cart.port}")
    private String cartPort;
    @Value("${users.port}")
    private String usersPort;
    @Value("${order.port}")
    private String orderPort;
    @Value("${items.port}")
    private String itemsPort;
    private final static String hostBaseUrl = "http://localhost:";
    private final static String apiPostfix = "/api/v1";

    @Bean
    public String cartServiceUrl() {
        return buildUrl(cartPort, "/cart");
    }
    @Bean
    public String usersServiceUrl() {
        return buildUrl(usersPort, "/users");
    }
    @Bean
    public String orderServiceUrl() {
        return buildUrl(orderPort, "/order");
    }
    @Bean
    public String itemsServiceUrl() {
        return buildUrl(itemsPort, "/items");
    }

    private String buildUrl(String port, String serviceName) {
        return hostBaseUrl + port + apiPostfix + serviceName;
    }
}




