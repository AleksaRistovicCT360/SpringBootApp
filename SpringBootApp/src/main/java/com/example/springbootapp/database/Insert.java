package com.example.springbootapp.database;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

@Configuration
public class Insert {

    @Autowired
    JdbcTemplate template;

    @Bean
    CommandLineRunner createDatabase() {

        return new CommandLineRunner() {
            @Override
            public void run(String... args) throws Exception {
                template.execute("INSERT INTO HELLO VALUES (1,'English', 'Hello World')");
                template.execute("INSERT INTO HELLO VALUES (2, 'French', 'Bonjour le monde')");
                template.execute("INSERT INTO HELLO VALUES (3, 'Spanish', 'Hola Mundo')");
                template.execute("INSERT INTO HELLO VALUES (4, 'Italian', 'Ciao mondo')");
                template.execute("INSERT INTO HELLO VALUES (5, 'Russian', 'Привет, мир')");
                template.execute("INSERT INTO HELLO VALUES (6, 'Srpski', 'Zdravo Svete')");
                template.execute("INSERT INTO HELLO VALUES (7, 'Japanese', 'こんにちは世界')");
                template.execute("INSERT INTO HELLO VALUES (8, 'Greek', 'Γειά σου Κόσμε')");
                template.execute("INSERT INTO HELLO VALUES (9, 'Indian', 'नमस्ते दुनिया')");
                template.execute("INSERT INTO HELLO VALUES (10, 'Mandarin', '你好世界')");
            }
        };
    }

}
