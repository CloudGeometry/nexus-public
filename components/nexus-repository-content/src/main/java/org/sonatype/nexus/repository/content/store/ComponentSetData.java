/*
 * Sonatype Nexus (TM) Open Source Version
 * Copyright (c) 2008-present Sonatype, Inc.
 * All rights reserved. Includes the third-party code listed at http://links.sonatype.com/products/nexus/oss/attributions.
 *
 * This program and the accompanying materials are made available under the terms of the Eclipse Public License Version 1.0,
 * which accompanies this distribution and is available at http://www.eclipse.org/legal/epl-v10.html.
 *
 * Sonatype Nexus (TM) Professional Version is available from Sonatype, Inc. "Sonatype" and "Sonatype Nexus" are trademarks
 * of Sonatype, Inc. Apache Maven is a trademark of the Apache Software Foundation. M2eclipse is a trademark of the
 * Eclipse Foundation. All other trademarks are the property of their respective owners.
 */
package org.sonatype.nexus.repository.content.store;

import org.sonatype.nexus.common.entity.ContinuationAware;
import org.sonatype.nexus.repository.content.ComponentSet;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * {@link ComponentSet} data backed by the content data store.
 */
public class ComponentSetData
    implements ComponentSet, ContinuationAware
{
  protected String namespace;

  protected String name;

  @Override
  public String namespace() {
    return namespace;
  }

  @Override
  public String name() {
    return name;
  }

  // MyBatis setters + validation

  /**
   * Sets the component namespace.
   */
  public void setNamespace(final String namespace) {
    this.namespace = checkNotNull(namespace);
  }

  /**
   * Sets the component name.
   */
  public void setName(final String name) {
    this.name = checkNotNull(name);
  }

  // ContinuationAware

  @Override
  public String nextContinuationToken() {
    return namespace + '|' + name;
  }

  @Override
  public String toString() {
    return "ComponentSet {" +
        "namespace='" + namespace + "'" +
        ", name='" + name + "'" +
        "} " + super.toString();
  }
}
