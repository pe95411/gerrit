package com.google.gerrit.lifecycle;

import com.google.inject.AbstractModule;
import com.google.inject.Singleton;
import com.google.inject.binder.LinkedBindingBuilder;
import com.google.inject.internal.UniqueAnnotations;

import java.lang.annotation.Annotation;

/** Module to support registering a unique LifecyleListener. */
public abstract class LifecycleModule extends AbstractModule {
  /**
   * Create a unique listener binding.
   * <p>
   * To create a listener binding use:
   *
   * <pre>
   * listener().to(MyListener.class);
   * </pre>
   *
   * where {@code MyListener} is a {@link Singleton} implementing the
   * {@link LifecycleListener} interface.
   */
  protected LinkedBindingBuilder<LifecycleListener> listener() {
    final Annotation id = UniqueAnnotations.create();
    return bind(LifecycleListener.class).annotatedWith(id);
  }
}
