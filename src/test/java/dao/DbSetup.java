package dao;

import dao.huinya.AppConfig;
import org.flywaydb.core.Flyway;
import org.h2.jdbcx.JdbcConnectionPool;
import org.h2.tools.Server;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.skife.jdbi.v2.DBI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.sql.SQLException;

@Configuration
@ComponentScan(basePackages = {"dao, service"})
public class DbSetup {

    public static final String JDBC_URL = "jdbc:h2:mem:test_mem;MODE=PostgreSQL;DB_CLOSE_DELAY=-1";
    private static Server server;
    protected static DBI jdbi;


    @Bean
    private static DataSource dataSource(){
        return  JdbcConnectionPool.create(JDBC_URL, "sa", "");
    }

    @Bean
    @Autowired
    public JdbcTemplate jdbcTemplate(DataSource dataSource) throws SQLException {
        return new JdbcTemplate(dataSource());
    }

    @BeforeClass
    public static void initDB() throws Exception {

        server = Server.createTcpServer();
        initSchema();

        DataSource dataSource = dataSource();
        jdbi = new DBI(dataSource);
    }


    private static void initSchema() {
        Flyway flyway = new Flyway();
        flyway.setDataSource(JDBC_URL, "sa", "");
        flyway.migrate();
    }

    @AfterClass
    public static void closeDB() throws Exception {
        server.shutdown();
    }
}
