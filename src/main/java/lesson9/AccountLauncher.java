package lesson9;

import lesson9.implementation.CompanyAccount;
import lesson9.implementation.PersonalAccount;

public class AccountLauncher {

    public static void main(String[] args) {
        Account account = new Account(""){ // анонимный класс
        };
        Account myAccount = new PersonalAccount("Ivanov Vitaly");
        myAccount.activated();
        myAccount.deposit(10_000);
        myAccount.withdraw(1_000);
        myAccount.deposit(5_000);
        System.out.println("Состояние счета: " + myAccount.getBalance());

        Account clientAccount = new PersonalAccount("Арнольд Шварценнегер");
        clientAccount.activated();
        clientAccount.deposit(1_000_000);

        Account companyAccount = new CompanyAccount("IT Park");
        companyAccount.activated();
        companyAccount.deposit(10_000_000);

        Account anotherCompanyAccount = new CompanyAccount("Рога и копыта");
        anotherCompanyAccount.activated();
        anotherCompanyAccount.deposit(10_000);

        Account vtbCompanyAccount = new CompanyAccount("ВТБ");
        vtbCompanyAccount.activated();
        vtbCompanyAccount.deposit(100_000_000);

        System.out.println("Количество открытых расчетных счетов: " + CompanyAccount.COUNT);

        System.out.println(PersonalAccount.getBic());

        System.out.println("Состояние счета в долларах: " + ((CompanyAccount) vtbCompanyAccount).getBalanceInDollars());

        lesson9.example.Account newAccount = new lesson9.example.Account("1233");

        String str = "15455";

    }
}
