package enumAndAnnotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/*使用注解的方式将资源和权限级别关联起来*/
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)

@interface Access {
	CommonIdentifier level() default CommonIdentifier.Admin;
}
