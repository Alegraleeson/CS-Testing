import org.junit.Rule;
import org.junit.Test;
import org.mockito.*;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import java.util.Arrays;
import java.util.List;

import static com.sun.org.apache.xerces.internal.util.PropertyState.is;
import static ord.junit.Assert.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.matchers.JUnitMatchers.hasItems;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

a

public class EducationServiceTest {

    public class educationServiceTest {

        @Rule
        public MockitoRule mockitoRule = MockitoJUnit.rule();

        @Mock
        private StudentDataObject studentDataObject;

        @Mock
        private InstructorDataObject instructorDataObject;

        @Mock
        private ClassDataObject classDataObject;

        @InjectMocks
        private ClientBusinessObjectImpl clientBusinessObjectImpl;

        @Test
        public void testStudentsByClass() {

            Student studentJM = new Student(“Joy Ma”, “Spanish);
            Student studentJH = new Student(“Julio Hernandez”, “Algebra”);
            Student studentJJ = new Student(“Jenny Jones”, “Calculus”);
            List<Student> allStudents = Arrays.asList(studentJM, studentJH, studentJJ);

            given(studentDataObject.getAllStudents()).willReturn(allStudents);

            List<String> mathStudents = clientBusinessObjectImpl.getAllStudentsBySubject(“math”);

            assertThat(mathStudents.size(), is(2));
            assertThat(mathStudents, hasItems(studentJJ, student JH);
        }

        @Test
        public void testMarkInactive() {

            Class geometry = new Class("Geometry”, “Summer 2022");
            Class envSci = new Class("Environmental Science”, “Fall 2022");
            Class compLit = new Class("Comparative Literature”, “Spring 2023”);
            List<Class> allClasses = Arrays.asList(geometry, envSci, compLit);

            given(classDataObject.getAllClasses()).willReturn(allClasses);

            clientBusinessObjectImpl.markCurrentClassesInactive();

            verify(classDataObject).markInactive(geometry);

            verify(classDataObject, Mockito.never()).markInactive(envSci);

            verify(classDataObject, Mockito.never()).markInactive(compLit);

            verify(classDataObject, Mockito.times(1)).markInactive(geometry);

        }

        @Captor
        ArgumentCaptor<Class> classArgumentCaptor;

        @Test
        public void testMarkInactive_argumentCaptor() {

            Class geometry = new Class("Geometry”, “Summer 2022");
            Class envSci = new Class("Environmental Science”, “Fall 2022");
            Class compLit = new Class("Comparative Literature”, “Spring 2023");
            List<Class> allClasses = Arrays.asList(geometry, envSci, compLit);

            given(classDataObject.getAllClasses()).willReturn(allClasses);

            clientBusinessObjectImpl.markCurrentClassesInactive();

            verify(classDataObject).markInactive(classArgumentCaptor.capture());

            assertEquals(geometry, classArgumentCaptor.getValue());
        }

        @Test
        public void testMarkGet() {

            Class geometry = new Class("Geometry”, “Summer 2022");
            Class envSci = new Class("Environmental Science”, “Fall 2022");
            Class compLit = new Class("Comparative Literature”, “Spring 2023");
            List<Class> allClasses = Arrays.asList(geometry, envSci, compLit);

            given(classDataObject.getAllClasses()).willReturn(allClasses);
            given(InstructorDataObject.getClassesByInstructor(instructor_id).willReturn(allClasses.instructor_id));
            given(ClassDataObject.getStudentsInClass(class_id).willReturn(allStudents.class_id));

            // When
            clientBusinessObjectImpl.markCurrentClassesInactive();

            // Then
            verify(classDataObject).markInactive(geometry);

            verify(classDataObject, Mockito.never()).markInactive(envSci);

            verify(classDataObject, Mockito.never()).markInactive(compLit);

            verify(classDataObject, Mockito.times(1)).markInactive(geometry);
            // atLeastOnce, atLeast

        }

        @Test
        public void testStudentsByClass() {
            // Given
            Student studentJM = new Student("Joy Ma”, “Spanish");
            Student studentJH = new Student("Julio Hernandez”, “Algebra");
            Student studentJJ = new Student("Jenny Jones”, “Calculus");
            List<Student> allStudents = Arrays.asList(studentJM, studentJH, studentJJ);

            given(classDataObject.getAllStudents(class_id)).willReturn(allStudents);

            // When
            List<String> mathStudents = clientBusinessObjectImpl.getAllStudentsByClass_Id("1");

            // Then
            assertThat(mathStudents.size(), is(2));
            assertThat(mathStudents, hasItems(studentJJ, studentJH);
        }

    }
}
