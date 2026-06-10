package com.aws.demo.service;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import org.springframework.stereotype.Service;

import com.aws.demo.dto.CepResponse;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class CepService {

    private final HttpClient client = HttpClient.newHttpClient();
    private final ObjectMapper mapper = new ObjectMapper();

    public CepResponse buscarCep(String cep) {

        try {

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(
                            "https://viacep.com.br/ws/" + cep + "/json/"))
                    .GET()
                    .build();

            HttpResponse<String> response =
                    client.send(request,
                            HttpResponse.BodyHandlers.ofString());

            return mapper.readValue(
                    response.body(),
                    CepResponse.class
            );

        } catch (Exception e) {
            throw new RuntimeException("Erro ao consultar CEP", e);
        }
    }
}