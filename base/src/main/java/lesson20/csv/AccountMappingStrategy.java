package lesson20.csv;

import com.opencsv.bean.ColumnPositionMappingStrategy;
import com.opencsv.exceptions.CsvBeanIntrospectionException;
import com.opencsv.exceptions.CsvConstraintViolationException;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;
import com.opencsv.exceptions.CsvValidationException;
import lesson18.dto.Person;
import lesson20.dto.Account;
import lesson20.dto.Bank;

import java.math.BigDecimal;

public class AccountMappingStrategy extends ColumnPositionMappingStrategy {

    public AccountMappingStrategy() {
        this.setType(Account.class);
    }

    @Override
    public Object populateNewBean(String[] line) throws CsvBeanIntrospectionException, CsvRequiredFieldEmptyException,
            CsvDataTypeMismatchException, CsvConstraintViolationException, CsvValidationException {
        Account account = new Account();
        account.setAccountNumber(line[0]);
        account.setBalance(new BigDecimal(line[1]));
        account.setBank(new Bank());
        account.getBank().setId(Long.valueOf(line[2]));
        account.getBank().setName(line[3]);
        account.getBank().setBic(line[4]);
        return account;
    }
}
