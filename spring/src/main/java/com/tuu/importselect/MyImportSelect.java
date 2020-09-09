package com.tuu.importselect;

import org.springframework.context.annotation.DeferredImportSelector;
import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.stereotype.Component;

//@Component
public class MyImportSelect implements DeferredImportSelector {

    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        System.out.println(MyImportSelect.class.getSimpleName());
        String[] str = {"com.tuu.services.UserService"};
        return str;
    }
}
