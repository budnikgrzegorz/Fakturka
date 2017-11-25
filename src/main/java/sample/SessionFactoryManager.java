package sample;

import model.invoice.SingleInvoice;
import model.product.SingleProduct;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class SessionFactoryManager {
    private static SessionFactory sessionFactory;

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            StandardServiceRegistry standardServiceRegistry = new StandardServiceRegistryBuilder()
                    .applySetting("hibernate.connection.url", "jdbc:mysql://localhost:3306/")
                    .applySetting("hibernate.connection.username", "root")
                    .applySetting("hibernate.connection.password", "password")
                    .applySetting("hibernate.connection.driver", "com.mysql.jdbc.Driver")
                    .applySetting("hibernate.dialect", "org.hibernate.dialect.MySQL5InnoDBDialect")
                    .applySetting("hibernate.dialect.storage_engine", "innodb")
                    .applySetting("hibernate.hbm2ddl.auto", "create")
                    .applySetting("hibernate.show_sql", "true")
                    .applySetting("hibernate.format_sql", "true")
                    .build();
            MetadataSources metadataSources = new MetadataSources(standardServiceRegistry)
                    .addAnnotatedClass(SingleInvoice.class)
                    .addAnnotatedClass(SingleProduct.class);
            Metadata metadata = metadataSources.buildMetadata();
            sessionFactory = metadata.buildSessionFactory();
        }
        return sessionFactory;
    }
}