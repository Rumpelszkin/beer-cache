package pl.kolb.cache.service;

import pl.kolb.cache.data.dto.BeerDto;


public interface BeerService {
    BeerDto getBeerById(Long id) throws InterruptedException;
}
