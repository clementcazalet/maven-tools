/*
 *
 *  * Copyright (c) 2020, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
 *  *
 *  * WSO2 Inc. licenses this file to you under the Apache License,
 *  * Version 2.0 (the "License"); you may not use this file except
 *  * in compliance with the License.
 *  * You may obtain a copy of the License at
 *  *
 *  *     http://www.apache.org/licenses/LICENSE-2.0
 *  *
 *  * Unless required by applicable law or agreed to in writing,
 *  * software distributed under the License is distributed on an
 *  * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 *  * KIND, either express or implied. See the License for the
 *  * specific language governing permissions and limitations
 *  * under the License.
 *
 */

package org.wso2.maven.car.artifact.util;

import feign.Response;
import org.wso2.maven.car.artifact.exception.CAppMgtServiceStubException;

import java.io.File;

public class HTTPSClientUtil {

    /**
     * Avoids Instantiation.
     */
    private HTTPSClientUtil() {

    }

    public static Response doAuthenticate(String serverUrl, String username, String password) throws
            CAppMgtServiceStubException{
        return CAppMgtHandlerFactory.getCAppMgtHttpsClient(serverUrl, username, password).doAuthenticate();
    }

    public static Response deployCApp(File capp, String accessToken, String serverUrl) throws
            CAppMgtServiceStubException{
        return CAppMgtHandlerFactory.getCAppMgtHttpsClient2(serverUrl, accessToken).deployCApp(capp);
    }

    public static Response unDeployCApp(String accessToken, String serverUrl, String cAppName) throws
            CAppMgtServiceStubException{
        return CAppMgtHandlerFactory.getCAppMgtHttpsClient3(serverUrl, accessToken).
                unDeployCApp(cAppName);
    }


}
