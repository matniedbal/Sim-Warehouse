package eu.mrndeign.matned.data.mySql;

import eu.mrndeign.matned.data.mySql.entity.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

import static eu.mrndeign.matned.data.use.ConstantValues.HIBERNATE_FILE;

public class DBFactory<E> {

    private Configuration conf;
    private SessionFactory factory;
    private Session session;

    private String hibernateFile;

    public DBFactory() {
        this.hibernateFile = HIBERNATE_FILE;
    }

    public DBFactory(String hibernateFile) {
        this.hibernateFile = hibernateFile;
    }

    public void initialize() {
        conf = new Configuration();
        conf.configure(hibernateFile);
        conf.addAnnotatedClass(ProductDetails.class);
        conf.addAnnotatedClass(Product.class);
        conf.addAnnotatedClass(Order.class);
        conf.addAnnotatedClass(Client.class);
        conf.addAnnotatedClass(Bot.class);
        conf.addAnnotatedClass(BotType.class);
        conf.addAnnotatedClass(PackageType.class);
        conf.addAnnotatedClass(PackedPallet.class);
        conf.addAnnotatedClass(Regal.class);
        conf.addAnnotatedClass(RegalSpace.class);
        conf.addAnnotatedClass(Warehouse.class);
    }

    public E getRecord(String q){
        connectionOn();
        E query = (E) session.createQuery(q).getSingleResult();
        query.toString();
        connectionOff();
        return query;
    }


    public List getList(String q){
        connectionOn();
        List query = session.createQuery(q).getResultList();
        if(query != null)
            for (Object el: query) {
                el.toString();
            }
        connectionOff();
        return query;
    }

    public void query(String q){
        connectionOn();
        session.createQuery(q);
        connectionOff();
    }


    public void connectionOn(){
        initialize();
        factory = conf.buildSessionFactory();
        session = factory.getCurrentSession();
        session.beginTransaction();
    }

    public void connectionOff(){
        session.getTransaction().commit();
        factory.close();
    }

    public void setHibernateFile(String hibernateFile) {
        this.hibernateFile = hibernateFile;
    }

    public Configuration getConf() {
        return conf;
    }

    public SessionFactory getFactory() {
        return factory;
    }

    public Session getSession() {
        return session;
    }

    public String getHibernateFile() {
        return hibernateFile;
    }
}
