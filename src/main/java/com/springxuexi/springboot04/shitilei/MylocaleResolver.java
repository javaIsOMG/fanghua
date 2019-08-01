package com.springxuexi.springboot04.shitilei;

import org.springframework.web.servlet.LocaleResolver;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

//写一个区域信息解析器

public class MylocaleResolver implements LocaleResolver {
//    private final Logger logger=LoggerFactory.getLogger(MylocaleResolver.class);


    public Locale resolveLocale(HttpServletRequest httpServletRequest) {
        String l=httpServletRequest.getParameter("l");
        Locale locale=Locale.getDefault();
        if(!StringUtils.isEmpty(l)){
//            try {
                String []spp=l.split("_");

                locale=new Locale(spp[0],spp[1]);
//            }catch (Exception e){
//                e.printStackTrace();
//                logger.error("错误");
//            }

        }
        return locale;
    }




    @Override
    public void setLocale(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Locale locale) {

    }
}


