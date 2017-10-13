package assignment.model;

public class Customize implements Level{
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
