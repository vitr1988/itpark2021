//package lesson29.config;
//
//import lesson29.service.LocalizationService;
//import lombok.SneakyThrows;
//import org.jline.utils.AttributedString;
//import org.springframework.boot.context.properties.EnableConfigurationProperties;
//import org.springframework.context.MessageSource;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.support.ReloadableResourceBundleMessageSource;
//import org.springframework.shell.jline.PromptProvider;
//
//import java.nio.charset.StandardCharsets;
//import java.util.ResourceBundle;
//
//@Configuration
//@EnableConfigurationProperties//({ApplicationProperties.class, SpringProperties.class})
//public class AppConfig {
//
////    @Bean
////    public ResourceBundle resourceBundle(ApplicationProperties applicationProperties) {
////        return ResourceBundle.getBundle("messages", applicationProperties.getSetting().getLocale());
////    }
//
////    @Bean
////    public MessageSource messageSource() {
////        ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
////        messageSource.setDefaultEncoding(StandardCharsets.UTF_8.name());
////        messageSource.setBasename("messages");
////        return messageSource;
////    }
//
//    /**
//     * Parametrized prompter for Spring shell
//     */
//    @Bean
//    @SneakyThrows
//    public PromptProvider promptProvider(LocalizationService localizationService) {
//        return () -> new AttributedString(localizationService.localize("intro"));
//    }
//}
