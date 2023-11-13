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
package org.kie.kogito.benchmarks.framework;

import java.io.File;

public class BuildResult {

    private final long buildTimeMs;
    private final File buildLog;
    private final int exitCode;

    public BuildResult(long buildTimeMs, File buildLog, int exitCode) {
        this.buildTimeMs = buildTimeMs;
        this.buildLog = buildLog;
        this.exitCode = exitCode;
    }

    public long getBuildTimeMs() {
        return buildTimeMs;
    }

    public File getBuildLog() {
        return buildLog;
    }

    public int getExitCode() {
        return exitCode;
    }
}
