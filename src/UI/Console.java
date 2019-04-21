package UI;

import Exceptions.ValidatorException;
import Model.Account.Account;
import Model.Account.AccountType;
import Model.Account.AmountInterval;
import Service.AccountService;
import javafx.util.Pair;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.*;

public class Console
{
    private AccountService acc_srv;

    public Console(AccountService acc_srv) {
        this.acc_srv = acc_srv;
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
        System.out.println("0. To go back.");
        System.out.println("1. Redistribute money.");
        System.out.println("2. Total amount after 39 months.");
        System.out.println("3. To print all accounts.");
    }

    private void printOtherDataMenu()
    {
        System.out.println("\tCommands:");
        System.out.println("0. To go back.");
        System.out.println("1. CRUD operations on Accounts.");
        System.out.println("2. Distribute the money");
        System.out.println("3. Total amount after 39 months.");
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

    private void addAccount() throws ValidatorException {
        System.out.println("\n\tAdding an account");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Account id: ");
        Integer id = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Account type: ");
        String type = scanner.nextLine();
        AccountType accType;
        if (type.toUpperCase().equals("SILVER"))
            accType = AccountType.SILVER;
        else if (type.toUpperCase().equals("GOLD"))
            accType = AccountType.GOLD;
        else if (type.toUpperCase().equals("PLATINUM"))
            accType = AccountType.PLATINUM;
        else
            accType = null;
        System.out.println("How many Interest Rate - Amount Interval: ");
        int n = scanner.nextInt();
        Map<Double, AmountInterval> rateAmount = new HashMap<Double, AmountInterval>();
        for (int i = 0; i < n; i++)
        {
            System.out.println("\t" + (i + 1) + ". Interest Rate - Amount Interval: ");
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
        System.out.println("\n\tDeleting an account");
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
        System.out.println("\n\tUpdating an account");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Account id: ");
        Integer id = scanner.nextInt();
        scanner.nextLine();
        System.out.println(acc_srv.find((Integer)id));
        if (acc_srv.find((Integer) id) != null)
        {
            Account acc = acc_srv.find((Integer) id);
            System.out.println("Account type: ");
            String type = scanner.nextLine();
            AccountType accType;
            if (type.toUpperCase().equals("SILVER"))
                accType = AccountType.SILVER;
            else if (type.toUpperCase().equals("GOLD"))
                accType = AccountType.GOLD;
            else if (type.toUpperCase().equals("PLATINUM"))
                accType = AccountType.PLATINUM;
            else
                accType = null;
            acc.setType(accType);
            System.out.println("How many Interest Rate - Amount Interval: ");
            int n = scanner.nextInt();
            Map<Double, AmountInterval> rateAmount = new HashMap<Double, AmountInterval>();
            for (int i = 0; i < n; i++)
            {
                System.out.println("\t" + (i + 1) + ". Interest Rate - Amount Interval: ");
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
            acc.setRateToAmount(rateAmount);
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
            acc.setExp_date(date);
            System.out.println("Available Amount: ");
            int amount = scanner.nextInt();
            acc.setAmount(amount);

            acc_srv.update(acc);
        }
    }

    private void displayAccounts()
    {
        System.out.println("\n\tDisplaying all accounts");
        Iterator it = this.acc_srv.getAccounts().entrySet().iterator();
        while (it.hasNext())
        {
            Map.Entry pair = (Map.Entry)it.next();
            System.out.println(pair.toString());
            it.remove();
        }
    }

    private long sumOfAccounts(List<Account> accounts)
    {
        long sum = 0;
        for (Account el : accounts)
            sum += el.getAmount();
        return sum;
    }

    private List<Account> redistributeMoney(List<Account> accounts)
    {
        List<Pair<Double, AmountInterval>> lst = new ArrayList<>();
        for (Account el : accounts)
        {
            for (Map.Entry pair : el.getRateToAmount().entrySet())
            {
                lst.add(new Pair(pair.getKey(), pair.getValue()));
            }
        }
        List<Pair<Double, AmountInterval>> lst_ordered = new ArrayList<>();
        while (lst.size() > 0)
        {
            double max = 0;
            int pos = 0;
            for (int j = 0; j < lst.size(); j++)
            {
                if (max < lst.get(j).getKey())
                {
                    max = lst.get(j).getKey();
                    pos = j;
                }
            }
            lst_ordered.add(lst.get(lst.indexOf(lst.get(pos))));
            lst.remove(pos);
        }
        long total = sumOfAccounts(accounts);

        for (int i = 0; i < accounts.size();i++)
            accounts.get(i).setAmount(0);

        for (Pair<Double, AmountInterval> pair : lst_ordered)
        {
            for (Account el : accounts)
            {
                if (el.getRateToAmount().containsKey(pair.getKey())) {
                    Double rate = (Double) pair.getKey();
                    AmountInterval inter = el.getRateToAmount().get(pair.getKey());
                    if (total >= inter.getUpperBound() - el.getAmount()) {
                        total = total - (inter.getUpperBound() - el.getAmount());
                        el.setAmount(inter.getUpperBound());
                    } else {
                        int aux = el.getAmount();
                        el.setAmount(aux + (int) total);
                        total = 0;
                    }
                }
            }
        }
        System.out.println(accounts.toString());
        return accounts;
    }

    private void addSamples() throws ValidatorException {
        Map<Double, AmountInterval> map = new HashMap<>();
        map.put(0.3, new AmountInterval(0, 500, 1));
        map.put(0.2, new AmountInterval(500, 5000, 2));
        Account acc1 = new Account(1, AccountType.SILVER, map, LocalDateTime.of(2020, 5, 23, 10, 10), 5000);

        Map<Double, AmountInterval> map2 = new HashMap<>();
        map2.put(0.6, new AmountInterval(0, 500, 1));
        map2.put(0.4, new AmountInterval(500, 5000, 2));
        Account acc2 = new Account(2, AccountType.GOLD, map2, LocalDateTime.of(2020, 7, 5, 10, 10), 700);

        Map<Double, AmountInterval> map3 = new HashMap<>();
        map3.put(0.9, new AmountInterval(0, 500, 1));
        map3.put(0.5, new AmountInterval(500, 5000, 2));
        Account acc3 = new Account(3, AccountType.PLATINUM, map3, LocalDateTime.of(2020, 3, 15, 10, 10), 300);

        acc_srv.add(acc1);
        acc_srv.add(acc2);
        acc_srv.add(acc3);
    }

    private void after39Months(List<Account> accounts)
    {
        redistributeMoney(accounts);
        for (Account acc : accounts)
        {
            int sum = acc.getAmount();
            int money = sum;
            for (Map.Entry<Double, AmountInterval> pair : acc.getRateToAmount().entrySet())
            {
                Double rate = pair.getKey();
                AmountInterval amount = pair.getValue();
                if (amount.getNr() == 1)
                    if (money >= amount.getUpperBound())
                    {
                        for (int k = 0; k < 3; k++)
                            sum += rate * 5;
                        money -= 500;
                    }
                    else
                    {
                        for (int k = 0; k < 3; k++)
                            sum += rate / 100 * money;
                        money = 0;
                    }
            }
            for (Map.Entry<Double, AmountInterval> pair : acc.getRateToAmount().entrySet())
            {
                Double rate = pair.getKey();
                AmountInterval amount = pair.getValue();
                if (amount.getNr() == 2)
                    if (money >= amount.getUpperBound() - amount.getLowerBound())
                    {
                        for (int k = 0; k < 3; k++)
                            sum += rate * 45;
                        money -= 4500;
                    }
                    else
                    {
                        for (int k = 0; k < 3; k++)
                            sum += rate / 100 * money;
                        money = 0;
                    }
            }
            acc.setAmount(sum);
        }
        System.out.println(accounts.toString());
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
                    System.out.println("Your command: ");
                    command = scanner.nextInt();
                    if (command == 1)
                    {
                        while (true)
                        {
                            printAccountsCRUDMenu();
                            System.out.println("Your command: ");
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
                        List<Account> lst = new ArrayList<>();
                        String[] str = {"PLATINUM", "GOLD", "SILVER"};
                        for (String el : str) {
                            for (Map.Entry<Integer, Account> pair : acc_srv.getAccounts().entrySet()){
                                Account acc = (Account) pair.getValue();
                                if (acc.getType().name().equals(el))
                                    lst.add(acc);
                            }
                        }
                        redistributeMoney(lst);
                    }
                    else if (command == 3)
                    {
                        List<Account> lst = new ArrayList<>();
                        String[] str = {"PLATINUM", "GOLD", "SILVER"};
                        for (String el : str) {
                            for (Map.Entry<Integer, Account> pair : acc_srv.getAccounts().entrySet()){
                                Account acc = (Account) pair.getValue();
                                if (acc.getType().name().equals(el))
                                    lst.add(acc);
                            }
                        }
                        after39Months(lst);
                    }
                    else if (command == 0)
                        break;
                    else
                        System.out.println("Invalid command!");
                }

            }
            else if (command == 1)
            {
                while (true)
                {
                    addSamples();
                    printGivenDataMenu();
                    System.out.println("Your command: ");
                    command = scanner.nextInt();
                    if (command == 1) {
                        List<Account> lst = new ArrayList<>();
                        String[] str = {"PLATINUM", "GOLD", "SILVER"};
                        for (String el : str) {
                            for (Map.Entry<Integer, Account> pair : acc_srv.getAccounts().entrySet()){
                                Account acc = (Account) pair.getValue();
                                if (acc.getType().name().equals(el))
                                    lst.add(acc);
                            }
                        }
                        redistributeMoney(lst);
                    } else if (command == 2) {
                        List<Account> lst = new ArrayList<>();
                        String[] str = {"PLATINUM", "GOLD", "SILVER"};
                        for (String el : str) {
                            for (Map.Entry<Integer, Account> pair : acc_srv.getAccounts().entrySet()){
                                Account acc = (Account) pair.getValue();
                                if (acc.getType().name().equals(el))
                                    lst.add(acc);
                            }
                        }
                        after39Months(lst);
                    } else if (command == 3) {
                        displayAccounts();
                    } else if (command == 0)
                        break;
                    else
                        System.out.println("Invalid command!");
                }
            }
            else if (command == 0)
                break;
            else
                System.out.println("Invalid option!");
        }
    }
}
