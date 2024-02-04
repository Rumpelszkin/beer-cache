package pl.kolb.cache.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.kolb.cache.data.dto.BeerDto;
import pl.kolb.cache.service.BeerService;

@RestController
@RequestMapping("/beer")
public class BeerRestClient {

    @Autowired
    private BeerService beerService;

    @GetMapping("/{beerId}")
    public BeerDto getBeerById(@PathVariable("beerId") Long id) {
        return beerService.getBeerById(id);
    }
}
