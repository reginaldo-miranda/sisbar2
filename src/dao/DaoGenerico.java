package dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Id;
import javax.persistence.Persistence;

public class DaoGenerico<T extends EntidadeBase> {
  
    public EntityManager getEM() {

        EntityManagerFactory factory = Persistence.createEntityManagerFactory("sisbar2PU");
        return factory.createEntityManager();
    }
       public T salvar(T t) throws Exception{
           EntityManager em = getEM();
           try {
               em.getTransaction().begin();
               if(t.getId() == null){
                   em.persist(t);
               }else{
                   if (em.contains(t)){
                       if(em.find(t.getClass(), t.getId()) == null){
                           throw new Exception("erro ao atualiza ");
                       }
                   }
                   t = em.merge(t);
               }
               em.getTransaction().commit();
           } finally {
               em.close();
           }
           return t;
       }
       
       public void remove(Class<T> clazz, Integer id){
           
           EntityManager em = getEM();
           T t = (T) em.find(clazz, id);
           try {
               em.getTransaction().begin();
               em.remove(t);
               em.getTransaction().commit();
               
           } finally {
               em.close();
           }
       }
       
       public T consultaPorId(Class<T> clazz, Integer id){
           EntityManager em = getEM();
           T t = null;
           try{
               t = em.find(clazz, id);
           }finally{
               em.close();
           }
           return t;
           
       }
       
}
