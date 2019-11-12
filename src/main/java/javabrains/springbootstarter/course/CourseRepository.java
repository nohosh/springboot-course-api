package javabrains.springbootstarter.course;

import javabrains.springbootstarter.topic.Topic;
import org.springframework.data.repository.CrudRepository;

public interface CourseRepository extends CrudRepository<Course, String> {

}
