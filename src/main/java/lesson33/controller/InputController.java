package lesson33.controller;

import lesson33.dto.ResultDto;
import lesson33.service.CalculatorService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Objects;

@RestController
@RequiredArgsConstructor
@RequestMapping("/calculator")
public class InputController {

    @Value("${spring.application.name}")
    private String application;

    private final CalculatorService calculatorService;

    private final HttpServletRequest request;

//    @RequestMapping(value = "/summa", method = RequestMethod.POST)
    @PostMapping("/summa")
    public ResponseEntity<ResultDto> summa(
            HttpServletRequest request, HttpServletResponse response,
            @RequestParam(value = "arg1", required = false, defaultValue = "0") Integer a,
            @RequestParam("arg2") Integer b,
            @CookieValue(value = "cookieAttribute", required = false) String cookieAttribute) {
        request.getSession().setAttribute("sessionAttribute", "125");
        if (a > 100) {
//            return ResponseEntity.internalServerError().build();
            return ResponseEntity
//                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .internalServerError()
                    .body(new ResultDto(application, -1));
        }
        return ResponseEntity.ok(new ResultDto(application, calculatorService.summa(a, b)));
    }

    @GetMapping("/summa/{arg1}/{arg2}")
    public Integer getSumma(@PathVariable/*("arg1")*/ Integer arg1, @PathVariable/*("arg1")*/ Integer arg2) {
        final String sessionAttribute = Objects.toString(request.getSession().getAttribute("sessionAttribute"), null);
        return calculatorService.summa(arg1, arg2);
    }
}
