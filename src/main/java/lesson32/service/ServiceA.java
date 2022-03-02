package lesson32.service;

import lesson32.event.PrintEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ServiceA {

    private final ApplicationEventPublisher eventBus;

    public void sendEvent(String text) {
        eventBus.publishEvent(new PrintEvent(this, text));
    }
}
