package rs.ac.bg.fon.ps.communication;

import java.io.Serializable;
import rs.ac.bg.fon.ps.domain.User;

public class Request implements Serializable {
    private Operation operation;
    private Object argument;
    private User user;

    public Request() {
    }

    public Request(Operation operation, Object argument, User user) {
        this.operation = operation;
        this.argument = argument;
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Operation getOperation() {
        return operation;
    }

    public void setOperation(Operation operation) {
        this.operation = operation;
    }

    public Object getArgument() {
        return argument;
    }

    public void setArgument(Object argument) {
        this.argument = argument;
    }
}
