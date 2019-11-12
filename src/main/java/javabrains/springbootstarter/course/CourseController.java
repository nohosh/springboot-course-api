package javabrains.springbootstarter.course;

import javabrains.springbootstarter.topic.Topic;
import javabrains.springbootstarter.topic.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class CourseController {

    @Autowired
    private CourseService courseService;

    @RequestMapping("/topics/{id}/courses")
    public List<Topic> getAllCourses(@PathVariable String id){
        List<Course> courses = new ArrayList<>();
        courseRepository.findAll();
        return courses;
    }

    @RequestMapping("/topics/{topicId}/courses/{id}")
    public  Course getCourse(@PathVariable String id){
        return courseService.getCourse(id);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/topics/{topicId}/courses")
    public void addCourse(@RequestBody Course course, @PathVariable String topicId){
        course.setTopic(new Topic(topicId, "" , ""));
        courseService.addCourse(course);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/topics/{topicId}/courses/{id}")
    public void updateCourse(@RequestBody Course course,@PathVariable String id,@PathVariable String topicId){
        course.setTopic(new Topic(topicId, "" , ""));
        courseService.updateCourse(course);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/topics/{topicId}/courses/{id}")
    public void deleteTopic(@PathVariable String id){
        courseService.deleteCourse(id);
    }
}
