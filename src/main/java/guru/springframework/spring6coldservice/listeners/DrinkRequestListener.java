package guru.springframework.spring6coldservice.listeners;

import guru.springframework.spring6coldservice.config.KafkaConfig;
import guru.springframework.spring6coldservice.services.DrinkRequestProcessor;
import guru.springframework.spring7restmvcapi.events.DrinkPreparedEvent;
import guru.springframework.spring7restmvcapi.events.DrinkRequestEvent;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Slf4j
@RequiredArgsConstructor
@Component
public class DrinkRequestListener {

    private final DrinkRequestProcessor drinkRequestProcessor;
    private final KafkaTemplate<String, Object> kafkaTemplate;

    @KafkaListener(groupId = "ColdListener", topics = KafkaConfig.DRINK_REQUEST_COLD_TOPIC)
    public void listenDrinkRequest(DrinkRequestEvent event) {
        log.debug("I an listening - drink request");

        drinkRequestProcessor.processDrinkRequest(event);

        kafkaTemplate.send(KafkaConfig.DRINK_PREPARED_TOPIC, DrinkPreparedEvent.builder()
                .beerOrderLineDTO(event.getBeerOrderLineDTO())
                .build());

    }
}
