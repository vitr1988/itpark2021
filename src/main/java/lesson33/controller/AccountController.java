package lesson33.controller;

import lesson33.dto.AccountDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Random;

@RestController
@RequestMapping("/api/accounts")
@RequiredArgsConstructor
public class AccountController {

    @GetMapping
    public List<AccountDto> accounts() {
        return List.of();
    }

    @GetMapping({"/{id}", "/by-id/{id}"})
    public AccountDto getById(@PathVariable Integer id, @RequestHeader("Accept-encoding") String encoding) {
        return new AccountDto();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public AccountDto createAccount(@RequestBody AccountDto accountDto) {
        if (new Random().nextBoolean()) {
            throw new IllegalArgumentException();
        }
        return new AccountDto();
    }

    @PutMapping
    public AccountDto updateAccount(@RequestBody AccountDto accountDto) {
        return new AccountDto();
    }

    @PatchMapping
    public AccountDto updatePartialAccount(@RequestBody AccountDto accountDto) {
        return new AccountDto();
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void deleteAccount(@PathVariable Integer id) {

    }
}
