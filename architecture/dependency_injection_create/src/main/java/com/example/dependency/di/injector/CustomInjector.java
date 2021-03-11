package com.example.dependency.di.injector;

import com.example.dependency.di.framework.annotations.CustomComponent;
import com.example.dependency.di.framework.utils.ClassLoaderUtil;
import com.example.dependency.di.framework.utils.InjectionUtil;

import org.reflections.Reflections;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import javax.management.RuntimeErrorException;

/**
 * Injector, to create objects for all @CustomService classes. autowire/inject
 * all dependencies
 */
public class CustomInjector {
    private final Map<Class<?>, Class<?>> diMap;
    private final Map<Class<?>, Object> applicationScope;

    public CustomInjector() {
        super();
        diMap = new HashMap<>();
        applicationScope = new HashMap<>();
    }

    public <T> T getService(Class<T> clazz) {
        try {
            return this.getBeanInstance(clazz);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * initialize the injector framework
     */
    public void initFramework(Class<?> mainClazz) throws InstantiationException, IllegalAccessException, ClassNotFoundException, IOException {
        Class<?>[] classes = ClassLoaderUtil.getClasses(mainClazz.getPackage().getName());
        Reflections reflections = new Reflections(mainClazz.getPackage().getName());
        Set<Class<?>> types = reflections.getTypesAnnotatedWith(CustomComponent.class);
        for (Class<?> implementationClass : types) {
            Class<?>[] interfaces = implementationClass.getInterfaces();
            if (interfaces.length == 0) {
                diMap.put(implementationClass, implementationClass);
            } else {
                for (Class<?> interfaceClazz : interfaces) {
                    diMap.put(implementationClass, interfaceClazz);
                }
            }
        }

        for (Class<?> clazz : classes) {
            if (clazz.isAnnotationPresent(CustomComponent.class)) {
                Object classInstance = clazz.newInstance();
                applicationScope.put(clazz, classInstance);
                InjectionUtil.autowire(this, clazz, classInstance);
            }
        }
    }

    /**
     * Create and Get the Object instance of the implementation class for input
     * interface service
     */
    @SuppressWarnings("unchecked")
    private <T> T getBeanInstance(Class<T> interfaceClass) throws InstantiationException, IllegalAccessException {
        return (T) getBeanInstance(interfaceClass, null, null);
    }

    /**
     * Overload getBeanInstance to handle qualifier and autowire by type
     */
    public <T> Object getBeanInstance(Class<T> interfaceClass, String fieldName, String qualifier) throws InstantiationException, IllegalAccessException {
        Class<?> implementationClass = getImplementsClazz(interfaceClass, fieldName, qualifier);

        if (applicationScope.containsKey(implementationClass)) {
            return applicationScope.get(implementationClass);
        }

        synchronized (applicationScope) {
            Object service = implementationClass.newInstance();
            applicationScope.put(implementationClass, service);
            return service;
        }
    }

    /**
     * Get the name of the implements class for input interface service
     */
    private Class<?> getImplementsClazz(Class<?> interfaceClazz, final String fieldName, final String qualifier) {
        Set<Entry<Class<?>, Class<?>>> implementationClasses = diMap.entrySet().stream()
                .filter(entry -> entry.getValue() == interfaceClazz).collect(Collectors.toSet());
        String errorMessage = "";
        if (implementationClasses.isEmpty()) {
            errorMessage = "no implementation found for interface " + interfaceClazz.getName();
        } else if (implementationClasses.size() == 1) {
            Optional<Entry<Class<?>, Class<?>>> optional = implementationClasses.stream().findFirst();
            if (optional.isPresent()) {
                return optional.get().getKey();
            }
        } else {
            final String findBy = (qualifier == null || qualifier.trim().length() == 0) ? fieldName : qualifier;
            Optional<Entry<Class<?>, Class<?>>> optional = implementationClasses.stream()
                    .filter(entry -> entry.getKey().getSimpleName().equalsIgnoreCase(findBy)).findAny();
            if (optional.isPresent()) {
                return optional.get().getKey();
            } else {
                errorMessage = "There are " + implementationClasses.size() + " of interface " + interfaceClazz.getName()
                        + " Expected single implementation or make use of @CustomQualifier to resolve conflict";
            }
        }
        throw new RuntimeErrorException(new Error(errorMessage));
    }
}