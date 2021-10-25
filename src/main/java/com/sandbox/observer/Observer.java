package com.sandbox.observer;

import com.sandbox.observable.Event;
import com.sandbox.observable.YoutubeChannel;

public interface Observer {

  void update(Event e, YoutubeChannel observable);
}
