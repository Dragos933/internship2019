import Exceptions.ValidatorException;
import Repository.ATMRepo;
import Repository.AccountRepo;
import Repository.DistanceRepo;
import Service.ATMService;
import Service.AccountService;
import Service.DistanceService;
import UI.Console;
import Validator.ATMValidator;
import Validator.AccountValidator;
import Validator.DistanceValidator;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException, ValidatorException {
        AccountValidator acc_validator = new AccountValidator();
        AccountRepo acc_repo = new AccountRepo(acc_validator);
        AccountService acc_srv = new AccountService(acc_repo);
        ATMValidator atm_validator = new ATMValidator();
        ATMRepo atm_repo = new ATMRepo(atm_validator);
        ATMService atm_srv = new ATMService(atm_repo);
        DistanceValidator dst_validator = new DistanceValidator();
        DistanceRepo dst_repo = new DistanceRepo(dst_validator);
        DistanceService dst_srv = new DistanceService(dst_repo);


        Console console = new Console(acc_srv, atm_srv, dst_srv);

        console.run();
    }
}
