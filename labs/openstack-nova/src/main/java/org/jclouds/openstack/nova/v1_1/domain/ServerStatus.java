/**
 * Licensed to jclouds, Inc. (jclouds) under one or more
 * contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  jclouds licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.jclouds.openstack.nova.v1_1.domain;

import org.jclouds.compute.domain.NodeState;

/**
 * Servers contain a status attribute that can be used as an indication of the
 * current server state. Servers with an ACTIVE status are available for use.
 * 
 * Other possible values for the status attribute include: BUILD, REBUILD,
 * SUSPENDED, RESIZE, VERIFY_RESIZE, REVERT_RESIZE, PASSWORD, REBOOT,
 * HARD_REBOOT, DELETED, UNKNOWN, and ERROR.
 * 
 * @author Adrian Cole
 */
public enum ServerStatus {

   ACTIVE       (NodeState.RUNNING),
   BUILD        (NodeState.PENDING),
   REBUILD      (NodeState.PENDING),
   SUSPENDED    (NodeState.SUSPENDED),
   RESIZE       (NodeState.PENDING),
   VERIFY_RESIZE(NodeState.PENDING),
   REVERT_RESIZE(NodeState.PENDING),
   PASSWORD     (NodeState.PENDING),
   REBOOT       (NodeState.PENDING),
   HARD_REBOOT  (NodeState.PENDING),
   DELETED      (NodeState.TERMINATED),
   UNKNOWN      (NodeState.UNRECOGNIZED),
   ERROR        (NodeState.ERROR),
   UNRECOGNIZED (NodeState.UNRECOGNIZED);

   private final NodeState nodeState;

   ServerStatus(NodeState nodeState) {
       this.nodeState = nodeState;
   }

   public String value() {
      return name();
   }

   public static ServerStatus fromValue(String v) {
      try {
         return valueOf(v);
      } catch (IllegalArgumentException e) {
         return UNRECOGNIZED;
      }
   }

    public NodeState getNodeState()
    {
        return nodeState;
    }
}
