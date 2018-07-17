package kr.latera.aop;

import org.aspectj.lang.ProceedingJoinPoint;

public class PerformanceTraceAdvice {
	
	public Object trace(ProceedingJoinPoint joinPoint) throws Throwable {
		// 타겟의 시그니처
		String signatureString = joinPoint.getSignature().toShortString();
		System.out.println(signatureString + "시작");
		
		// 타겟 호출 시간
		long start = System.currentTimeMillis();
		try {
			// 타겟 호출
			Object result = joinPoint.proceed();
			return result;
		}
		finally {
			
			// 타겟 반환
			long finish = System.currentTimeMillis();
			System.out.println(signatureString + "종료");
			System.out.println(signatureString + "실행 시간 : " + (finish - start) + "ms");
		}
	}

}
