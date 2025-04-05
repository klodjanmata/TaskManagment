package CommentEntity;

import Util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class CommentsRepository {
        public void save(Comments comments) {
            try(Session session = HibernateUtil.getSessionFactory().openSession()){
                Transaction transaction = session.beginTransaction();
                session.persist(comments);
                transaction.commit();
            }catch (Exception e){
                e.printStackTrace();
            }
        }


}
