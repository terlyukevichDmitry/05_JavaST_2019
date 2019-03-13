package by.epam.informationhandling.entity;

public class Client {
    private TextComponent component;

    public Client(TextComponent textComponent) {
        this.component = textComponent;
    }

    public void execute() {
        component.operation();
    }
}
