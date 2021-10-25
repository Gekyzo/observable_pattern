package com.sandbox.observable;

import com.sandbox.observer.Subscriber;

import java.util.ArrayList;
import java.util.List;

public class YoutubeChannel implements Observable {

  private final List<Subscriber> channelSubscribers = new ArrayList<>();
  private String lastTitle;

  @Override
  public void attach(Subscriber observer) {
    channelSubscribers.add(observer);
  }

  @Override
  public void detach(Subscriber observer) {
    channelSubscribers.remove(observer);
  }

  @Override
  public void sendNotifications(Event event, YoutubeChannel observable) {
    for (Subscriber o : this.channelSubscribers) {
      o.update(event, observable);
    }
  }

  @Override
  public void addNewVideo(String title) {
    this.lastTitle = title;
    System.out.println("New video in Channel: " + title);
    sendNotifications(Event.NEW_VIDEO, this);
  }

  public String getLastTitle() {
    return this.lastTitle;
  }
}
