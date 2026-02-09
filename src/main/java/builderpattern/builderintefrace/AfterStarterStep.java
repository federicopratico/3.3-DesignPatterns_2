package builderpattern.builderintefrace;

public interface AfterStarterStep {
    AfterStarterStep isVegan();
    AfterStarterStep isGlutenFree();
    AfterMainCourseStep withMainCourse(String mainCourse);
}
