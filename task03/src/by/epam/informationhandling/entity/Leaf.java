package by.epam.informationhandling.entity;

public class Leaf implements TextComponent {

    private String text;

    public Leaf(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    @Override
    public void operation() {
        System.out.println("text = " + text);
    }

    @Override
    public TextComponent getChild(int index) {
        return null;
    }

    @Override
    public void remove(TextComponent component) {

    }

    @Override
    public void addElement(TextComponent component) {

    }

    @Override
    public String toString() {
        return "Leaf{" + "text='\n" + text + '\'' + '}';
    }
}
