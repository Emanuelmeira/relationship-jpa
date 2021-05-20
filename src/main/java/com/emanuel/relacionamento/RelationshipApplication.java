package com.emanuel.relacionamento;


import com.emanuel.relacionamento.repository.CourseRepository;
import com.emanuel.relacionamento.repository.SubjectRepository;
import org.hibernate.Hibernate;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class RelationshipApplication {

	public static void main(String[] args) {
		SpringApplication.run(RelationshipApplication.class, args);
	}

//	@Bean
//	public CommandLineRunner run() throws Exception {
//		return (String[] args) -> {
//
//		};
//	}


}
