package com.orpheus.OnlineStore;

import com.orpheus.OnlineStore.entity.UsersEntity;
import com.orpheus.OnlineStore.repository.UsersEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

@SpringBootApplication
public class OrpheusOnlineStoreApplication {

	@Autowired
	private UsersEntityRepository usersEntityRepository;

	public static void main(String[] args) {
		SpringApplication.run(OrpheusOnlineStoreApplication.class, args);
	}

	@EventListener(ApplicationReadyEvent.class)
	public void testRepository() {
		UsersEntity u = new UsersEntity();
		u.setAddress("address");
		u.setName("name");
		u.setPhone("phone");
		u.setEmail("user@example.com");
		usersEntityRepository.save(u);
	}
}
