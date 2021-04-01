/*
 * Copyright 2014 Red Hat, Inc.
 *
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  and Apache License v2.0 which accompanies this distribution.
 *
 *  The Eclipse Public License is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 *
 *  The Apache License v2.0 is available at
 *  http://www.opensource.org/licenses/apache2.0.php
 *
 *  You may elect to redistribute this code under either of these licenses.
 */

package io.vertx.ext.web.handler;

import io.vertx.codegen.annotations.Fluent;
import io.vertx.codegen.annotations.VertxGen;
import io.vertx.core.Handler;
import io.vertx.ext.web.RoutingContext;

/**
 * Base interface for auth handlers.
 * <p>
 * An auth handler allows your application to provide authentication support.
 * <p>
 * An Auth handler may require a {@link SessionHandler} to be on the routing chain before it.
 *
 * @author <a href="http://tfox.org">Tim Fox</a>
 * @author <a href="mailto:plopes@redhat.com">Paulo Lopes</a>
 */
@VertxGen(concrete = false)
public interface AuthenticationHandler extends Handler<RoutingContext> {

  /**
   * This handler is called to perform any post authentication tasks, such as redirects or assertions.
   * Overrides must call {@link RoutingContext#next()} on success. Implementation must call this handler
   * at the end of the authentication process, or call {@link RoutingContext#next()} when no handler is
   * added.
   *
   * @param postAuthnHandler the routing context handler
   */
  @Fluent
  AuthenticationHandler postAuthenticationHandler(Handler<RoutingContext> postAuthnHandler);
}
