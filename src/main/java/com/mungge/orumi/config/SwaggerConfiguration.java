package com.mungge.orumi.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


import java.util.ArrayList;
import java.util.List;

@Configuration
public class SwaggerConfiguration {

    @Bean
    public OpenAPI apiV1() {
        return new OpenAPI()
                .info(new Info()
                        .title("오늘의 구름 API")
                        .description("구름톤 Univ. 1기 2023 단풍톤 14팀 뭉게")
                        .version("1.0.0"));
    }
}
