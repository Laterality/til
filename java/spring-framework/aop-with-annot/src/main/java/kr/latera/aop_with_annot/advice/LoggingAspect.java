package kr.latera.aop_with_annot.advice;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAspect {
	/**
	 * Before: 타겟 메서드 실행 전
	 * After: 타겟 메서드 실행 후
	 * Around: 타겟 메서드 실행 전, 후
	 * AfterReturning: 타겟 메서드 정상 실행(리턴) 후
	 * AfterThrowing: 타겟 메서드의 예외 발생 시
	 */
	
	@Before("execution(* kr.latera..*(..))")
	public void before(JoinPoint joinPoint) {
		String signatureString = joinPoint.getSignature().getName();
		System.out.println("@Before [ " + signatureString + " ] 메서드 실행 전처리 수행");
		for (Object arg : joinPoint.getArgs()) {
			System.out.println("@Before [ " + signatureString + " ] 아규먼트 " + arg);
		}
	}
	
	@AfterReturning(pointcut="execution(public * kr.latera..*(..))", returning="ret")
	public void afterReturning(JoinPoint joinPoint, Object ret) {
		String signatureString = joinPoint.getSignature().getName();
		System.out.println("@AfterReturning [ " + signatureString + " ] 메서드 실행 후처리 수행");
		System.out.println("@AfterReturning [ " + signatureString + " ] 리턴값 = " + ret);
	}
	
	@AfterThrowing(pointcut="execution(* *..annot*.*(..))", throwing="ex")
	public void afterThrowing(JoinPoint joinPoint, Throwable ex) {
		String signatureString = joinPoint.getSignature().getName();
		System.out.println("@AfterThrowing [ " + signatureString + " ] 메서드 실행 중 예외 발생");
		System.out.println("@AfterThrowing [ " + signatureString + " ] 예외 = " + ex.getMessage());
	}
	
	@After("execution(* *..*.*Sum(..))")
	public void afterFinally(JoinPoint joinPoint) {
		String signatureString = joinPoint.getSignature().getName();
		System.out.println("@After [ " + signatureString + " ] 메서드 실행 완료");
	}
	
}
