package com.example.example4sem6_rikky_and_morty_rest.service;

import com.example.example4sem6_rikky_and_morty_rest.domain.Characters;
import com.example.example4sem6_rikky_and_morty_rest.domain.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;


@Service
public class ServiceApiImpl implements ServiceApi{
    private static final Logger logger = LoggerFactory.getLogger(ServiceApiImpl.class);

    @Autowired
    private RestTemplate template;

    @Autowired
    private HttpHeaders headers;

    @Value("${rickandmortyapi.url}")
    private String CHARACTER_API;
    @Override
    public Characters getAllCharacters() {
        headers.setAccept(List.of(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<>(headers);
        ResponseEntity<Characters> response = template.exchange(CHARACTER_API, HttpMethod.GET,entity, Characters.class);
        logger.info("Response from API: {}", response.getBody());
        return response.getBody();
    }


    @Override
    public Result getCharacter(Integer id) {
        String characterApi = CHARACTER_API + "/" + id;
        headers.setAccept(List.of(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<>(headers);
        ResponseEntity<Result> response = template.exchange(characterApi, HttpMethod.GET, entity, Result.class);
        logger.info("Response from API: {}", response.getBody());
        return response.getBody();
    }

}


