package io.konik.builder;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

import net.karneim.pojobuilder.GeneratePojoBuilder;

@GeneratePojoBuilder(withBuilderInterface = PojoBuilder.class, withBuilderProperties = true, withSetterNamePattern="*")
@Target({ElementType.TYPE, ElementType.ANNOTATION_TYPE})
@Documented
public @interface GenerateBuilder {

}
