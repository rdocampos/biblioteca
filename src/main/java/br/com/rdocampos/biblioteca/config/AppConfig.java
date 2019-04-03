package br.com.rdocampos.biblioteca.config;

import br.com.rdocampos.biblioteca.interceptor.BibliotecaInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@Configuration
public class AppConfig implements WebMvcConfigurer {

    @Autowired
    private BibliotecaInterceptor bibliotecaInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(bibliotecaInterceptor);
    }

}
