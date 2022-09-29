package com.example.springbootapp.database;

import com.example.springbootapp.controller.AdminController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

//@Configuration
public class Insert {

    private AdminController adminController;

    @Autowired
    JdbcTemplate template;

    //@Bean
    CommandLineRunner createDatabase() {

        return new CommandLineRunner() {
            @Override
            public void run(String... args) throws Exception {
                template.execute("INSERT INTO HELLO (leanguage, helloWorld) VALUES ('English', 'Hello World')");
                template.execute("INSERT INTO HELLO (leanguage, helloWorld) VALUES ('French', 'Bonjour le monde')");
                template.execute("INSERT INTO HELLO (leanguage, helloWorld) VALUES ('Spanish', 'Hola Mundo')");
                template.execute("INSERT INTO HELLO (leanguage, helloWorld) VALUES ('Italian', 'Ciao mondo')");
                template.execute("INSERT INTO HELLO (leanguage, helloWorld) VALUES ('Russian', 'Привет, мир')");
                template.execute("INSERT INTO HELLO (leanguage, helloWorld) VALUES ('Srpski', 'Zdravo Svete')");
                template.execute("INSERT INTO HELLO (leanguage, helloWorld) VALUES ('Japanese', 'こんにちは世界')");
                template.execute("INSERT INTO HELLO (leanguage, helloWorld) VALUES ('Greek', 'Γειά σου Κόσμε')");
                template.execute("INSERT INTO HELLO (leanguage, helloWorld) VALUES ('Indian', 'नमस्ते दुनिया')");
                template.execute("INSERT INTO HELLO (leanguage, helloWorld) VALUES ('Mandarin', '你好世界')");
            }
        };
    }

}
