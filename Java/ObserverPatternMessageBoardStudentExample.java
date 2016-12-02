import java.util.ArrayList;
import java.util.List;

public class ObserverPatternMessageBoardStudentExample {
  public static void main(final String[] args) {
    final MessageBoard messageBoard = new MessageBoard();
    messageBoard.setMessage(
        "No observer has been attached yet so no one will listen/observe.");
    final Teacher teacher = new Teacher();
    messageBoard.registerObserver(teacher);
    messageBoard.setMessage("Teacher will see new message.");
    messageBoard.removeObserver(teacher);
    final Student student = new Student();
    messageBoard.registerObserver(student);
    messageBoard.setMessage("Student will see new message.");
    messageBoard.registerObserver(teacher);
    messageBoard.setMessage("Teacher and Student will see new message.");
  }
}

interface Subject {
  void registerObserver(Observer observer);

  void removeObserver(Observer observer);

  void notifyObservers();
}

interface Observer {
  void update(String message);
}

class MessageBoard implements Subject {

  List<Observer> observers = new ArrayList<Observer>();
  private String message;

  /**
   * @return the message
   */
  public final String getMessage() {
    return message;
  }

  /**
   * @param message
   *          the message to set
   */
  public final void setMessage(final String message) {
    this.message = message;
    this.notifyObservers();
  }

  public void registerObserver(final Observer observer) {
    observers.add(observer);
  }

  public void removeObserver(final Observer observer) {
    observers.remove(observer);
  }

  public void notifyObservers() {
    for (final Observer observer : observers) {
      observer.update(message);
    }
  }
}

class Student implements Observer {
  public void update(final String message) {
    System.out.println("Student received a new message : " + message);
  }
}

class Teacher implements Observer {
  public void update(final String message) {
    System.out.println("Teacher received a new message : " + message);
  }
}
