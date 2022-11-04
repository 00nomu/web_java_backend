package mobile.backend.aop;


import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;

@Slf4j
@Aspect
@Order(2)
public class BasicAspect {

    @Around("execution(* mobile.backend.module..*(..))")
    public Object execute(ProceedingJoinPoint joinPoint) throws Throwable {

        try {

            Object result = joinPoint.proceed();

            return result;
        } catch (Exception e) {
            throw e;
        }
    }
}