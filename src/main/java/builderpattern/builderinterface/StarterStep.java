package builderpattern.builderinterface;

public interface StarterStep {
    AfterStarterStep withStarter(String starter);
    AfterMainCourseStep withMainCourse(String mainCourse);
}
