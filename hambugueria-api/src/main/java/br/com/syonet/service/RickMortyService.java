package br.com.syonet.service;

import org.eclipse.microprofile.rest.client.inject.RestClient;

import br.com.syonet.client.RickAndMortyClient;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class RickMortyService {

    @Inject
    @RestClient
    RickAndMortyClient client;

    public String getAll() {
        return client.getAll();
    }
}
