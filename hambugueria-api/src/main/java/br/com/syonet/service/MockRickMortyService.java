package br.com.syonet.service;

import io.quarkus.arc.DefaultBean;
import jakarta.enterprise.context.ApplicationScoped;

@DefaultBean
@ApplicationScoped
public class MockRickMortyService extends RickMortyService {


    @Override
    public String getAll() {
        return "Ok Ok Ok";
    }

}
