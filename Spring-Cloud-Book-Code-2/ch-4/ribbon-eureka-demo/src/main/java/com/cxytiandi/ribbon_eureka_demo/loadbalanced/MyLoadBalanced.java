package com.cxytiandi.ribbon_eureka_demo.loadbalanced;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.springframework.beans.factory.annotation.Qualifier;

@Target({ ElementType.FIELD, ElementType.PARAMETER, ElementType.METHOD }) @Retention(RetentionPolicy.RUNTIME) 
@Documented 
@Inherited 
@Qualifier 
public @interface MyLoadBalanced {
 
}
