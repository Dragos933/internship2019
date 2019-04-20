package UI;

import Service.AccountService;

public class Console
{
    private AccountService srv;

    public Console(AccountService srv) {
        this.srv = srv;
    }

    private void printStartingMenu()
    {
        System.out.println("\tData loading:");
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
    }
}
