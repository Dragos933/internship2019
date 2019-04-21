import Exceptions.ValidatorException;
import Repository.AccountRepo;
import Service.AccountService;
import UI.Console;
import Validator.AccountValidator;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException, ValidatorException {
        AccountValidator acc_validator = new AccountValidator();
        AccountRepo acc_repo = new AccountRepo(acc_validator);
        AccountService acc_srv = new AccountService(acc_repo);


        Console console = new Console(acc_srv);

        console.run();
    }
}
