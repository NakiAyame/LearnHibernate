package com.company.program;

import java.util.List;

import com.company.entity.Group;
import com.company.repository.GroupRepository;

public class Program {
	public static void main(String[] args) {
		GroupRepository groupRepository = new GroupRepository();
		
		System.out.println("************* GET ALL GROUPS *************");
		
		List<Group> groups = groupRepository.getAllGroups();
		
		for(Group group: groups) {
			System.out.println(group);
		}
	}
}
