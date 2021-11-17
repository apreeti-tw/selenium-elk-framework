package com.seleniumframeworks.annotations;

import com.seleniumframeworks.enums.CategoryTypes;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface FrameworkAnnotations {
    public String[] author();
    public CategoryTypes[] category();
}
