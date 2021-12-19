package lesson15;

import lesson15.dto.Account;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

public class MethodReferenceRunner {
    public static void main(String[] args) {
//        Function<String, Integer> str2Int = str -> Integer.decode(str);
        Function<String, Integer> str2Int = Integer::decode;

//        Function<Long, Long> self2self = val -> val;
        Function<Long, Long> self2self = Function.identity();

//        Supplier<Account> accountGenerator = () -> new Account();
        Supplier<Account> accountGenerator = Account::new;

        Consumer<String> printStr = System.out::println;

        System.out.println(str2Int.apply("1"));
        Function<Character, Integer> char2Int = ch -> (int) ch;
        System.out.println(char2Int.apply(' '));
    }
}
