package com.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;

import java.lang.reflect.Array;
import java.util.Arrays;

@Aspect//标注此类为切面类
public class LogAspects {

    /*抽取公共的切入点表达式
    * 1、如果在本类引用，则直接使用方法名即可
    * 2、如果在其他类引用，则需要使用全类名+方法名
    * */
    @Pointcut("execution(public int com.service.MathCalculator.div(int,int))")
    public void pointCut(){}

    @Before("pointCut()")
    public void logStart(JoinPoint joinPoint){
        Object[] args = joinPoint.getArgs();
        System.out.println("执行方法开始"+joinPoint.getSignature().getName()+" args"+ Arrays.asList(args) +"...");
    }

    @After("pointCut()")
    public void logEnd(JoinPoint joinPoint){
        Object[] args = joinPoint.getArgs();
        System.out.println("执行方法结束 "+joinPoint.getSignature().getName()+" args = "+ Arrays.asList(args) + "... ");
    }

    /**
     *JoinPoint joinPoint 一定要放在参数表的第一位
     * @param joinPoint
     * @param result
     */
    @AfterReturning(value = "pointCut()",returning = "result")
    public void logReturning(JoinPoint joinPoint,Object result){
        System.out.println("方法返回结果后 ..." + result);
    }

    @AfterThrowing(value = "pointCut()", throwing = "exception")
    public void logThrows(JoinPoint joinPoint,Exception exception){
        System.out.println("方法抛出异常 ..." + exception);
    }

//    @Around("pointCut()")
//    public void logAround(){
//        System.out.println("方法around ...");
//    }
}
