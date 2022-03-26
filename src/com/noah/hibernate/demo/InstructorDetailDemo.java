package com.noah.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.noah.hibernate.demo.entity.Instructor;
import com.noah.hibernate.demo.entity.InstructorDetail;

public class InstructorDetailDemo {

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
			int id = 1 ;
			//get Detail
			InstructorDetail instructorDetail
				= session.get(InstructorDetail.class, id   );
			//print Detail
			System.out.println(instructorDetail);
			//show association
			System.out.println(instructorDetail.getInstructor());
			//commit transaction
			session.getTransaction().commit();
			System.out.println("完成!");
		}catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			session.close();
			factory.close();
		}
	}

}
