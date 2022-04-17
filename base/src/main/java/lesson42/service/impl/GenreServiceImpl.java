package lesson42.service.impl;

import lesson42.dto.GenreDto;
import lesson42.dto.GenrePageDto;
import lesson42.mapper.GenreMapper;
import lesson42.model.Genre;
import lesson42.repository.GenreRepository;
import lesson42.service.GenreService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class GenreServiceImpl implements GenreService {

    private final GenreRepository genreRepository;
    private final GenreMapper genreMapper;

    @Override
    @Transactional(readOnly = true)
    public List<GenreDto> findAll() {
        return genreMapper.toDtos(genreRepository.findAll());
    }

    @Override
    public GenrePageDto getPage(Pageable pageable) {
        Page<Genre> currentPage = genreRepository.findAll(pageable);
        return new GenrePageDto(genreMapper.toDtos(currentPage.getContent()),
                currentPage.getNumber(),
                currentPage.getTotalPages(),
                currentPage.hasNext(),
                currentPage.hasPrevious(),
                SecurityContextHolder.getContext().getAuthentication()
                        .getAuthorities()
                        .stream()
                        .anyMatch(grantedAuthority -> grantedAuthority.getAuthority().equals("ROLE_ADMIN")));
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<GenreDto> getByCode(@NotEmpty String genreCode) {
        return genreMapper.toOptionalDto(genreRepository.findById(genreCode));
    }

    @Override
    @Transactional
    public GenreDto save(@Valid GenreDto genre) {
        return genreMapper.toDto(genreRepository.save(genreMapper.toEntity(genre)));
    }

    @Override
    @Transactional
    public void deleteByCode(@NotEmpty String genreCode) {
        genreRepository.deleteById(genreCode);
    }
}

