/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to you under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.calcite.adapter.elasticsearch2;

import com.google.common.base.Preconditions;

import org.elasticsearch.client.Client;
import org.elasticsearch.common.transport.TransportAddress;
import org.junit.rules.ExternalResource;

/**
 * Used to initialize a single elastic node. For performance reasons (node startup costs),
 * same instance is usually shared across multiple tests.
 *
 * This rule should be used as follows:
 * <pre>
 *
 *  public class MyTest {
 *    &#64;ClassRule
 *    public static final ElasticSearchRule RULE = ElasticSearchRule.create();
 *
 *    &#64;BeforeClass
 *    public static void setup() {
 *       // ... populate instance
 *    }
 *
 *    &#64;Test
 *    public void myTest() {
 *      TransportAddress address = RULE.httpAddress();
 *      // .... (connect)
 *    }
 * }
 * </pre>
 *
 * @see ExternalResource
 */
class EmbeddedElasticRule extends ExternalResource {

  private final EmbeddedElasticsearchNode node;

  private EmbeddedElasticsearchPolicy(EmbeddedElasticsearchNode resource) {
    this.node = Preconditions.checkNotNull(resource, "resource");
  }

  @Override protected void before() throws Throwable {
    node.start();
  }

  @Override protected void after() {
    try {
      node.close();
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }

  /**
   * Factory method to create this rule.
   *
   * @return new rule instance to be used in unit tests
   */
<<<<<<< HEAD:elasticsearch2/src/test/java/org/apache/calcite/adapter/elasticsearch2/EmbeddedElasticRule.java
  public static EmbeddedElasticRule create() {
    return new EmbeddedElasticRule(EmbeddedElasticNode.create());
=======
  public static EmbeddedElasticsearchPolicy create() {
    return new EmbeddedElasticsearchPolicy(EmbeddedElasticsearchNode.create());
>>>>>>> 54c598206... more 2380:elasticsearch5/src/test/java/org/apache/calcite/adapter/elasticsearch5/EmbeddedElasticsearchPolicy.java
  }

  /**
   * Exposes current ES transport client.
   *
   * @return initialized instance of ES
   */
  Client client() {
    return node.client();
  }

  /**
   * HTTP address for rest clients (can be ES native or any other).
   *
<<<<<<< HEAD:elasticsearch2/src/test/java/org/apache/calcite/adapter/elasticsearch2/EmbeddedElasticRule.java
   * @return HTTP hostname/port to connect to this ES instance
=======
   * @return {@code HTTP} connection parameters
>>>>>>> 54c598206... more 2380:elasticsearch5/src/test/java/org/apache/calcite/adapter/elasticsearch5/EmbeddedElasticsearchPolicy.java
   */
  TransportAddress httpAddress() {
    return node.httpAddress();
  }
}

// End EmbeddedElasticRule.java
