package com.cse327.pothik.Help;

import android.app.Application;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import io.smooch.core.Settings;
import io.smooch.core.Smooch;
import io.smooch.core.SmoochCallback;
import io.smooch.core.User;

public class ChatAppp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Smooch.init(this, new Settings("5a3668f58546dc005dc34eb5"), new SmoochCallback() {
            @Override
            public void run(Response response) {

            }
        });
        addSomeProperties(User.getCurrentUser());
    }

    private void addSomeProperties(final User user) {
        final Map<String, Object> customProperties = new HashMap<>();

        user.setFirstName("Pothik");
        user.setLastName("App");
        user.setEmail("sahid@hitbts.com");
        user.setSignedUpAt(new Date(1420070400000l));

        customProperties.put("Last Seen", new Date());
        user.addProperties(customProperties);
    }
}
