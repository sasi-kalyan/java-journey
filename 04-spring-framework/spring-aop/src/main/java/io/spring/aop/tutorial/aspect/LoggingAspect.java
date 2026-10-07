package io.spring.aop.tutorial.aspect;

import io.spring.aop.tutorial.model.AnimeDto;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

    @Before("execution(* io.spring.aop.tutorial.service.AnimeService.*(..))")
    public void logBefore(){
        System.out.println("method execution started...");
    }

    @After("execution(* io.spring.aop.tutorial.service.AnimeService.*(..))")
    public void logAfter(){
        System.out.println("method execution ended...");
    }

    @AfterReturning(
            pointcut = "execution(* io.spring.aop.tutorial.service.*.*(..))",
            returning = "result"
    )
    public void logAfterMethodReturns(Object result){
        System.out.println("log after method return something -- invoked...");

        if (result instanceof AnimeDto){
            AnimeDto animeDto = (AnimeDto) result;

            System.out.println("result returned by the method is: " + result);
            System.out.println("anime name: "+ animeDto.getAnime());
            System.out.println("anime rating: "+ animeDto.getRating());
        }
    }


    @AfterThrowing(
            pointcut = "execution(* io.spring.aop.tutorial.service.*.*(..))",
            throwing = "ex"
    )
    public void logException(Exception ex){
        System.out.println("inside logException method");
        System.out.println("Runtime exception throwed");
    }

    @Around("execution(* io.spring.aop.tutorial.service.AnimeService.*(..))")
    public Object logAround(ProceedingJoinPoint pjp) throws Throwable{
        System.out.println("inside log around advice");

        pjp.proceed();

        System.out.println("proceeding the method execution");

        return "Success";
    }
}
