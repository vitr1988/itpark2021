package lesson20.json;

import com.fasterxml.jackson.databind.ObjectMapper;
import lesson20.dto.Account;
import lesson20.dto.Bank;

import java.io.File;
import java.math.BigDecimal;

public class JacksonWriter {

    public static void main(String[] args) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        Account account = createAccount();
        // Java objects to JSON file
        mapper.writeValue(new File("c:\\test\\account.json"), account);

        // Java objects to JSON string - compact-print
        String jsonString = mapper.writeValueAsString(account);

        System.out.println(jsonString);

        // Java objects to JSON string - pretty-print
        String jsonInString2 = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(account);

        System.out.println(jsonInString2);
    }

    private static Account createAccount() {
        Account account = new Account();
        account.setAccountNumber("5453");
        account.setBalance(BigDecimal.ZERO);
        Bank bank = new Bank();
        bank.setId(1L);
        bank.setBic("65656");
        bank.setName("ПСБ");
        account.setBank(bank);
        return account;
    }
}
