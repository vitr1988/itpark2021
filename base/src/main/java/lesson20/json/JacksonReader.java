package lesson20.json;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lesson20.dto.Account;

import java.io.File;
import java.lang.reflect.Type;
import java.util.List;

public class JacksonReader {

    public static void main(String[] args) throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        // JSON file to Java object
//        Account[] accounts = objectMapper.readValue(new File("c:\\test\\account.json"), Account[].class);
//        List<Account> accounts = objectMapper.readValue(new File("c:\\test\\account.json"), new TypeReference<>() {
//
//        });
        Account account = objectMapper.readValue(new File("c:\\test\\account.json"), new TypeReference<>() {
        });
        // compact print
        System.out.println(account);
        // pretty print
        String prettyAccount = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(account);
        System.out.println(prettyAccount);
    }
}
