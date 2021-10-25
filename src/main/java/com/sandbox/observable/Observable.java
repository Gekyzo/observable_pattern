package com.sandbox.observable;

import com.sandbox.observer.Subscriber;

public interface Observable {

  void attach(Subscriber observer);

  void detach(Subscriber observer);

  void sendNotifications(Event event, YoutubeChannel observable);

  void addNewVideo(String title);
}
