package com.library.book_manager.actuator;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.actuate.info.Info;
import org.springframework.boot.actuate.info.InfoContributor;
import org.springframework.stereotype.Component;

import java.util.Map;

/**********************************************
 Developer Name: Vikas
 Created on: 17-07-2026 18:19
 Project Name: book-manager ${
 /**********************************************/
@Component
public class AppInfoContributor implements InfoContributor
{

    @Value("${info.app.name}")
    private String name;

    @Value("${info.app.version}")
    private String version;

    @Override
    public void contribute(Info.Builder builder)
    {
        builder.withDetail("app", Map.of("name", name,
                "version", version));
    }

}
