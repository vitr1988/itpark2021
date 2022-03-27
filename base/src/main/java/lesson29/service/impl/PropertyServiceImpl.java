package lesson29.service.impl;

import lesson29.config.ApplicationProperties;
import lesson29.config.SpringProperties;
import lesson29.service.PropertyService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PropertyServiceImpl implements PropertyService {

    private final SpringProperties springProperties;
    private final ApplicationProperties applicationProperties;

    @Override
    public void printProperties() {
        System.out.println("Application name : " + springProperties.getName());
        System.out.println("Application title and banner : " + springProperties.getTitleAndBanner());
        System.out.println("Application locale : " + applicationProperties.getSetting().getLocale());
        System.out.println("Application lines : " + applicationProperties.getSetting().getLines());
    }
}
