//package lesson29.shell;
//
//import lesson29.dao.DepartmentDao;
//import lesson29.dao.EmployeeDao;
//import lesson29.model.Department;
//import lesson29.service.LocalizationService;
//import lombok.RequiredArgsConstructor;
//import lombok.extern.slf4j.Slf4j;
//import org.slf4j.Logger;
//import org.springframework.shell.Availability;
//import org.springframework.shell.standard.ShellComponent;
//import org.springframework.shell.standard.ShellMethod;
//import org.springframework.shell.standard.ShellMethodAvailability;
//import org.springframework.shell.standard.ShellOption;
//
//@Slf4j
//@ShellComponent
//@RequiredArgsConstructor
//public class UserInteraction {
//
////    private static final Logger log = org.slf4j.LoggerFactory.getLogger(UserInteraction.class);
//
//    private final LocalizationService localizationService;
//    private final DepartmentDao departmentDao;
//    private final EmployeeDao employeeDao;
//    private String username;
//
//    @ShellMethod(value = "Greeting of user", key = {"greet", "hello", "g", "h"})
//    public String greeting(@ShellOption({"-n, --name"}) String name) {
//        this.username = name;
//        return localizationService.localize("greeting", name);
//    }
//
//    @ShellMethod(value = "Execute command", key = {"exec", "e"})
//    @ShellMethodAvailability("isAvailable")
//    public void command(@ShellOption({"-p, --param", "--parameter"}) Long parameter) {
//        log.trace("TRACE");
//        log.debug("DEBUG");
//        log.info("Try to execute command with parameter {}", parameter);
//        log.warn("WARN");
//        log.error("ERROR");
//    }
//
//    @ShellMethod(value = "Create department", key = {"c", "cd"})
//    @ShellMethodAvailability("isAvailable")
//    public void department(
//            @ShellOption({"-i", "--id"}) Integer departmentId,
//            @ShellOption({"-n", "--name"}) String departmentName) {
//        log.info("Department was created with id = {}", departmentDao.create(new Department(departmentId, departmentName)));
//    }
//
//    @ShellMethod(value = "Find employee", key = {"f", "fe"})
//    @ShellMethodAvailability("isAvailable")
//    public void employee() {
//        log.info("List of employees {}", employeeDao.findAll());
//    }
//
//    private Availability isAvailable() {
//        return username == null
//                ? Availability.unavailable(localizationService.localize("error.logonFailed"))
//                : Availability.available();
//    }
//
//}
//
