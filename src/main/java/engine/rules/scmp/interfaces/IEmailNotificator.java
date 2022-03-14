package engine.rules.scmp.interfaces;

public interface IEmailNotificator {
    boolean notifyOwnerViaEmail(String notificationTitle, String NotificationDescription);
}
