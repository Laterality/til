package kr.latera.hello_jpa.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Member {
	 
	@Id 
	// 해당 칼럼의 값 생성 방법
	// AUTO: DB에 따라 생성 방법을 자동으로 결정, 기본값.
	// IDENTITY: 생성 방법을 DB에 위임, for MYSQL.
	// SEQUENCE: DB의 시퀀스 오브젝트 사용, for ORACLE. @SequenceGenerator 필요.
	// TABLE: 키 생성용 테이블 사용, 모든 DB. @TableGenerator 필요.
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Column(name="name")
	private String name;
	private int age;
	
//	@Column(name="TEAM_ID")
//	private Long teamId;
	
	// LAZY: 해당 객체가 실제로 사용될 때 조회
	// EAGER: 이 객체가 조회될 때 같이 조회
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="TEAM_ID")
	private Team team;
	

	// LocalDateTime, LocalDate 타입은 @Temporal 없이 사용
	@Column(name="created_at", nullable=false) 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private LocalDateTime createdAt = LocalDateTime.now();
	
	public Member() {}
	public Member(String name) {
		this.name = name;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Team getTeam() {
		return team;
	}
	public void setTeam(Team team) {
		this.team = team;
	}
	
}
