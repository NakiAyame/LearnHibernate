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

}
