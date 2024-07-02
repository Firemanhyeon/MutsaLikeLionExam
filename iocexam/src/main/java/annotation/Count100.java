package annotation;

import java.lang.annotation.Retention;
import static java.lang.annotation.RetentionPolicy.RUNTIME;
//애노테이션 직접 정의하기.
@Retention(RUNTIME)//유효한 시점을 정해준다.
public @interface Count100 {
}
