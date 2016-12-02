/**
 * Client.
 * @author cdacr
 */
public class CommandPatternExample {
  public static void main(final String[] args) {
    final SmartPhoneController spc = new SmartPhoneController();
    final SmartPhone smartPhone = new SmartPhone();
    final LockCommand lockCommand = new LockCommand();
    lockCommand.setSmartPhone(smartPhone);
    spc.setCommand(lockCommand);
    lockCommand.execute();

    final UnlockCommand unlockCommand = new UnlockCommand();
    unlockCommand.setSmartPhone(smartPhone);
    spc.setCommand(unlockCommand);
    unlockCommand.execute();

  }
}

/**
 * @author cdacr Receiver class.
 */
class SmartPhone {
  private boolean lockFlag;

  public void lock() {
    lockFlag = true;
    System.out.println("Locked");
  }

  public void unlock() {
    lockFlag = false;
    System.out.println("Unlocked");
  }

  public boolean isLockFlag() {
    return lockFlag;
  }
}

interface Command {
  void execute();
}

class LockCommand implements Command {
  SmartPhone smartPhone;

  public final SmartPhone getSmartPhone() {
    return smartPhone;
  }

  public final void setSmartPhone(final SmartPhone smartPhone) {
    this.smartPhone = smartPhone;
  }

  public void execute() {
    smartPhone.lock();
  }
}

class UnlockCommand implements Command {
  SmartPhone smartPhone;

  public final SmartPhone getSmartPhone() {
    return smartPhone;
  }

  public final void setSmartPhone(final SmartPhone smartPhone) {
    this.smartPhone = smartPhone;
  }

  public void execute() {
    smartPhone.unlock();
  }
}

class SmartPhoneController {
  private Command command;

  public void setCommand(final Command command) {
    this.command = command;
  }

  public void pressButton() {
    command.execute();
  }
}