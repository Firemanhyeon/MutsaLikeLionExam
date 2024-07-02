package org.example.javaspringmvc.config;

import org.example.javaspringmvc.view.MyCustonView;
import org.springframework.core.Ordered;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.ViewResolver;

import java.util.Locale;

public class MyCustomViewResolver implements ViewResolver , Ordered {

    private int order;

    public void setOrder(int order) {
        this.order = order;
    }

    @Override
    public View resolveViewName(String viewName, Locale locale) throws Exception {
        if(viewName.startsWith("my-prefix")){
            return new MyCustonView();
        }
        return null;
    }

    @Override
    public int getOrder() {
        return this.order;
    }
}
