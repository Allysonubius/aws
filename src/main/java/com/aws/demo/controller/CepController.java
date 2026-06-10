package com.aws.demo.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import com.aws.demo.dto.CepResponse;
import com.aws.demo.service.CepService;

@RestController
@RequestMapping("/api/cep")
@RequiredArgsConstructor
public class CepController {

    private final CepService cepService;

    @GetMapping("/{cep}")
    public CepResponse buscar(@PathVariable String cep) {
        return cepService.buscarCep(cep);
    }
}