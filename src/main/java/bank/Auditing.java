package bank;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component("auditing")
public class Auditing {
    @Value("${auditing.username}")
    private String username;

    @Value("${auditing.password}")
    private String password;

    private Scanner in;

    public boolean validate(String username, String password){
        System.out.println("банк проверяет ваши учетные данные до перевода средств");

        if (this.username.equals(username) && this.password.equals(password)){
            System.out.println("успешно проверено");
            return true;
        }
        return false;
    }

    public boolean transferInstantiate(){
        System.out.println("банк создает экземпляр сервиса перевода средств");

        System.out.print("Введите средства: ");
        float money = in.nextFloat();
        in.nextLine();

        if (money < 0){
            return false;
        }
        return true;

    }

    public void success(){
        System.out.println("банк успешно выполнил перевод средств");
    }

    public void rollback() {
        System.out.println("банк откатил операцию перевода средств");
    }

    public void setIn(Scanner in) {
        this.in = in;
    }
}