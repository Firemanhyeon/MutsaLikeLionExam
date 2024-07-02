package org.example.javaspringmvc.view;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.View;

import java.util.Map;

public class MyCustonView implements View {

    @Override
    public String getContentType() {
        return "text/html";
    }

    @Override
    public void render(Map<String, ?> model, HttpServletRequest request, HttpServletResponse response) throws Exception {
        response.setContentType(getContentType());
        response.getWriter().write("<html><body><h1>Custom View Content</h1><p>Thi is a custom view for prefix 'my-prefix'.</p></body></html>");
        response.getWriter().close();
    }
}
