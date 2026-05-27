package guru.springframework.spring6coldservice.services;

import guru.springframework.spring7restmvcapi.events.DrinkRequestEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class DrinkRequestProcessorImpl implements DrinkRequestProcessor {

    @Override
    public void processDrinkRequest(DrinkRequestEvent drinkRequestEvent) {

        log.debug("Processing drink request...");

        try{
            Thread.sleep(50);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
