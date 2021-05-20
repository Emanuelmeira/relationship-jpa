package com.emanuel.relacionamento.domain;

import com.emanuel.relacionamento.repository.CourseRepository;
import com.emanuel.relacionamento.repository.DepartmentRepository;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Set;

@RunWith(SpringRunner.class)
@SpringBootTest
class DepartmentTest {

	@Autowired
	DepartmentRepository departmentRepository;

	@Autowired
	CourseRepository courseRepository;

	@Test
	void findAll() {

		List<Department> list = departmentRepository.findAll();
		list.forEach(x -> System.out.println(x.getId() +" " + x.getName()));
		Assert.assertEquals(list.size(), 5);
	}

	@Test
	void add() {
		Department department = new Department();
		department.setName("Departamento de Geografias");

		var departament2 = departmentRepository.save(department);
		System.out.println(departament2.getId());
		Assert.assertEquals(department.getName(), departament2.getName());
	}

	@Test
	void findAllCourse() {

		var department = departmentRepository.findById(4l);

		department.ifPresent(d -> {
			Set<Course> list = courseRepository.findByDepartment(d);
			list.forEach(x -> System.out.println(x.getName()));
		});
	}

	@Test
	void edit() {

		departmentRepository.findById(2l).ifPresent(department -> {
			department.setName("Departamento de Dados");
			departmentRepository.save(department);
		});
	}

	@Test
	void remove() {

		Department department = new Department();
		department.setName("Teste Departamento");
		departmentRepository.save(department);

		departmentRepository.delete(department);
	}

	@Test
	void removeWithChildExisting() {

		// um erro sera lançado e pecisar ser tratato

		try{
			departmentRepository.deleteById(1l);

		}catch (DataIntegrityViolationException e){
			System.out.println(e.getCause());
			System.out.println(e.getMessage());
		}
	}

}
