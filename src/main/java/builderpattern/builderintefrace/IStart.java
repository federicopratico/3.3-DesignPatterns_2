package builderpattern.builderintefrace;

public interface IStart extends ICanAddMainCourse{
    IAfterStarter withStarter(String starter);
}
