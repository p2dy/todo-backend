package com.example.core.events;

import javax.interceptor.InterceptorBinding;
import java.lang.annotation.*;

@Inherited
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.METHOD})
@InterceptorBinding
public @interface ReferencesBoard {
}
