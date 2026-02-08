package builderpattern.builderintefrace;

public interface ICanAddMainCourse {
    IAfterMainCourse withMainCourse(String mainCourse);
}
