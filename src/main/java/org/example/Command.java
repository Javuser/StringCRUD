package org.example;

public class Command {
    private CommandType commandType;
    private Integer id;
    private String value;

    public Command(CommandType commandType, Integer id, String value) {
        this.commandType = commandType;
        this.id = id;
        this.value = value;
    }
    public Command(CommandType commandType, String value) {
        this.commandType = commandType;
        this.id = null;
        this.value = value;
    }
    public Command(CommandType commandType, Integer id) {
        this.commandType = commandType;
        this.id = id;
        this.value = null;
    }
    public Command(CommandType commandType) {
        this.commandType = commandType;
        this.id = null;
        this.value = null;
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

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Command{" +
                "commandType=" + commandType +
                ", id=" + id +
                ", value='" + value + '\'' +
                '}';
    }
}
