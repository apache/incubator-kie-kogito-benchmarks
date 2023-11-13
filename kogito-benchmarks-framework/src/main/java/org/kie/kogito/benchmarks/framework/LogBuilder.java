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

import java.util.Objects;

public class LogBuilder {

    public static class Log {
        public final String headerCSV;
        public final String headerMarkdown;
        public final String lineCSV;
        public final String lineMarkdown;

        public Log(String headerCSV, String headerMarkdown, String lineCSV, String lineMarkdown) {
            this.headerCSV = headerCSV;
            this.headerMarkdown = headerMarkdown;
            this.lineCSV = lineCSV;
            this.lineMarkdown = lineMarkdown;
        }
    }

    private static final String buildTimeMsHeader = "buildTimeMs";
    private long buildTimeMs = -1L;
    private static final String timeToFirstOKRequestMsHeader = "timeToFirstOKRequestMs";
    private long timeToFirstOKRequestMs = -1L;
    private static final String timeToReloadedOKRequestHeader = "timeToReloadMs";
    private long timeToReloadedOKRequest = -1L;
    private static final String startedInMsHeader = "startedInMs";
    private long startedInMs = -1L;
    private static final String stoppedInMsHeader = "stoppedInMs";
    private long stoppedInMs = -1L;
    private static final String rssKbHeader = "RSSKb";
    private long rssKb = -1L;
    private static final String rssKbFinalHeader = "RSSKbFinal";
    private static final String avgResponseTimeHeader = "avgResponseTimeMs";
    private static final String firstResponseTimeHeader = "firstResponseTimeMs";
    private static final String totalDurationHeader = "totalDurationS";
    private long rssKbFinal = -1L;
    private double avgResponseTime = -1.0;
    private double firstResponseTime = -1.0;
    private double totalDuration = -1.0;
    private static final String openedFilesHeader = "FDs";
    private long openedFiles = -1L;
    private static final String appHeader = "App";
    private App app = null;
    private static final String modeHeader = "Mode";
    private MvnCmds mode = null;

    public LogBuilder buildTimeMs(long buildTimeMs) {
        if (buildTimeMs <= 0) {
            throw new IllegalArgumentException("buildTimeMs must be a positive long, was: " + buildTimeMs);
        }
        this.buildTimeMs = buildTimeMs;
        return this;
    }

    public LogBuilder timeToFirstOKRequestMs(long timeToFirstOKRequestMs) {
        if (timeToFirstOKRequestMs <= 0) {
            throw new IllegalArgumentException("timeToFirstOKRequestMs must be a positive long, was: " + timeToFirstOKRequestMs);
        }
        this.timeToFirstOKRequestMs = timeToFirstOKRequestMs;
        return this;
    }

    public LogBuilder timeToReloadedOKRequest(long timeToReloadedOKRequest) {
        if (timeToReloadedOKRequest <= 0) {
            throw new IllegalArgumentException("timeToReloadedOKRequest must be a positive long, was: " + timeToFirstOKRequestMs);
        }
        this.timeToReloadedOKRequest = timeToReloadedOKRequest;
        return this;
    }

    public LogBuilder startedInMs(long startedInMs) {
        if (startedInMs <= 0) {
            throw new IllegalArgumentException("startedInMs must be a positive long, was: " + startedInMs);
        }
        this.startedInMs = startedInMs;
        return this;
    }

    public LogBuilder stoppedInMs(long stoppedInMs) {
        if (stoppedInMs <= 0 && !app.isSpringBoot()) { // Spring Boot doesn't provide stop time
            throw new IllegalArgumentException("stoppedInMs must be a positive long, was: " + stoppedInMs);
        }
        this.stoppedInMs = stoppedInMs;
        return this;
    }

    public LogBuilder rssKb(long rssKb) {
        if (rssKb <= 0) {
            throw new IllegalArgumentException("rssKb must be a positive long, was: " + rssKb);
        }
        this.rssKb = rssKb;
        return this;
    }

    public LogBuilder rssKbFinal(long rssKbFinal) {
        if (rssKbFinal <= 0) {
            throw new IllegalArgumentException("rssKb must be a positive long, was: " + rssKb);
        }
        this.rssKbFinal = rssKbFinal;
        return this;
    }

    public LogBuilder avgResponseTime(double avgResponseTime) {
        if (avgResponseTime <= 0) {
            throw new IllegalArgumentException("avgResponseTime must be a positive double, was: " + rssKb);
        }
        this.avgResponseTime = avgResponseTime;
        return this;
    }

    public LogBuilder firstResponseTime(double firstResponseTime) {
        if (firstResponseTime <= 0) {
            throw new IllegalArgumentException("firstResponseTime must be a positive double, was: " + rssKb);
        }
        this.firstResponseTime = firstResponseTime;
        return this;
    }

    public LogBuilder totalDuration(double totalDuration) {
        if (totalDuration <= 0) {
            throw new IllegalArgumentException("totalDuration must be a positive double, was: " + rssKb);
        }
        this.totalDuration = totalDuration;
        return this;
    }

    public LogBuilder openedFiles(long openedFiles) {
        if (openedFiles <= 0) {
            throw new IllegalArgumentException("openedFiles must be a positive long, was: " + openedFiles);
        }
        this.openedFiles = openedFiles;
        return this;
    }

    public LogBuilder app(App app) {
        Objects.requireNonNull(app, "Valid app flavour must be provided");
        this.app = app;
        return this;
    }

    public LogBuilder mode(MvnCmds mode) {
        Objects.requireNonNull(mode, "Valid app flavour must be provided");
        this.mode = mode;
        return this;
    }

    public Log build() {
        StringBuilder h = new StringBuilder(512);
        StringBuilder l = new StringBuilder(512);
        int sections = 0;
        if (app != null) {
            h.append(appHeader);
            h.append(',');
            l.append(app);
            l.append(',');
            sections++;
        }
        if (mode != null) {
            h.append(modeHeader);
            h.append(',');
            l.append(mode);
            l.append(',');
            sections++;
        }
        if (buildTimeMs != -1L) {
            h.append(buildTimeMsHeader);
            h.append(',');
            l.append(buildTimeMs);
            l.append(',');
            sections++;
        }
        if (timeToFirstOKRequestMs != -1L) {
            h.append(timeToFirstOKRequestMsHeader);
            h.append(',');
            l.append(timeToFirstOKRequestMs);
            l.append(',');
            sections++;
        }
        if (timeToReloadedOKRequest != -1L) {
            h.append(timeToReloadedOKRequestHeader);
            h.append(',');
            l.append(timeToReloadedOKRequest);
            l.append(',');
            sections++;
        }
        if (startedInMs != -1L) {
            h.append(startedInMsHeader);
            h.append(',');
            l.append(startedInMs);
            l.append(',');
            sections++;
        }
        if (stoppedInMs != -1L) {
            h.append(stoppedInMsHeader);
            h.append(',');
            l.append(stoppedInMs);
            l.append(',');
            sections++;
        }
        if (rssKb != -1L) {
            h.append(rssKbHeader);
            h.append(',');
            l.append(rssKb);
            l.append(',');
            sections++;
        }
        if (rssKbFinal != -1L) {
            h.append(rssKbFinalHeader);
            h.append(',');
            l.append(rssKbFinal);
            l.append(',');
            sections++;
        }
        if (avgResponseTime != -1L) {
            h.append(avgResponseTimeHeader);
            h.append(',');
            l.append(avgResponseTime);
            l.append(',');
            sections++;
        }
        if (firstResponseTime != -1L) {
            h.append(firstResponseTimeHeader);
            h.append(',');
            l.append(firstResponseTime);
            l.append(',');
            sections++;
        }
        if (totalDuration != -1L) {
            h.append(totalDurationHeader);
            h.append(',');
            l.append(totalDuration);
            l.append(',');
            sections++;
        }
        if (openedFiles != -1L) {
            h.append(openedFilesHeader);
            h.append(',');
            l.append(openedFiles);
            l.append(',');
            sections++;
        }
        String header = h.toString();
        // Strip trailing ',' for CSV
        String headerCSV = header.substring(0, header.length() - 1);
        String headerMarkdown = "|" + header.replaceAll(",", "|") + "\n|" + " --- |".repeat(sections);
        String line = l.toString();
        String lineCSV = line.substring(0, line.length() - 1);
        String lineMarkdown = "|" + line.replaceAll(",", "|");
        return new Log(headerCSV, headerMarkdown, lineCSV, lineMarkdown);
    }
}
