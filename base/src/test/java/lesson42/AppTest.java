package lesson42;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@DisplayName("Приложение должно уметь ")
public class AppTest {

    @Test
    @DisplayName("загружать свой контекст")
    public void contextLoads() {
    }
}
