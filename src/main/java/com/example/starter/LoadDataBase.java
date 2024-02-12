package com.example.starter;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LoadDataBase {
    private static final Logger Log = (Logger) LoggerFactory.getLogger(LoadDataBase.class);

    @Bean
    CommandLineRunner initDataBase(EmployeeRepository repository) {
        return args ->{
            Log.info("Preloading" + repository.save(new Employee("Abhinay","Student")));
            Log.info("Preloading" + repository.save(new Employee("Abhinay","Student")));
        };
    }
}

