/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.dubbo.common.logger;

import org.apache.dubbo.common.constants.LoggerCodeConstants;

/**
 * Logger interface with the ability of displaying solution of different types of error.
 *
 * <p>
 * This logger will log a message like this:
 *
 * <blockquote><pre>
 *     ... (original logging message) This may be caused by (... cause),
 *     go to https://dubbo.apache.org/faq/[Cat]/[X] to find instructions. (... extendedInformation)
 * </pre></blockquote>
 *
 * Where "[Cat]/[X]" is the error code ("code" in arguments). The link is clickable, leading user to
 * the "Error code and its corresponding solutions" page.
 *
 * @see LoggerCodeConstants Detailed Format of Error Code and Error Code Constants
 */
public interface ErrorTypeAwareLogger extends Logger {

    /**
     * Logs a message with warn log level.
     *
     * @param code error code
     * @param cause error cause
     * @param extendedInformation extended information
     * @param msg log this message
     */
    void warn(String code, String cause, String extendedInformation, String msg);

    /**
     * Logs a message with warn log level.
     *
     * @param code error code
     * @param cause error cause
     * @param extendedInformation extended information
     * @param msg log this message
     * @param e log this cause
     */
    void warn(String code, String cause, String extendedInformation, String msg, Throwable e);

    /**
     * Logs a message with error log level.
     *
     * @param code error code
     * @param cause error cause
     * @param extendedInformation extended information
     * @param msg log this message
     */
    void error(String code, String cause, String extendedInformation, String msg);

    /**
     * Logs a message with error log level.
     *
     * @param code error code
     * @param cause error cause
     * @param extendedInformation extended information
     * @param msg log this message
     * @param e log this cause
     */
    void error(String code, String cause, String extendedInformation, String msg, Throwable e);
}
