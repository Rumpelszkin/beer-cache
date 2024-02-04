package pl.kolb.cache.data.mapper;

import org.springframework.stereotype.Component;
import pl.kolb.cache.data.Beer;
import pl.kolb.cache.data.dto.BeerDto;


public interface BeerMapper {

    BeerDto mapBeerToBeerDto(Beer beer);
    Beer mapBeerDtoToBeer(BeerDto beerDto);
}
