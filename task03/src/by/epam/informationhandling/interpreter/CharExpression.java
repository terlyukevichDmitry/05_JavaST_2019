package by.epam.informationhandling.interpreter;

public class CharExpression implements Expression {
    int number;

    public CharExpression(int number) {
        this.number = number;
    }

    @Override
    public Integer interpret() {
        return null;
    }
}
