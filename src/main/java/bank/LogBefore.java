package bank;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LogBefore {

    @Before("execution(public boolean validate(String, String))")
    public void beforeValidate(){
        System.out.println("Проверка запускается");
    }

    @Before("execution(public boolean transferInstantiate())")
    public void beforeTransferInstantiate(){
        System.out.println("Попытка создания экземпляра сервиса перевода средств");
    }

}
