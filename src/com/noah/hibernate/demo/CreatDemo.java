package com.noah.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.noah.hibernate.demo.entity.Instructor;
import com.noah.hibernate.demo.entity.InstructorDetail;

public class CreatDemo {

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
			//create object
//			Instructor instructor = 
//					new Instructor("noah","tseng","noah.tseng@gmail.com");
//			//associate object
//			InstructorDetail instructorDetail =
//					new InstructorDetail("http://www.yahoo.com.tw","Baseball");

			Instructor instructor = 
					new Instructor("harry","porter","harry.porter@gmail.com");
			//associate object
			InstructorDetail instructorDetail =
					new InstructorDetail("http://www.harryporter.com.tw","MagicPower");
			
			instructor.setInstructorDetail(instructorDetail);
			//start transaction
			session.beginTransaction();
			
			//save instructor
			System.out.println("儲存 instructor....\n" + instructor);
			session.save(instructor);
			 
			//commit transaction
			session.getTransaction().commit();
			System.out.println("完成!");
		}finally {
			factory.close();
		}
	}

}
