package builderpattern.builderintefrace;

public interface IAfterStarter extends ICanAddMainCourse {
    IAfterStarter isVegan();
    IAfterStarter isGlutenFree();
}
