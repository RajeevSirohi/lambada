/*
 * Copyright (c) 2016 ingenieux Labs
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package io.ingenieux.lambada.runtime;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Tag Annotation for API Gateway (Lambda) Functions
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface ApiGateway {
  public enum MethodType {
    GET,
    POST,
    DELETE,
    HEAD,
    PATCH,
    PUT
  }

  /**
   * Function name. Defaults to method name
   */
  String path() default "";

  /**
   * Method Type
   */
  MethodType method() default MethodType.POST;

  /**
   * Template to use (default: default)
   */
  String template() default "default";

  /**
   * True if CORS-enabled
   */
  boolean corsEnabled() default true;

  /**
   * Json Patches (RFC 6902) to apply on the template
   */
  Patch[] patches() default {};
}
