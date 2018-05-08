package ru.siksmfp.spring.jms.publisher.config;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author Artem Karnov @date 4/17/2018.
 * @email artem.karnov@t-systems.com
 */
@Component
public class SetUpBean {
    private static final String DRIVER = "org.apache.derby.jdbc.EmbeddedDriver";
    private static final String JDBC_URL = "jdbc:derby:mydb;create=true";

    @PostConstruct
    public void setUp() throws SQLException {
        Connection conn = null;
        try {
            Class.forName(DRIVER);
            conn = DriverManager.getConnection(JDBC_URL);
        } catch (Exception ex) {
            System.err.println(ex);
        }
        System.out.println("Database created " + !conn.isClosed());
    }

//    http://www.baeldung.com/properties-with-spring
//    @PropertySource("classpath:config.properties")
//    @Bean
//    public static PropertySourcesPlaceholderConfigurer propertyConfigInDev() {
//        return new PropertySourcesPlaceholderConfigurer();
//    }

//    @Bean
//    public static PropertySourcesPlaceholderConfigurer properties() {
//        PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer = new PropertySourcesPlaceholderConfigurer();
//        YamlPropertiesFactoryBean yaml = new YamlPropertiesFactoryBean();
//        yaml.setResources(new ClassPathResource("default.yml"));
//        propertySourcesPlaceholderConfigurer.setProperties(yaml.getObject());
//        return propertySourcesPlaceholderConfigurer;
//    }

}
