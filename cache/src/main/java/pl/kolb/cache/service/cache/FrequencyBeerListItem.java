package pl.kolb.cache.service.cache;

import pl.kolb.cache.data.dto.BeerDto;

public class FrequencyBeerListItem {
    private final BeerDto beerDto;
    private int frequency;

    public FrequencyBeerListItem(BeerDto beerDto) {
        this.beerDto = beerDto;
        frequency = 1;
    }

    public int getFrequency() {
        return frequency;
    }

    public void increment() {
        this.frequency++;
    }
}
