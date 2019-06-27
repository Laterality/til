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
		// emf�� ��ü ���ø����̼ǿ��� �ϳ��� �����Ǿ�� �Ѵ�.
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
		
		// ��û �ϳ��� ó���Ǵ� ���μ���
		// em�� ������ �� �����ϸ� �ȵ�
		EntityManager em = emf.createEntityManager();
		
		init(em);
		
		// �������� ������ Ʈ����� �ȿ��� �߻��ؾ� ��
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		
		try {	
			
			Team team = new Team();
			team.setName("teamA");
			em.persist(team);
			
			Member member = new Member();
			member.setName("ȫ�浿");
//			member.setTeamId(team.getId());
			member.setTeam(team);
			em.persist(member);
			
			//
			em.flush();
			em.clear();
			
			// ��ü�� ���̺� ���缭 �𵨸��� ���
			// �ĺ��ڸ� ������ Team ���̺� �ٽ� ��ȸ�ؾ� ��
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
