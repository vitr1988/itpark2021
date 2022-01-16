package lesson20.jaxb;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.Unmarshaller;
import lesson20.dto.Account;

import java.io.StringReader;

public class XMLReaderRunner {

    public static void main(String[] args) throws Exception {
        String xmldata =
                """
                        <account>
                        <accountNumber>123</accountNumber>
                        <balance>100000</balance>
                        <bank id="12" bic="123">
                            <name>VTB</name>
                        </bank>
                    </account>
                """;
        StringReader reader = new StringReader(xmldata);

        JAXBContext context = JAXBContext.newInstance(Account.class);
        Unmarshaller unmarshaller = context.createUnmarshaller();

        Account account = (Account) unmarshaller.unmarshal(reader);
        System.out.println(account);
    }
}
