package org.example.controller;

import org.example.model.CharFrequencyRequest;
import org.example.service.CharFrequencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api/frequency")
public class CharFrequencyController {
    private final CharFrequencyService service;

    @Autowired
    public CharFrequencyController(CharFrequencyService service) {
        this.service = service;
    }

    @PostMapping
    public Map<Character, Integer> computeFrequency(@RequestBody CharFrequencyRequest request) {
        return service.computeFrequency(request.getString());
    }
}

