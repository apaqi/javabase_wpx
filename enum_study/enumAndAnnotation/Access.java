package enumAndAnnotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/*ʹ��ע��ķ�ʽ����Դ��Ȩ�޼����������*/
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)

@interface Access {
	CommonIdentifier level() default CommonIdentifier.Admin;
}
