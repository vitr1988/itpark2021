package lesson20.jaxb;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.Marshaller;
import lesson20.dto.Account;
import lesson20.dto.Bank;

import java.io.StringWriter;
import java.math.BigDecimal;

public class XMLWriterRunner {

    public static void main(String[] args) throws Exception {
        //создание объекта Marshaller, который выполняет сериализацию
        JAXBContext context = JAXBContext.newInstance(Account.class);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        // сама сериализация
        Account account = new Account();
        account.setAccountNumber("123");
        account.setBalance(BigDecimal.valueOf(100_000));
        Bank vtb = new Bank();
        vtb.setBic("123");
        vtb.setId(12L);
        vtb.setName("VTB");
        account.setBank(vtb);
        StringWriter stringWriter = new StringWriter();
        marshaller.marshal(account, stringWriter);

        //преобразовываем в строку все записанное в StringWriter
        String result = stringWriter.toString();
        System.out.println(result);
    }
}
