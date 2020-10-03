# 생성자주입, 필드주입 비교
## 필드 주입
* bean의 순환참조가 일어나도 동작함.
* 혹시 모를 경우(a -> b -> c  -> a -> ...) stackOverflow 가 발생할 수도 있음.

## 생성자주입
* bean의 순환참조가 있을 경우 application이 실행 되지 않는다.
* application이 아예 실행 되지 않기 때문에 순환참조에 의한 에러가 발생할 걱정을 하지 않아도 됨.
-------
### Bean 생성 방식
1. Component Scan
    1. BeanDefinition의 형태로 BeanDefinitionMap에 저장
2. 일괄 생성
    * AbstractApplicationContext.refresh
        * finishBeanFactoryInitialization() 에서 singleton으로 등록된 bean이 생성 됨.
    * Controller 어노테이션이 먼저 생성 되고(?),
    * Controller 어노테이션을 붙인 bean(**wrappedInstance**)들이 순차적으로 생성 됨.
        * `DefaultListableBeanFactory`(bean을 일괄 생성하는 역할을 함)의 `beanDefinitionNames`에 저장된 beanName의 순서대로 생성.
        * 여기서 `beanDefinitionNames`의 순서와 별개로, 현재 생성된 bean이 의존하고 있는 다른 bean(**wrappedInstance**)이 있으면 그것부터 생성
    * `mastr`브랜치를 실행시켜보면 `ServiceA` -> `ServiceB` -> `ServiceC` 순으로 생성되는 반면.
    * `order-of-bean-initialization`브랜치를 실행시켜보면 `ServiceA` -> `ServiceC` -> `ServiceB` 순으로 생성되는 것을 볼 수 있음.
