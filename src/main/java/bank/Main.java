package bank;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MyConfig.class);

        Scanner in = new Scanner(System.in);

        Auditing auditing = context.getBean("auditing", Auditing.class);
        auditing.setIn(in);

        System.out.print("Введите ваше имя: ");
        String username = in.nextLine();

        System.out.print("Введите пароль: ");
        String password = in.nextLine();

        boolean isChecked = auditing.validate(username, password);

        System.out.println();

        if (isChecked){
            boolean isMoneyForTransfering = auditing.transferInstantiate();

            System.out.println();

            if (isMoneyForTransfering){
                auditing.success();
            }

            else {
                auditing.rollback();
            }
        }

        else {
            auditing.rollback();
        }
    }
}
