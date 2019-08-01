package com.springxuexi.springboot04;

import com.springxuexi.springboot04.shitilei.MylocaleResolver;
import com.springxuexi.springboot04.shitilei.lanjieqi;
import org.springframework.boot.web.server.ConfigurableWebServerFactory;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
@Controller
@Configuration
public class Mymvc implements WebMvcConfigurer {

    //编写了一个servlet容器的配置器,用来修改配置
    @Bean
    public WebServerFactoryCustomizer webServerFactoryCustomizer(){
        return new WebServerFactoryCustomizer<ConfigurableWebServerFactory>() {

            @Override
            public void customize(ConfigurableWebServerFactory factory) {
                factory.setPort(8090);
            }
        };
    }



    public void addViewControllers(ViewControllerRegistry registry) {
        //浏览器发送atguigu请求到heying页面
        registry.addViewController("/atguigu").setViewName("heying");
    }
    //将我们这个继承了localeResolver的类注入到容器中，这里有区域信息解析器的作用，这里的方法名必须为localeResovler

@Bean
   public LocaleResolver localeResolver(){
        return new MylocaleResolver();
   }

   //配置首页
    @Bean
    public WebMvcConfigurer webMvcConfigurer(){
        WebMvcConfigurer webMvcConfigurer=new WebMvcConfigurer() {
            @Override
            public void addViewControllers(ViewControllerRegistry registry) {
                //配置视图映射
                registry.addViewController("/").setViewName("index");
                registry.addViewController("/index.html").setViewName("index");
                registry.addViewController("/main.html").setViewName("dashboard");
            }
//注册拦截器

public void addInterceptors(InterceptorRegistry registry) {

    registry.addInterceptor(new lanjieqi()).addPathPatterns("/**").excludePathPatterns("/","/index.html","/heying","/asserts/**");

}


        };

    return webMvcConfigurer;
}

}
