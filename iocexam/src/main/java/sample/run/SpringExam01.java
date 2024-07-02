package sample.run;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import sample.bean.MyBean;
import sample.config.MyBeanConfig;

public class SpringExam01 {
    public static void main(String[] args) {
        //직접 객체 선언해서 사용하는 경우
//        MyBean myBean = new MyBean();
//        myBean.setName("kang");
//        System.out.println(myBean);

        //Spring ioc container를 이용해 생성하는경우
        //Spring container에게 알려줘야한다 이런 Bean이 있다고
        //1.애노테이션으로 알려준다. - 컴포넌트 스캔 하도록


        //2. 자바config파일을 통해서 알려줌 (config 패키지안의 MyBeanConfig)
        //BeanFactory --빈을 생성하는데 간단한 기능만 포함하고 있다. aop 기술은 사용할 수 없다 그래서 ApplicationContext 사용.
        // TV를 무슨TV를 쓸지 정해주는 클래스와 비슷한 역할

        //Bean에 대한 설정이 들어있음을 말해준다.
        System.out.println("ApplicationContext 생성전");
        ApplicationContext context = new AnnotationConfigApplicationContext(MyBeanConfig.class);//이시점에 객체생성
        System.out.println("ApplicationContext 생성후");
        MyBean myBean = (MyBean) context.getBean("myBean");//lookup방식 , id만 알려줌 해당id만 가져온다.

        myBean.setName("hohyeon");
        System.out.println(myBean);
        //MyBean myBean1 = context.getBean(MyBean.class);//타입만 가져옴. bean이 하나만 있을때는 문제없지만 해당클래스에
                                                        // bean이 두개이상 있을때는 뭘 가져올지 모르기때문에 오류발생
        MyBean myBean1 = context.getBean("myBean2",MyBean.class); // id와 타입을 동시에 가져옴.
                                                                        //bean이 여러개있어도 id를 지정해줬기때문에 id에 해당하는 bean만 가져온다.
        myBean1.setName("hihi");
        System.out.println(myBean1);
        System.out.println(myBean);//싱글톤방식으로 진행되기때문에 하나의 객체로 진행된다

        if(myBean1==myBean){
            System.out.println("myBean1==myBean같아요");
        }else{
            System.out.println("myBean1!=myBean달라요");
        }
        MyBean mybean3 = context.getBean("myBean2" , MyBean.class);

        //같은 id값을 가져왔기때문에 같은주소다.
        if(mybean3 == myBean1){
            System.out.println("bean3과 bean1은 같아요");
        }

        //scope 애노테이션으로 추가한 id가 myBean3 생성. prototype이면 각각 다른 인스턴스를 가지고있다.
        MyBean mybean4 = context.getBean("myBean3" , MyBean.class);
        mybean4.setName("hello");
        System.out.println(mybean4);

        MyBean mybean5 = context.getBean("myBean3" , MyBean.class);
        mybean5.setName("hello555");
        System.out.println(mybean5);

        MyBean mybean6 = context.getBean("myBean4" , MyBean.class);
        System.out.println(mybean6);
        //3. xml을통해서 알려줌 -- 현재는 많이 사용하지 않기 때문에


    }
}
