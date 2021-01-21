package com.example;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public interface UMLify{
    default void classDiagram(){

        String className = getClass().getSimpleName();
        List<String> methods = new ArrayList<>();
        List<String> fields = new ArrayList<>();

        for(Method m : getClass().getDeclaredMethods()){
            String name = m.getName();
            if(java.lang.reflect.Modifier.isPublic(m.getModifiers()))
                name = " + "+name;
            else
                name = " - "+name;

            CustomMethodUMLify desc = m.getDeclaredAnnotation(CustomMethodUMLify.class);
            if(desc != null && !desc.value().isEmpty())
                name += " ("+desc.value()+")";
            methods.add(name);
        }

        for(Field f : getClass().getDeclaredFields()){
            String name = f.getName();
            if(java.lang.reflect.Modifier.isPublic(f.getModifiers()))
                name = " + "+name;
            else
                name = " - "+name;

            CustomFieldUMLify desc = f.getDeclaredAnnotation(CustomFieldUMLify.class);
            if(desc != null && !desc.value().isEmpty())
                name += " ("+desc.value()+")";
            fields.add(name);
        }
    
    
    int fieldsWidth = fields.stream()
        .mapToInt(String::length)
        .max().orElse(0);

    int methodsWidth = methods.stream()
    .mapToInt(String::length)
    .max().orElse(0);

    int width = IntStream.of(fieldsWidth,methodsWidth,className.length()).max().getAsInt();
    

    System.out.println(className);
    System.out.println("-".repeat(width));
    System.out.println(methods.stream()
    .collect(Collectors.joining("\n")));
    System.out.println("-".repeat(width));
    System.out.println(fields.stream().collect(Collectors.joining("\n")));
    
    
    
    
    }
}