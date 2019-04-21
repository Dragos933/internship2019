package UI;

import Exceptions.ValidatorException;
import Model.Account.Account;
import Model.Account.AccountType;
import Model.Account.AmountInterval;
import Service.ATMService;
import Service.AccountService;
import Service.DistanceService;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

public class Console
{
    private AccountService acc_srv;
    private ATMService atm_srv;
    private DistanceService dst_srv;

    public Console(AccountService acc_srv, ATMService atm_srv, DistanceService dst_srv) {
        this.acc_srv = acc_srv;
        this.atm_srv = atm_srv;
        this.dst_srv = dst_srv;
    }

    private void printStartingMenu()
    {
        System.out.println("\tData loading:");
        System.out.println("0. To exit.");
        System.out.println("1. Use given data. (from site)");
        System.out.println("2. Use other data.");
    }

    private void printGivenDataMenu()
    {
        System.out.println("\tCommands:");
        System.out.println("1. Redistribute money.");
        System.out.println("2. Total amount after 39 months (after redistribution)");
    }

    private void printOtherDataMenu()
    {
        System.out.println("\tCommands:");
        System.out.println("0. To go back.");
        System.out.println("1. CRUD operations on Accounts.");
        System.out.println("2. CRUD operations on ATMs.");
        System.out.println("3. CRUD operations on Distances.");
    }

    private void printAccountsCRUDMenu()
    {
        System.out.println("\tCommands:");
        System.out.println("0. To go back.");
        System.out.println("1. To add a new account.");
        System.out.println("2. To delete an existing account.");
        System.out.println("3. To update an existing account.");
        System.out.println("4. To display the list of all accounts.");
    }

    private void printATMsCRUDMenu()
    {
        System.out.println("\tCommands:");
        System.out.println("0. To go back.");
        System.out.println("1. To add a new ATM.");
        System.out.println("2. To delete an existing ATM.");
        System.out.println("3. To update an existing ATM.");
        System.out.println("4. To display the list of all ATMs.");
    }

    private void printDistancesCRUDMenu()
    {
        System.out.println("\tCommands:");
        System.out.println("0. To go back.");
        System.out.println("1. To add a new distance.");
        System.out.println("2. To delete an existing distance.");
        System.out.println("3. To update an existing distance.");
        System.out.println("4. To display the list of all distance.");
    }

    private void addAccount() throws ValidatorException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Account id: ");
        Integer id = scanner.nextInt();
        System.out.println("Account type: ");
        scanner.nextLine();
        String type = scanner.nextLine();
        AccountType accType;
        if (type.toUpperCase() == "SILVER")
            accType = AccountType.SILVER;
        else if (type.toUpperCase() == "GOLD")
            accType = AccountType.GOLD;
        else if (type.toUpperCase() == "PLATINUM")
            accType = AccountType.PLATINUM;
        else
            accType = null;
        System.out.println("How many Interest Rate - Amount Interval: ");
        int n = scanner.nextInt();
        Map<Double, AmountInterval> rateAmount = new HashMap<Double, AmountInterval>();
        for (int i = 0; i < n; i++)
        {
            System.out.println("\t" + i + ". Interest Rate - Amount Interval: ");
            System.out.println("Rate (%): ");
            double rate = scanner.nextDouble();
            System.out.println("Lower Bound: ");
            int lower = scanner.nextInt();
            System.out.println("Upper Bound: ");
            int upper = scanner.nextInt();
            System.out.println("Type: ");
            int type2 = scanner.nextInt();
            rateAmount.put(rate, new AmountInterval(lower, upper, type2));
        }
        int year,month,day,hh,mm;
        System.out.println("Expiration date: ");
        System.out.println("Year: ");
        year = scanner.nextInt();
        System.out.println("Month: ");
        month = scanner.nextInt();
        System.out.println("Day: ");
        day = scanner.nextInt();
        System.out.println("Hour: ");
        hh = scanner.nextInt();
        System.out.println("Minutes: ");
        mm = scanner.nextInt();
        LocalDateTime date = LocalDateTime.of(year, month, day, hh, mm);
        System.out.println("Available Amount: ");
        int amount = scanner.nextInt();
        Account acc = new Account(id, accType, rateAmount, date, amount);
        this.acc_srv.add(acc);
    }

    private void deleteAccount()
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Give the id: ");
        Integer id = scanner.nextInt();

        try{
            acc_srv.delete(id);
        } catch (ValidatorException e) {
            e.printStackTrace();
        }
    }

    private void updateAccount() throws ValidatorException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Account id: ");
        Integer id = scanner.nextInt();
        System.out.println("Account type: ");
        String type = scanner.nextLine();
        AccountType accType;
        if (type.toUpperCase() == "SILVER")
            accType = AccountType.SILVER;
        else if (type.toUpperCase() == "GOLD")
            accType = AccountType.GOLD;
        else if (type.toUpperCase() == "PLATINUM")
            accType = AccountType.PLATINUM;
        else
            accType = null;
        System.out.println("How many Interest Rate - Amount Interval: ");
        int n = scanner.nextInt();
        Map<Double, AmountInterval> rateAmount = new HashMap<Double, AmountInterval>();
        for (int i = 0; i < n; i++)
        {
            System.out.println("\t" + i + ". Interest Rate - Amount Interval: ");
            System.out.println("Rate (%): ");
            double rate = scanner.nextDouble();
            System.out.println("Lower Bound: ");
            int lower = scanner.nextInt();
            System.out.println("Upper Bound: ");
            int upper = scanner.nextInt();
            System.out.println("Type: ");
            int type2 = scanner.nextInt();
            rateAmount.put(rate, new AmountInterval(lower, upper, type2));
        }
        int year,month,day,hh,mm;
        System.out.println("Expiration date: ");
        System.out.println("Year: ");
        year = scanner.nextInt();
        System.out.println("Month: ");
        month = scanner.nextInt();
        System.out.println("Day: ");
        day = scanner.nextInt();
        System.out.println("Hour: ");
        hh = scanner.nextInt();
        System.out.println("Minutes: ");
        mm = scanner.nextInt();
        LocalDateTime date = LocalDateTime.of(year, month, day, hh, mm);
        System.out.println("Available Amount: ");
        int amount = scanner.nextInt();
        Account acc = new Account(id, accType, rateAmount, date, amount);
        this.acc_srv.update(acc);

    }

    private void displayAccounts()
    {
        Iterator it = this.acc_srv.getAccounts().entrySet().iterator();
        while (it.hasNext())
        {
            Map.Entry pair = (Map.Entry)it.next();
            System.out.println(pair.toString());
            it.remove();
        }

    }

    public void run() throws IOException, ValidatorException {

        Scanner scanner = new Scanner(System.in);

        while( true)
        {
            printStartingMenu();
            System.out.println("Your command: ");
            int command = scanner.nextInt();
            if (command == 2) {
                while (true)
                {
                    printOtherDataMenu();
                    command = scanner.nextInt();
                    if (command == 1)
                    {
                        while (true)
                        {
                            printAccountsCRUDMenu();
                            command = scanner.nextInt();
                            if (command == 1)
                                addAccount();
                            else if (command == 2)
                                deleteAccount();
                            else if (command == 3)
                                updateAccount();
                            else if (command == 4)
                                displayAccounts();
                            else if (command == 0)
                                break;
                            else
                                System.out.println("Invalid command!");
                        }
                    }
                    else if (command == 2)
                    {
                        while (true)
                        {
                            printATMsCRUDMenu();
                        }
                    }
                    else if (command == 3)
                    {
                        while (true)
                        {
                            printDistancesCRUDMenu();
                        }
                    }
                    else if (command == 0)
                        break;
                    else
                        System.out.println("Invalid command!");
                }

            }
            else if (command == 1)
            {
                printGivenDataMenu();
            }
            else if (command == 0)
                break;
            else
                System.out.println("Invalid option!");
        }
    }
}
