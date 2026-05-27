package guru.springframework.spring6coldservice.services;

import guru.springframework.spring7restmvcapi.events.DrinkRequestEvent;

public interface DrinkRequestProcessor {

    void processDrinkRequest(DrinkRequestEvent drinkRequestEvent);
}
