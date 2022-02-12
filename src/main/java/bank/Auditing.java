package bank;

import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component("auditing")
public class Auditing {
    private Scanner in;

    public boolean validate(String username, String password){
        String[] myData = {"kuba", "12345"};
        System.out.println("банк проверяет ваши учетные данные до перевода средств");

        if (myData[0].equals(username) && myData[1].equals(password)){
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