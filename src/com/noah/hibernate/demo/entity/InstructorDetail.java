package com.noah.hibernate.demo.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column; 
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "instructor_detail")
public class InstructorDetail {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;

	@Column(name = "youtube_channel")
	private String youtube_channel;

	@Column(name = "hobby")
	private String hobby;
	//意指一個Detail(mappedBy)對應一個instructor
	@OneToOne(mappedBy="instructorDetail", 
			cascade= {CascadeType.DETACH,
					  CascadeType.MERGE,
					  CascadeType.PERSIST,
					  CascadeType.REFRESH})//須與Instructor內的OneToOne 底下之屬性同名
	private Instructor instructor;
	
	public Instructor getInstructor() {
		return instructor;
	}

	public void setInstructor(Instructor instructor) {
		this.instructor = instructor;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getYoutube_channel() {
		return youtube_channel;
	}

	public void setYoutube_channel(String youtube_channel) {
		this.youtube_channel = youtube_channel;
	}

	public String getHobby() {
		return hobby;
	}

	public void setHobby(String hobby) {
		this.hobby = hobby;
	}

	@Override
	public String toString() {
		return "InstructorDetail [id=" + id + ", youtube_channel=" + youtube_channel + ", hobby=" + hobby + "]";
	}
	public InstructorDetail() {
		
	}

	public InstructorDetail(String youtube_channel, String hobby) {
		this.youtube_channel = youtube_channel;
		this.hobby = hobby;
	}
	
}
