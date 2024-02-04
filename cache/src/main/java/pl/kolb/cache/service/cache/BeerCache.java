package pl.kolb.cache.service.cache;

import pl.kolb.cache.data.dto.BeerDto;

public interface BeerCache {

    BeerDto getItem(Long key);
    void putItem(Long key, BeerDto value);
    void printCache();

}
