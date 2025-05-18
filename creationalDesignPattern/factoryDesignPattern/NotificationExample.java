package creationalDesignPattern.factoryDesignPattern;

interface Notification {

  void send();
}

class EmailNotification implements Notification {

  public void send() {
    System.out.println("Notification sent via email. ");
  }
}

class WhatsappNotification implements Notification {

  public void send() {
    System.out.println("Notification sent via whatsapp. ");
  }
}

class TextNotification implements Notification {
  public void send() {
    System.out.println("Notification sent via SMS. ");
  }
}

class NotificationFactory {
  public static Notification getNotification(String mode) {
    if (mode.equalsIgnoreCase("Text")) {
      return new TextNotification();
    } else if (mode.equalsIgnoreCase("Whatsapp")) {
      return new WhatsappNotification();
    } else if (mode.equalsIgnoreCase("Email")) {
      return new EmailNotification();
    }
    throw new IllegalArgumentException("This type of mode of notification is not handles yet: " + mode);
  }
}

class NotificationService {

  public static void notify(String mode) {
    Notification notification = NotificationFactory.getNotification(mode);
    notification.send();
  }
}

public class NotificationExample {

  public static void main(String[] args) {
    NotificationService.notify("email");
    NotificationService.notify("whatsapp");
    NotificationService.notify("Text");
    NotificationService.notify("call");
  }

}
