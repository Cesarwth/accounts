package com.ct.cuentas.infrastructure.configuration;

import com.ct.cuentas.infrastructure.repository.postgresql.SpringDataPostgresAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.naming.NamingException;
import javax.sql.DataSource;

@Configuration
public class PosgresDBConfiguration {
    @Autowired
    private Properties properties;

    @Bean
    public DataSource postgresDataSource() throws NamingException
    {
        String connectionURL= "jdbc:postgresql://"+properties.getIpAddress()+":"+properties.getDBPort()+"/"+properties.getDBName()+"?useSSL=false";
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(properties.getDriverName());
        dataSource.setSchema(properties.getSchema());
        dataSource.setUrl(connectionURL);
        dataSource.setUsername(properties.getUser());
        dataSource.setPassword(properties.getPassword());
        return dataSource;
    }
}
