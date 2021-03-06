package ncu.jerry.orangeplus;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.boot.web.servlet.ErrorPage;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@SpringBootApplication
public class OrangeplusApplication extends WebMvcConfigurerAdapter {

    protected final static Logger logger = LoggerFactory.getLogger(OrangeplusApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(OrangeplusApplication.class, args);
        logger.info("Backend Web Application is success!");
    }

    @Bean
    public EmbeddedServletContainerCustomizer containerCustomizer() {

        return (container -> {
            ErrorPage error401Page = new ErrorPage(HttpStatus.UNAUTHORIZED, "/static/errorPage/401.html");
            ErrorPage error404Page = new ErrorPage(HttpStatus.NOT_FOUND, "/static/errorPage/404.html");
            ErrorPage error500Page = new ErrorPage(HttpStatus.INTERNAL_SERVER_ERROR, "/static/errorPage/500.html");

            container.addErrorPages(error401Page, error404Page, error500Page);
        });
    }
}
