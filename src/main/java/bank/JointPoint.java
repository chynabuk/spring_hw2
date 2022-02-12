package bank;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class JointPoint {

    @Pointcut("execution(public * bank.Auditing.*(*)")
    public void getAllMethods(){
    }

}
