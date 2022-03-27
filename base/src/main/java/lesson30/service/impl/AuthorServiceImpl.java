package lesson30.service.impl;

import lesson30.model.Author;
import lesson30.repository.AuthorRepository;
import lesson30.service.AuthorService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepository authorRepository;

    @Override
    public void save(Author author) {
        authorRepository.save(author);
    }
}
