package dao;

import com.opentable.db.postgres.embedded.FlywayPreparer;
import com.opentable.db.postgres.junit.EmbeddedPostgresRules;
import com.opentable.db.postgres.junit.PreparedDbRule;
import dao.huinya.AppConfig;
import org.flywaydb.core.Flyway;
import org.flywaydb.core.api.configuration.FluentConfiguration;
import org.h2.jdbcx.JdbcConnectionPool;
import org.h2.tools.Server;
import org.junit.*;
import org.junit.runners.MethodSorters;
import org.skife.jdbi.v2.DBI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.sql.SQLException;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@Configuration
@ComponentScan(basePackages = {"dao, service"})
public class DbSetup {

    public static final String JDBC_URL = "jdbc:h2:~/test;MODE=PostgreSQL;";
    private static Server server;
    protected static DBI jdbi;

    @ClassRule
    public static PreparedDbRule db = EmbeddedPostgresRules.preparedDatabase(FlywayPreparer.forClasspathLocation("db"));

    @Bean
    private static DataSource dataSource(){
    return db.getTestDatabase();
    }





//    @Bean
//    private static DataSource dataSource(){
//        return  JdbcConnectionPool.create(JDBC_URL, "sa", "");
//    }

    @Bean
    @Autowired
    public JdbcTemplate jdbcTemplate(DataSource dataSource) throws SQLException {
        return new JdbcTemplate(dataSource());
    }

//    @BeforeClass
//    public static void initDB() throws Exception {
//
//        server = Server.createTcpServer();
//        initSchema();
//
//        DataSource dataSource = dataSource();
//        jdbi = new DBI(dataSource);
//    }


//    private static void initSchema() {
////        Flyway flyway = new Flyway();
////        flyway.setDataSource(JDBC_URL, "sa", "");
////        flyway.migrate();
//
//
//        FluentConfiguration config = Flyway.configure();
//        config.dataSource(JDBC_URL, "sa", "");
//
//        Flyway flyway = new Flyway(config);
//        flyway.migrate();
//    }

//    @AfterClass
//    public static void closeDB() throws Exception {
//        server.shutdown();
//    }
}
