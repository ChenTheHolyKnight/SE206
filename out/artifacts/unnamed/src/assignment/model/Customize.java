package assignment.model;

public class Customize implements Level{
    //This class will be deleted later
    private Levels _levels=Levels.CUSTOMIZE;


    @Override
    public int generateNumber() {
        return 0;
    }

    @Override
    public Levels getLevels() {
        return _levels;
    }

    @Override
    public String generateFormula() {
        return null;
    }
}
