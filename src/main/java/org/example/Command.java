package org.example;

public class Command {
    private CommandType commandType;
    private Integer id;
    private Person person;

    public Command(CommandType commandType, Integer id, Person person) {
        this.commandType = commandType;
        this.id = id;
        this.person = person;
    }
    public Command(CommandType commandType, Person person) {
        this.commandType = commandType;
        this.id = null;
        this.person = person;
    }
    public Command(CommandType commandType, Integer id) {
        this.commandType = commandType;
        this.id = id;
        this.person = null;
    }
    public Command(CommandType commandType) {
        this.commandType = commandType;
        this.id = null;
        this.person = null;
    }

    public CommandType getCommandType() {
        return commandType;
    }

    public void setCommandType(CommandType commandType) {
        this.commandType = commandType;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Person getPerson() {
        return person;
    }

    public void setValue(Person person) {
        this.person = person;
    }

    @Override
    public String toString() {
        return "Command{" +
                "commandType=" + commandType +
                ", id=" + id +
                ", person='" + person + '\'' +
                '}';
    }
}
