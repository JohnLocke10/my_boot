import com.huzemaks.MainClass;
import com.huzemaks.course.Course;
import com.huzemaks.course.CourseService;
import com.huzemaks.topic.Topic;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
@SpringBootTest(classes = MainClass.class)
@Transactional
public class CourseServiceIntegrationTest {


    @Autowired
    private CourseService courseService;

    @Test
    public void deleteCoursesTest(){
        Course course = courseService.getCourse("courseId1");
        assertEquals(1, courseService.getAllCourses("topicId1").size());
        courseService.deleteCourse("courseId1");

        assertEquals(0, courseService.getAllCourses("topicId1").size());
        assertEquals("courseDesc1", course.getDescription());
    }

    @Test
    public void addCoursesTest(){
        String topicId1 = "topicId1";
        List<Course> courses = courseService.getAllCourses(topicId1);
        assertEquals(1, courses.size());

        Topic topic1 = new Topic(topicId1, "topicName1", "topicDesc1");
        Course newCourse = new Course("courseId100", "courseName100", "courseDesc100", topicId1);
        newCourse.setTopic(topic1);
        courseService.addCourse(newCourse);

        assertEquals(2, courseService.getAllCourses(topicId1).size());
        courseService.deleteCourse("courseId1");
    }

    @Test
    public void updateCoursesTest(){
        String courseId1 = "courseId1";
        Course course = courseService.getCourse(courseId1);
        assertEquals("courseDesc1" ,course.getDescription());
        String description = "NewDescription";
        course.setDescription(description);
        courseService.updateCourse(course);

        assertEquals(description, courseService.getCourse(courseId1).getDescription());

    }
}
