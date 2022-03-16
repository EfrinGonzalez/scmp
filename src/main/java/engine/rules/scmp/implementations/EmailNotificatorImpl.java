package engine.rules.scmp.implementations;

import engine.rules.scmp.interfaces.IEmailNotificator;

public class EmailNotificatorImpl implements IEmailNotificator {


    @Override
    public boolean notifyOwnerViaEmail(String notificationTitle, String NotificationDescription) {
        System.out.println(notificationTitle + ":" +NotificationDescription);
        return true;
    }
}
