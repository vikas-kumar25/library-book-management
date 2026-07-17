package com.library.book_manager.actuator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.health.contributor.Health;
import org.springframework.boot.health.contributor.HealthIndicator;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

/**********************************************
 Developer Name: Vikas
 Created on: 17-07-2026 14:03
 Project Name: book-manager ${
 /**********************************************/
@Component
public class ExternalApiCustomHealthCheck implements HealthIndicator
{
    @Autowired
    private RestTemplate restTemplate;

    @Override
    public Health health()
    {
        String url = "http://localhost:8081/health/ping";

        try
        {
            String response = restTemplate.getForObject(url, String.class);

            if (response.equals("Pong"))
            {
                return Health.up()
                        .withDetail("url", url)
                        .withDetail("Response", response)
                        .build();
            } else
            {
                return Health.down()
                        .withDetail("url", url)
                        .withDetail("Response", response)
                        .build();
            }

        } catch (Exception e)
        {
            return Health.down()
                    .withDetail("Reason", "Exception Occurred")
                    .build();
        }

    }
}
