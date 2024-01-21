package com.pegien.HighSchoolExamination.Configurations;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;



@Configuration
public class SwaggerConfig {


    @Value("${server.address}")
    private String serverAddr;

    @Value("${server.port}")
    private String serverPort;


    @Bean
    public OpenAPI openAPI()
    {


        Server localserver=new Server();
        localserver.setUrl(serverAddr+":"+serverPort);


        Info info=new Info();

        info.setTitle("High School Examination App");
        info.setDescription("High School Examination App");

        Contact pato=new Contact()
                .name("Patrick")
                        .email("ngupatgi@gmail.com")
                                .url("https://pegien.co.ke");

        info.setContact(pato);





        return new OpenAPI().info(info).servers(Arrays.asList(new Server[]{localserver}));
    }


}
