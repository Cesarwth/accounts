package com.ct.cuentas.infrastructure.configuration;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource(value = "classpath:db_connection.properties")
@NoArgsConstructor
@Setter
@Getter
public class Properties {
    @Value("${postgres.db.configuration.driver}")
    private String DriverName;
    @Value("${postgres.db.configuration.ip}")
    private String ipAddress;
    @Value("${postgres.db.configuration.port}")
    private String DBPort;

    @Value("${postgres.db.configuration.database.name}")
    private String DBName;

    @Value("${postgres.db.configuration.auth.user}")
    private String user;
    @Value("${postgres.db.configuration.auth.pass}")
    private String password;

    @Value("${postgres.db.configuration.database.schema}")
    private String schema;
}
