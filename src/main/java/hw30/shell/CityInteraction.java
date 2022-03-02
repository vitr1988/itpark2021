//package hw30.shell;
//
//import hw30.model.City;
//import hw30.service.CityService;
//import lombok.RequiredArgsConstructor;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.shell.standard.ShellComponent;
//import org.springframework.shell.standard.ShellMethod;
//import org.springframework.shell.standard.ShellOption;
//
//@Slf4j
//@ShellComponent
//@RequiredArgsConstructor
//public class CityInteraction {
//
//    private final CityService cityService;
//
////    cc -c 77 -n Москва -ne Moscow -p 11170700
//    @ShellMethod(value = "Create city", key = "cc")
//    public void createCity(
//            @ShellOption({"-c", "--code"}) Integer cityCode,
//            @ShellOption({"-n", "--name"}) String cityName,
//            @ShellOption({"-ne", "--nameEn"}) String cityNameEn,
//            @ShellOption(value = {"-p", "--pop"}, defaultValue = ShellOption.NULL) Long population) {
//        final City city = new City(cityCode, cityName, cityNameEn);
//        city.setPopulation(population);
//        cityService.save(city);
//        log.debug("Успешно создан город {}", city);
//    }
//
////    uc -c 63 -n Самара -ne Samara -p 1170700
//    @ShellMethod(value = "Update city", key = "uc")
//    public void updateCity(
//            @ShellOption({"-c", "--code"}) Integer cityCode,
//            @ShellOption({"-n", "--name"}) String cityName,
//            @ShellOption({"-ne", "--nameEn"}) String cityNameEn,
//            @ShellOption(value = {"-p", "--pop"}, defaultValue = ShellOption.NULL) Long population) {
//        cityService.findByCode(cityCode).ifPresent(city -> {
//            city.setName(cityName);
//            city.setNameEn(cityNameEn);
//            if (population != null) {
//                city.setPopulation(population);
//            }
//            cityService.save(city);
//            log.debug("Успешно обновлен город {}", city);
//        });
//    }
//
//    @ShellMethod(value = "Delete city", key = "dc")
//    public void deleteCity(
//            @ShellOption({"-c", "--code"}) Integer cityCode) {
//        cityService.deleteByCode(cityCode);
//        log.debug("Успешно удален город с кодом {}", cityCode);
//    }
//
//    @ShellMethod(value = "Find city", key = "fc")
//    public void findCity(
//            @ShellOption({"-c", "--code"}) Integer cityCode) {
//        cityService.findByCode(cityCode).ifPresentOrElse(
//                city -> log.info("Найденный город {}", city),
//                () -> log.warn("Город с кодом {} не найден в БД", cityCode)
//        );
//    }
//}
