package com.yolo.demo;

import com.yolo.annotations.EnableGraph;
import com.yolo.generated.Graph;

@EnableGraph(lazyBeans = {User.class, Database.class})
public class Main {

	public static void main(String[] args) {

		Graph.getInstance().user(User.bishoy());
		Graph.getInstance().database(new Oracle(User.bishoy()));

		Screen screen = new Screen();
		System.out.println(screen.activityOne.getServiceRegistration().getRepositoryUsers().getDatabase().type());

	}

}
