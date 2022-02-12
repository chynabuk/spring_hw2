package bank;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LogBefore {

    @Before("execution(public boolean validate(String, String))")
    public void beforeValidate(JoinPoint joinPoint){
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();

        System.out.println("Имя метода: " + signature.getName());

        Object[] arguments = joinPoint.getArgs();

        System.out.println("Ваши данные: ");

        for (Object arg : arguments){
            if (arg instanceof String){
                System.out.println((String) arg);
            }
        }

        System.out.println();
        System.out.println("Проверка запускается");
    }

    @Before("execution(public boolean transferInstantiate())")
    public void beforeTransferInstantiate(JoinPoint joinPoint){
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();

        System.out.println("Имя метода: " + signature.getName());

        System.out.println("Попытка создания экземпляра сервиса перевода средств");
    }

}
