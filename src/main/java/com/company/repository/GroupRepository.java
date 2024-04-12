package com.company.repository;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.company.entity.Group;
import com.company.utils.Hibernateutils;

public class GroupRepository {
	private Hibernateutils hibernateutils;

	public GroupRepository() {
		hibernateutils = Hibernateutils.getInstance();
	}

	@SuppressWarnings("unchecked")
	public List<Group> getAllGroups() {
		Session session = null;

		try {
			// get Session
			session = hibernateutils.openSession();

			// create hql query
			Query<Group> query = session.createQuery("FROM Group");

			// return result
			return query.list();
		} finally {
			session.close();
		}
	}

	// CRUD Group
	public Group getGroupByID(Integer id) {
		Session session = null;

		try {
			// get Session
			session = hibernateutils.openSession();

			// create hql query
			Group group = session.get(Group.class, id);

			// return result
			return group;
		} finally {
			session.close();
		}
	}

	@SuppressWarnings("unchecked")
	public Group getGroupByName(String name) {
		Session session = null;

		try {
			// get Session
			session = hibernateutils.openSession();

			// create hql query
			Query<Group> query = session.createQuery("FROM Group WHERE name = :nameParameter");
			
			
			// set Parameter
			query.setParameter("nameParameter", name);
			
			// return result
			Group group = query.uniqueResult();
			return group;
		} finally {
			session.close();
		}
	}
	
	public void createGroup (Group group) {
		Session session = null;

		try {
			// get Session
			session = hibernateutils.openSession();

			// create
			session.save(group);
		} finally {
			session.close();
		}
	}
	
	public void updateGroup (Integer id, String newName) {
		Session session = null;

		try {
			// get Session
			session = hibernateutils.openSession();
			session.beginTransaction();

			// get Group
			Group group = (Group) session.load(Group.class, id);
			
			
			// update
			group.setName(newName);
			session.getTransaction().commit();
		} finally {
			session.close();
		}
	}
	
	public void deleteGroup (Integer id) {
		Session session = null;

		try {
			// get Session
			session = hibernateutils.openSession();
			session.beginTransaction();

			// get Group
			Group group = (Group) session.load(Group.class, id);
			
			
			// delete
			session.delete(group);
			session.getTransaction().commit();
		} finally {
			session.close();
		}
	}

}
