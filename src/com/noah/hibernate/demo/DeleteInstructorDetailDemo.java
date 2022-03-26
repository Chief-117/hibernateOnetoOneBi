package com.noah.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.noah.hibernate.demo.entity.Instructor;
import com.noah.hibernate.demo.entity.InstructorDetail;

public class DeleteInstructorDetailDemo {

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
			int id = 4 ;
			//get Detail
			InstructorDetail instructorDetail
				= session.get(InstructorDetail.class, id   );
			//print Detail
			System.out.println(instructorDetail);
			//show association
			System.out.println(instructorDetail.getInstructor());
			//delete detail
			//刪除單一個前須先解除association
			instructorDetail.getInstructor().setInstructorDetail(null);
			session.delete(instructorDetail);
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
