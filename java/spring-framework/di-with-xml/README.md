# di with xml

본 예제는 T아카데미 Spring Framework 강의([링크](https://tacademy.sktechx.com/live/player/onlineLectureDetail.action?seq=88))를 참고하여 작성하였습니다.

IoC(Iversion of Control)과 DI(Dependency Injection)은 스프링 프레임워크의 핵심 
기능 중 하나입니다. 일반적인 라이브러리들이 관련 객체들의 생성을 라이브러리 
사용자에게 맡기는데, 이는 라이브러리의 제어권이나 객체들의 생명 주기가 사용자에 
의해 관리됨을 의미합니다. 스프링 프레임워크는 이러한 객체의 제어권을 반대로 
프레임워크가 사용자로부터 넘겨받아 객체의 생명주기를 프레임워크가 관리합니다. 
결과적으로 객체의 생명주기 관리와 제어(생성, 소멸) 등과 같은 번거로운 작업들을 
프레임워크가 대신 하게 되는데, 이를 IoC라 합니다.

보통 객체는 다른 객체를 참조하여 동작합니다. 이는 대부분의 객체가 다른 객체에 의존성(Dependency)를 갖게 됨을 의미하는데, 참조하는 객체 내부에서 참조되는 객체를 직접 생성하고 사용하는 경우, 참조되는 객체가 수정에 대비하기 어렵고 테스트하기도 어려운 구조가 됩니다. 이를 해결하기 위해 참조되는 객체를 외부(DI 컨테이너)에서 생성하여 참조하는 객체에 넘겨주는 방법(생성자의 인자, setter 메서드 등)으로 객체의 의존성을 관리하는 방법을 DI라 합니다.

## 구현 설명

스프링 프레임워크는 IoC와 DI를 제공하기 위해 객체 간의 의존 관계를 설정
(Configuration)으로 명시합니다. 크게 xml파일을 통한 설정 방법과 소스코드 내에 
명시하는 방법으로 나뉘는데, 본 예제에서는 xml 파일을 활용한 방법을 설명합니다.

`name`과 `Printer` 인터페이스를 참조하는 객체를 프로퍼티로 갖는 `Hello` 클래스와, `Printer` 인터페이스를 구현하는 `ConsolePrinter`, `StringPrinter` 클래스를 작성합니다.

config/beans.xml 파일에 빈(bean, 프레임워크에 의해 관리되는 객체)을 작성하고 의존관계를 명시합니다.

총 세 개의 빈이 있는데, hello, consolePrinter, stringPrinter이며, hello 빈은 
값이 "Spring"인 `name` 프로퍼티와 `consoleProperty` 빈에 대한 참조를 갖는 `printer` 프로퍼티를 갖습니다.

`HelloBeanTest` 클래스에 이를 테스트하는 코드를 작성하였는데, 빈을 관리하는 DI 
컨테이너인 `ApplicationContext`를 생성합니다. 이로부터 빈을 가져와 각 기능을 
테스트하고 있습니다.