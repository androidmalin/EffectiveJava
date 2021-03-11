package com.example.dependency.application;

import com.example.dependency.UserAccountApplication;
import com.example.dependency.di.framework.annotations.CustomApplication;
import com.example.dependency.di.injector.CustomInjector;

public class CustomDemoApplication {

    private final CustomInjector injector;

    public CustomDemoApplication() {
        this.injector = new CustomInjector();
    }

    public static void run(Class<?> mainClazz, String[] args) {
        new CustomDemoApplication().run(mainClazz);
    }

    private void run(Class<?> mainClazz) {
        boolean hasCustomApplicationAnnotation = mainClazz.isAnnotationPresent(CustomApplication.class);

        if (hasCustomApplicationAnnotation) {
            System.out.println("Starting CustomDemoApplication...");
            this.startApplication(UserAccountApplication.class);
            this.injector.getService(ClientApplication.class).displayUserAccount();
            System.out.println("Stopping CustomDemoApplication...");
        } else {
            System.out.println("Running as regular java Application...");
        }
    }

    /**
     * Start application
     */
    public void startApplication(Class<?> mainClass) {
        try {
            synchronized (CustomDemoApplication.class) {
                this.injector.initFramework(mainClass);
                System.out.println("CustomDemoApplication Started....");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
