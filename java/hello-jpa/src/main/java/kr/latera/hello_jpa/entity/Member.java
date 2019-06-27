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
	// �ش� Į���� �� ���� ���
	// AUTO: DB�� ���� ���� ����� �ڵ����� ����, �⺻��.
	// IDENTITY: ���� ����� DB�� ����, for MYSQL.
	// SEQUENCE: DB�� ������ ������Ʈ ���, for ORACLE. @SequenceGenerator �ʿ�.
	// TABLE: Ű ������ ���̺� ���, ��� DB. @TableGenerator �ʿ�.
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Column(name="name")
	private String name;
	private int age;
	
//	@Column(name="TEAM_ID")
//	private Long teamId;
	
	// LAZY: �ش� ��ü�� ������ ���� �� ��ȸ
	// EAGER: �� ��ü�� ��ȸ�� �� ���� ��ȸ
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="TEAM_ID")
	private Team team;
	

	// LocalDateTime, LocalDate Ÿ���� @Temporal ���� ���
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
