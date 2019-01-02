package com.infotel.bank.bankInfotelweb;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;

/**
 *
 * @author paulinlenasaein
 */
@ComponentScan("com.infotel.bank.bankInfotelweb")
public class ServletInitializer extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(BankInfotelWebApplication.class);
    }
}
