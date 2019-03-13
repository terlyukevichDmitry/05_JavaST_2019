package by.epam.informationhandling.entity;

public class Leaf implements TextComponent {

    private String string;

    public Leaf(final String str) {
        this.string = str;
    }

    @Override
    public void addElement(TextComponent component) {
        System.out.println("Leaf -> add. Doing nothing");
        throw new UnsupportedOperationException();
    }

    @Override
    public TextComponent getChild(int index) {
        return this;
    }

    @Override
    public void operation() {
        System.out.println("Leaf-> Perf operation");
    }

    @Override
    public void remove(TextComponent component) {
        System.out.println("Leaf -> remove. Doing nothing");
        throw new UnsupportedOperationException();
    }

    @Override
    public String toString() {
        return "Leaf{} + = \n" + string;
    }
}
