package p06_custom_enum_annotations;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Documented
public @interface CustomAnnotation {
    String type();
    String category();
    String description();
}