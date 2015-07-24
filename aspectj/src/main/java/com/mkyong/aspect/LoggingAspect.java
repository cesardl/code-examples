package com.mkyong.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

import java.util.Arrays;

/**
 * Created by cesardiaz on 23/07/15.
 */
@Aspect
public class LoggingAspect {

    @Before("execution(* com.mkyong.customer.bo.CustomerBo.addCustomer(..))")
    public void logBefore(JoinPoint joinPoint) {

        System.out.println("******");
        System.out.println("logBefore() is running!");
        System.out.println("hijacked : " + joinPoint.getSignature().getName());
        System.out.println("******");

    }

    @After("execution(* com.mkyong.customer.bo.CustomerBo.addCustomer(..))")
    public void logAfter(JoinPoint joinPoint) {

        System.out.println("******");
        System.out.println("logAfter() is running!");
        System.out.println("hijacked : " + joinPoint.getSignature().getName());
        System.out.println("******");

    }

    @AfterReturning(
            pointcut = "execution(* com.mkyong.customer.bo.CustomerBo.addCustomerReturnValue(..))",
            returning= "result")
    public void logAfterReturning(JoinPoint joinPoint, Object result) {

        System.out.println("******");
        System.out.println("logAfterReturning() is running!");
        System.out.println("hijacked : " + joinPoint.getSignature().getName());
        System.out.println("Method returned value is : " + result);
        System.out.println("******");

    }

    @AfterThrowing(
            pointcut = "execution(* com.mkyong.customer.bo.CustomerBo.addCustomerThrowException(..))",
            throwing= "error")
    public void logAfterThrowing(JoinPoint joinPoint, Throwable error) {

        System.out.println("******");
        System.out.println("logAfterThrowing() is running!");
        System.out.println("hijacked : " + joinPoint.getSignature().getName());
        System.out.println("Exception : " + error);
        System.out.println("******");

    }

    @Around("execution(* com.mkyong.customer.bo.CustomerBo.addCustomerAround(..))")
    public void logAround(ProceedingJoinPoint joinPoint) throws Throwable {

        System.out.println("******");
        System.out.println("logAround() is running!");
        System.out.println("hijacked method : " + joinPoint.getSignature().getName());
        System.out.println("hijacked arguments : " + Arrays.toString(joinPoint.getArgs()));

        System.out.println("Around before is running!");
        joinPoint.proceed(); //continue on the intercepted method
        System.out.println("Around after is running!");

        System.out.println("******");

    }

}
