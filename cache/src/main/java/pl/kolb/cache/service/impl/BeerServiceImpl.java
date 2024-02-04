package pl.kolb.cache.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.kolb.cache.data.dto.BeerDto;
import pl.kolb.cache.data.mapper.BeerMapper;
import pl.kolb.cache.repository.BeerRepository;
import pl.kolb.cache.service.BeerService;
import pl.kolb.cache.service.cache.BeerCache;



@Service
public class BeerServiceImpl implements BeerService {

    public static final String VALUE_FROM_GAINED_FROM_CACHE = "Value from gained from cache";
    public static final String VALUE_ADDED_TO_CACHE = "Value added to cache";
    Logger log = LoggerFactory.getLogger(BeerServiceImpl.class);
    @Autowired
    private BeerRepository beerRepository;
    @Autowired
    private BeerMapper beerMapper;
    @Autowired
    private BeerCache beerCache;

    @Override
    public BeerDto getBeerById(Long id) throws InterruptedException {
        var cachedBeer = beerCache.getItem(id);
        if(cachedBeer != null) {
            log.info(VALUE_FROM_GAINED_FROM_CACHE, cachedBeer);
            return cachedBeer;
        } else {
            var beerDto =  beerMapper.mapBeerToBeerDto(
                    beerRepository.findById(id)
                            .orElse(null)
            );
            Thread.sleep(2000);
            if(beerDto == null) return null;
            beerCache.putItem(id,beerDto);
            log.info(VALUE_ADDED_TO_CACHE, beerDto);
            return beerDto;
        }
    }
}
