/*
 * Copyright 2018 Confluent Inc.
 *
 * Licensed under the Confluent Community License (the "License"); you may not use
 * this file except in compliance with the License.  You may obtain a copy of the
 * License at
 *
 * http://www.confluent.io/confluent-community-license
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OF ANY KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations under the License.
 */

package io.confluent.ksql.function.udf.url;

import io.confluent.ksql.function.udf.Udf;
import io.confluent.ksql.function.udf.UdfDescription;
import io.confluent.ksql.function.udf.UdfParameter;
import io.confluent.ksql.util.KsqlConstants;
import java.net.URI;

@UdfDescription(
    name = "url_extract_host",
    description = "Extracts the Host Name of an application/x-www-form-urlencoded String input",
    author = KsqlConstants.CONFLUENT_AUTHOR
)
public class UrlExtractHost {

  @Udf
  public String extractHost(
      @UdfParameter(description = "a valid URL") final String input) {
    return UrlParser.extract(input, URI::getHost);
  }
}
