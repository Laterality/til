package kr.latera.hello_jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import kr.latera.hello_jpa.entity.Member;
import kr.latera.hello_jpa.entity.Team;

public class Main {
	
	public static void init(EntityManager em) {
		em.getTransaction().begin();
		em.persist(new Member("A"));
		em.persist(new Member("B"));
		em.persist(new Member("C"));
		em.persist(new Member("D"));
		em.persist(new Member("E"));
		em.persist(new Member("F"));
		em.getTransaction().commit();
	}

	public static void main(String[] args) {
		// emf는 전체 애플리케이션에서 하나만 생성되어야 한다.
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
		
		// 요청 하나가 처리되는 프로세스
		// em은 스레드 간 공유하면 안됨
		EntityManager em = emf.createEntityManager();
		
		init(em);
		
		// 데이터의 변경은 트랜잭션 안에서 발생해야 함
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		
		try {	
			
			Team team = new Team();
			team.setName("teamA");
			em.persist(team);
			
			Member member = new Member();
			member.setName("홍길동");
//			member.setTeamId(team.getId());
			member.setTeam(team);
			em.persist(member);
			
			//
			em.flush();
			em.clear();
			
			// 객체를 테이블에 맞춰서 모델링한 경우
			// 식별자를 가지고 Team 테이블에 다시 조회해야 함
			Member foundMember = em.find(Member.class, member.getId());
//			Long teamId = foundMember.getTeamId();
			Team t = em.find(Team.class, team.getId());
			
//			Team foundTeam = em.find(Team.class, teamId);
//			t.getMembers().add(foundMember);
//			System.out.println(t.getMembers().size());
			
			em.flush();
			em.clear();
			
			Member m1 = em.find(Member.class, 1L);
			
			List<Member> members = em.createQuery("select m from Member m ")
					.setFirstResult(0)
					.setMaxResults(2)
					.getResultList();
			
			
			for(Member m : members) {
				System.out.println(m.getId());
			}
			
			System.out.println(m1 == members.get(0));
			
			
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
		} finally {
			em.close();
		}
		
		
		
		emf.close();
	}
}
