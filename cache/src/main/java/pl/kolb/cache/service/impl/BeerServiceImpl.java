package pl.kolb.cache.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.kolb.cache.data.Beer;
import pl.kolb.cache.data.dto.BeerDto;
import pl.kolb.cache.data.mapper.BeerMapper;
import pl.kolb.cache.repository.BeerRepository;
import pl.kolb.cache.service.BeerService;


@Service
public class BeerServiceImpl implements BeerService {

    @Autowired
    private BeerRepository beerRepository;
    @Autowired
    private BeerMapper beerMapper;

    @Override
    public BeerDto getBeerById(Long id) {
        return beerMapper.mapBeerToBeerDto(beerRepository.findById(id).orElse(new Beer()));
    }
}
