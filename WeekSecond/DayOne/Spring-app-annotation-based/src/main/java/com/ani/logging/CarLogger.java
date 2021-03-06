package com.ani.logging;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component



public class CarLogger {

    @Pointcut("execute (public * com.ani.car.car.speedUp(..))")
public void pointCutAfterExecution(){}
    @Before("execution(* com.ani.car.*.*(..))")
    public void logBeforeAnyMethodExecutionCarPackage(JoinPoint jp){
        System.out.println("Before Execution I am getting printed");
        System.out.println("Executing method "+jp.getSignature());
        System.out.println("After this line you will see method output");
        System.out.println("----------------");
    }
    @After("pointCutAfterExecution()")
    public void logAfterAnyMethods(JoinPoint jp) {
        System.out.println("After Execution I am getting printed");
    }
}
