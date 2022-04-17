package lesson42.controller.rest;

import com.fasterxml.jackson.databind.ObjectMapper;
import lesson42.dto.GenrePageDto;
import lesson42.service.GenreService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import static org.mockito.Mockito.any;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Collections;

import static org.assertj.core.api.Assertions.anyOf;
import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("REST-контроллер для работы с жанрами книг должен ")
@WebMvcTest(GenreController.class)
public class GenreControllerTest {

    private static final String GENRES_URI = "/api/genres";

    @Autowired
    protected MockMvc mvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private GenreService genreService;

    @MockBean
    private UserDetailsService userDetailsService;

    @BeforeEach
    public void init() {
        Mockito.when(genreService.getPage(any())).thenReturn(
            new GenrePageDto(Collections.emptyList(), -1, -1, true,true, true)
        );
    }

    @WithMockUser(username = "admin", authorities = {"ADMIN"})
    @Test
    @DisplayName("уметь получать список всех жанров")
    public void getGenres() throws Exception {
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(GENRES_URI)
                .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();

        int status = mvcResult.getResponse().getStatus();
        assertThat(status).isEqualTo(200);
    }
}
