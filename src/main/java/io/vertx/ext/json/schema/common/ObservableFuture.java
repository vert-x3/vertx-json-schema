package io.vertx.ext.json.schema.common;

import io.vertx.core.AsyncResult;
import io.vertx.core.Future;
import io.vertx.core.Handler;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class ObservableFuture<T> implements Future<T> {

  final Future<T> delegate;
  final Queue<Handler<AsyncResult<T>>> handlers;

  private ObservableFuture(Future<T> delegate) {
    this.handlers = new ConcurrentLinkedQueue<>();
    this.delegate = delegate;
    this.delegate.setHandler(ar -> {
      while (!this.handlers.isEmpty()) {
        this.handlers.poll().handle(this);
      }
    });
  }

  @Override
  public boolean isComplete() {
    return delegate.isComplete();
  }

  @Override
  public Future<T> setHandler(Handler<AsyncResult<T>> handler) {
    if (delegate.isComplete())
      handler.handle(this);
    else
      handlers.add(handler);
    return this;
  }

  @Override
  public Handler<AsyncResult<T>> getHandler() {
    return handlers.peek();
  }

  @Override
  public T result() {
    return delegate.result();
  }

  @Override
  public Throwable cause() {
    return delegate.cause();
  }

  @Override
  public boolean succeeded() {
    return delegate.succeeded();
  }

  @Override
  public boolean failed() {
    return delegate.failed();
  }

  public static <T> ObservableFuture<T> wrap(Future<T> fut) {
    return new ObservableFuture<>(fut);
  }

}
