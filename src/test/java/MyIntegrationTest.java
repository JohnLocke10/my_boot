import com.huzemaks.MainClass;
import com.huzemaks.course.Course;
import com.huzemaks.course.CourseService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
@SpringBootTest(classes = MainClass.class)
public class MyIntegrationTest {


    @Autowired
    private CourseService courseService;

    @Test
    public void test(){
        Course course = courseService.getCourse("courseId1");

        assertEquals(1, courseService.getAllCourses("topicId1").size());
        courseService.deleteCourse("courseId1");
        //courseService.deleteCourse("courseId2");
        assertEquals(0, courseService.getAllCourses("topicId1").size());
        assertEquals("courseDesc1", course.getDescription());
    }
}
