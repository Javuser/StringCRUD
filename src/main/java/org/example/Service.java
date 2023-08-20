package org.example;

public class Service {

    private final PersonDAO personDAO;

    public Service(PersonDAO personDAO) {
        this.personDAO = personDAO;
    }

    public void execute(Command command) throws Exception {
        switch (command.getCommandType()) {
            case GET -> getById(command);
            case CREATE -> add(command);
            case UPDATE -> update(command);
            case DELETE -> delete(command);
            case GET_ALL -> getAll();
        }

    }

    private void getById(Command command){
        System.out.println(personDAO.getPersonById(command.getId()));
    }

    private void add(Command command){
        personDAO.addPerson(command.getPerson());
        System.out.println("saved to db");
    }

    private void update(Command command){
        personDAO.update(command.getPerson(), command.getId());
        System.out.println("updated in db with id = " + command.getId());
    }

    private void delete(Command command){
        personDAO.deleteById(command.getId());
        System.out.println("deleted from hashmap with id = " + command.getId());
    }

    private void getAll() throws Exception {
        personDAO.getAll().forEach((key, value) -> System.out.printf("%s: %s%n", key, value));
    }
}
