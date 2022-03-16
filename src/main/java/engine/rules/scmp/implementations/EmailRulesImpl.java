package engine.rules.scmp.implementations;

import engine.rules.scmp.interfaces.IEmailRules;

public class EmailRulesImpl implements IEmailRules {


    @Override
    public boolean notifyOwnerViaEmail(String notificationTitle, String NotificationDescription) {
        System.out.println(notificationTitle + ":" +NotificationDescription);
        return true;
    }
}
