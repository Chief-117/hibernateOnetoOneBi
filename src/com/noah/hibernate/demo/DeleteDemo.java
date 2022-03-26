package com.noah.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.noah.hibernate.demo.entity.Instructor;
import com.noah.hibernate.demo.entity.InstructorDetail;

public class DeleteDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 創建session factory
		SessionFactory factory = new Configuration()
								.configure()
								.addAnnotatedClass(Instructor.class)
								.addAnnotatedClass(InstructorDetail.class)
								.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			
			//start transaction
			session.beginTransaction();
			
			//delete instructor
			 int id = 3; 
			 Instructor instructor = 
					 session.get(Instructor.class, id);
			 System.out.println("ID 3為 : " + instructor);
			 if(instructor!=null) {
				 System.out.println("刪除ID為3 : " + instructor);
				 //因為cascadeType.ALL 所以會順便刪除Detail內資料
				 session.delete(instructor);				 
			 }
			 
			//commit transaction
			session.getTransaction().commit();
			System.out.println("完成!");
		}finally {
			factory.close();
		}
	}

}
