package lesson37.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SecurityController {

    @GetMapping("/api/secured")
    public String secured() {
        return "test";
    }
}
