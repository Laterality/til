# aop with xml

XML로 작성된 빈에서 간단한 AOP를 구현한 프로젝트입니다.

## 구현 설명

숫자 범위를 인자로 받아 구간의 합을 반환하는 메서드 `getSum(int start, int end)`를 갖는 클래스 `MyClass`와 메서드의 실행 시간을 측정하기 위한 `PerformanceTraceAdvice` 클래스를 작성합니다.

두 클래스를 빈으로 등록한 뒤 테스트 클래스를 작성하고 이를 실행하여 결과를 확인합니다.

## 결론

실제 서비스에서는 실시간으로 서비스의 상태를 관리하고 비즈니스 로직을 처리하기 
위한 수많은 기능들이 사용되는데, 각각의 세부 기능들에서 핵심 기능을 제외한, 
서비스에서 공통적으로 사용되는 로직(인증, 로그 등)을 핵심 기능으로부터 완전히 
분리하기 위해 사용되는 개념이 AOP입니다. 

Spring AOP에서는 이를 구현하기 위해 핵심 기능을 가지고 있는 타겟 객체를 감싸는 
Proxy 객체를 생성합니다. 호출자가 해당 클래스의 메서드를 호출하면 이 호출을 
가로채서 적절한 어드바이스를 호출합니다. 결국 타겟의 코드에는 어드바이스와 
관련된 코드가 없기 때문에 훨씬 간결하고 좋은 코드를 작성할 수 있습니다.

### Term Note

<dl>
<dt>애스펙트(Aspect)</dt>
<dd>AOP의 기본 요소. 어드바이스와 포인트컷이 결합하여 하나의 애스펙트를 구성한다.</dd>
<dt>타겟(Target)</dt>
<dd>핵심 기능을 가진 모듈.</dd>
<dt>어드바이스(Advice)</dt>
<dd>타겟에 제공할 부가 기능을 가진 모듈.</dd>
<dt>조인 포인트(Join Point)</dt>
<dd>어드바이스를 적용(Join)할 지점(Point).</dd>
<dt>포인트 컷(Point Cut)</dt>
<dd>어드바이스를 적용할 타겟의 메서드를 선택하는 정규표현식.</dd>
<dd><pre>execution([MODIFIER_PATTERN] RETURN_TYPE_PATTERN [RETURN_TYPE_PATTERN.] METHOD_NAME_PATTERN (ARGUMENT_TYPE_PATTERN | "...", ...) [throws EXCEPTION_PATTERN]</pre></dd>
</dl>