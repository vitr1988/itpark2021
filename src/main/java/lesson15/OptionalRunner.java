package lesson15;

import java.util.Optional;

public class OptionalRunner {

    public static void main(String[] args) {
        System.out.println(getCode(null));
    }

//    public static Integer getCode(String str) {
//        Optional<String> stringOptional = Optional.ofNullable(str);
//        return stringOptional.isPresent() ? Integer.decode(stringOptional.get()) : null;
//    }
    public static Integer getCode(String str) {
        return Optional.ofNullable(str).map(Integer::decode).orElse(-1);
    }
}
