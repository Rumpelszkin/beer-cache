package pl.kolb.cache.service;

import org.springframework.stereotype.Service;
import pl.kolb.cache.data.dto.BeerDto;


public interface BeerService {
    BeerDto getBeerById(Long id);
}
