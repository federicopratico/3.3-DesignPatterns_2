package builderpattern.builderintefrace;

public interface StarterStep {
    AfterStarterStep withStarter(String starter);
    AfterMainCourseStep withMainCourse(String mainCourse);
}
