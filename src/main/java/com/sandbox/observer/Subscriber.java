package com.sandbox.observer;

import com.sandbox.observable.Event;
import com.sandbox.observable.YoutubeChannel;

public class Subscriber implements Observer {

  private final YoutubeChannel observable;

  public Subscriber(final YoutubeChannel observable) {
    this.observable = observable;
  }

  @Override
  public void update(Event e, YoutubeChannel observable) {
    System.out.println(
        "New event of type: " + e.toString() + " with value: " + observable.getLastTitle());
  }
}
