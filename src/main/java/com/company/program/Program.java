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
		
		System.out.println("************* GET GROUP BY ID *************");
		Group groupByID = groupRepository.getGroupByID(2);
		System.out.println(groupByID);
		
		System.out.println("************* GET GROUP BY NAME *************");
		Group groupByName = groupRepository.getGroupByName("Java");
		System.out.println(groupByName);
		
		System.out.println("************* CREATE GROUP  *************");
		Group groupForCreate = new Group();
		groupForCreate.setName("NodeJS");
		groupRepository.createGroup(groupForCreate);
		System.out.println("Sau khi thêm Group: " + groups);
		
		System.out.println("************* UPDATE GROUP  *************");
		groupRepository.updateGroup(2, "Chuyen Java sang Ruby");
		System.out.println("Sau khi sửa Group 2: " + groups);
		
		System.out.println("************* DELETE GROUP  *************");
		groupRepository.deleteGroup(4);
		System.out.println("Sau khi xoá Group là 4: " + groups);
		
	}
}
