package pl.kolb.cache.service.cache.impl;

import org.springframework.data.util.Pair;
import org.springframework.stereotype.Component;
import pl.kolb.cache.data.dto.BeerDto;
import pl.kolb.cache.service.cache.BeerCache;
import pl.kolb.cache.service.cache.FrequencyBeerListItem;

import java.util.*;
import java.util.stream.Collectors;

@Component
public class BeerCacheImpl implements BeerCache {

    private List<Pair<FrequencyBeerListItem,Long>> frequencyList;
    private final Map<Long, BeerDto> cache;
    private final int maxSize = 10;

    public BeerCacheImpl(){
        this.frequencyList = new LinkedList<>();
        this.cache = new HashMap<>();
    }

    @Override
    public BeerDto getItem(Long key) {
        if(!this.cache.containsKey(key)) {
            return null;
        }
        FrequencyBeerListItem frequencyBeerListItem = this.frequencyList.stream()
                .filter(cacheItemFrequency -> key.equals(cacheItemFrequency.getSecond()))
                .findFirst()
                .get()
                .getFirst();
        frequencyBeerListItem.increment();
        return this.cache.get(key);
    }

    @Override
    public void putItem(Long key, BeerDto value) {
        if(frequencyList.size() == this.maxSize) {
            evacuate();
        }
        this.cache.put(key, value);
        this.frequencyList.add(0, Pair.of(new FrequencyBeerListItem(value), key));
    }

    @Override
    public void printCache() {
        System.out.println("============LFU============");
        this.cache.forEach((key, value) -> {
            System.out.printf("Key: %s, Val: %s%n", key, value);
        });
    }

    private void evacuate() {
        this.frequencyList = this.frequencyList.stream()
                .sorted(Comparator.comparingInt(o -> o.getFirst().getFrequency()))
                .collect(Collectors.toList());
        this.cache.remove(this.frequencyList.get(0).getSecond());
        this.frequencyList.remove(0);
    }
}
