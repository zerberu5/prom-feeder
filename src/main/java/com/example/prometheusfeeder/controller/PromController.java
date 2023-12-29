package com.example.prometheusfeeder.controller;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@RestController
@RequestMapping("/api")
@Slf4j
@OpenAPIDefinition(info = @Info(title = "Promfeeder", description = "Feeds prometheus with data"))
public class PromController {

    private List<Integer> values;

    @GetMapping("/prom")
    public ResponseEntity<String> triggerProm() {
        log.info("New Request!");
        List<Integer> values = new ArrayList<>();

        Random rand = new Random();

        int randomNum = rand.nextInt((100 - 1) + 1) + 1;

        if (randomNum < 50) {
            log.warn("random num {} smaller than 50", randomNum);
        } else {
            log.error("random num {} bigger than 50", randomNum);
        }

        for (int i = 0; i < randomNum; i++) {
            values.add(i);
        }

        log.info("List has been created with {} elements.", values.size());
        return ResponseEntity.ok("Achso Elements in list " + values.size());
    }
}
