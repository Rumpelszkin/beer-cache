package pl.kolb.cache.data.mapper.impl;

import org.springframework.stereotype.Component;
import pl.kolb.cache.data.Beer;
import pl.kolb.cache.data.dto.BeerDto;
import pl.kolb.cache.data.mapper.BeerMapper;

@Component
public class BeerMapperImpl implements BeerMapper {

    @Override
    public BeerDto mapBeerToBeerDto(Beer beer) {
        return null;
    }

    @Override
    public Beer mapBeerDtoToBeer(BeerDto beerDto) {
        return null;
    }
}
