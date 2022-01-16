package lesson20.csv;

import com.opencsv.CSVReader;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.bean.HeaderColumnNameMappingStrategy;
import lesson20.dto.Account;

import java.io.BufferedReader;
import java.io.FileReader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class OpenCsvReader {

    public static void main(String[] args) throws Exception {
        String fileName = "src/main/resources/data.csv";

        Path myPath = Paths.get(fileName);

        try (BufferedReader br = Files.newBufferedReader(myPath, StandardCharsets.UTF_8)) {
//            HeaderColumnNameMappingStrategy<Account> strategy = new HeaderColumnNameMappingStrategy<>();
//            strategy.setType(Account.class);

            CsvToBean<Account> csvToBean = new CsvToBeanBuilder<Account>(br)
                    .withMappingStrategy(new AccountMappingStrategy())
                    .withIgnoreLeadingWhiteSpace(true)
                    .withSkipLines(1)
//                    .withType(Account.class)
                    .withSeparator(';')
                    .build();

            List<Account> accounts = csvToBean.parse();
            accounts.forEach(System.out::println);
        }

    }
}
