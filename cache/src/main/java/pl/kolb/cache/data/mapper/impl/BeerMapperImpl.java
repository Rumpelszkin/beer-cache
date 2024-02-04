package pl.kolb.cache.data.mapper.impl;

import org.springframework.stereotype.Component;
import pl.kolb.cache.data.Beer;
import pl.kolb.cache.data.dto.BeerDto;
import pl.kolb.cache.data.mapper.BeerMapper;

@Component
public class BeerMapperImpl implements BeerMapper {

    @Override
    public BeerDto mapBeerToBeerDto(Beer beer) {
        return new BeerDto(beer.getId(), beer.getName(), beer.getDescription());
    }

    @Override
    public Beer mapBeerDtoToBeer(BeerDto beerDto) {
        return new Beer(beerDto.getId(), beerDto.getName(), beerDto.getDescription());
    }
}
