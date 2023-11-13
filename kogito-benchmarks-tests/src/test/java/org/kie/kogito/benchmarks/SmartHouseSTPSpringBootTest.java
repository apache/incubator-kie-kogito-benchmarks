/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
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
package org.kie.kogito.benchmarks;

import java.io.IOException;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;
import org.kie.kogito.benchmarks.framework.App;
import org.kie.kogito.benchmarks.framework.HTTPRequestInfo;

public class SmartHouseSTPSpringBootTest extends AbstractTemplateTest {

    private static final App APP_TO_TEST = App.SMARTHOUSE_STP_SPRING_BOOT_JVM;

    @Test
    public void startStop(TestInfo testInfo) throws IOException, InterruptedException {
        startStop(testInfo, APP_TO_TEST);
    }

    @Test
    public void loadTest(TestInfo testInfo) throws IOException, InterruptedException {
        HTTPRequestInfo requestInfo = HTTPRequestInfo.builder()
                .URI(LOCALHOST + "/smartHouse")
                .body(HTTPRequestInfo.Body.SMARTHOUSE_BPMN_DMN)
                .method("POST")
                .header("Accept", "application/json")
                .header("Content-Type", "application/json")
                .expectedResponseStatusCode(201)
                .build(); // This may be directly replaced for example by Apache-specific class, but this keeps
                                                                                                                                                                                                                                                                                              // it detached from any framework

        loadTest(testInfo, APP_TO_TEST, requestInfo);
    }
}
