package tech.itpark.controller;

import tech.itpark.dto.ClientDto;
import tech.itpark.service.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class ClientController {

    private final ClientService clientService;

    @GetMapping("/create")
    public Long createClient(@RequestParam String name) {
        return clientService.createClient(name);
    }

    @GetMapping("/get")
    public List<ClientDto> findAll() {
        return clientService.findAll();
    }

    @GetMapping("/get/{id}")
    public Optional<ClientDto> findById(@PathVariable Long id) {
        return clientService.findById(id);
    }

    @GetMapping("/delete/{id}")
    public void delete(@PathVariable Long id) {
        clientService.deleteById(id);
    }

    @GetMapping("/update/{id}")
    public void update(@PathVariable Long id, @RequestParam String name) {
        clientService.update(id, name);
    }
}
