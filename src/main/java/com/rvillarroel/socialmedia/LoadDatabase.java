package com.rvillarroel.socialmedia;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.util.BsonUtils;
import org.w3c.dom.ls.LSOutput;
import reactor.core.publisher.Flux;

@Configuration
public class LoadDatabase {

    @Bean
    CommandLineRunner init(ChapterRepository chapterRepository){

        return args -> {
            Flux.just(
                    new Chapter("Reactive web with Spring Boot"),
                    new Chapter("Quick Start with Java"),
                    new Chapter("...and More!")
            ).flatMap(chapterRepository::save)
            .subscribe(System.out::println);
        };
    }
}
