/*
 * Copyright [2023], gematik GmbH
 *
 * Licensed under the EUPL, Version 1.2 or - as soon they will be approved by the
 * European Commission – subsequent versions of the EUPL (the "Licence").
 * You may not use this work except in compliance with the Licence.
 *
 * You find a copy of the Licence in the "Licence" file or at
 * https://joinup.ec.europa.eu/collection/eupl/eupl-text-eupl-12
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the Licence is distributed on an "AS IS" basis,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either expressed or implied.
 * In case of changes by gematik find details in the "Readme" file.
 *
 * See the Licence for the specific language governing permissions and limitations under the Licence.
 */

package de.gematik.demis.fhirparserlibrary;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class MessageTypeTest {

  @Test
  void shouldReturnXMLEnumForXmlAsString() {

    assertThat(MessageType.getMessageType("xml")).isEqualTo(MessageType.XML);
    assertThat(MessageType.getMessageType("XML")).isEqualTo(MessageType.XML);
    assertThat(MessageType.getMessageType("xMl")).isEqualTo(MessageType.XML);
    assertThat(MessageType.getMessageType("XmL")).isEqualTo(MessageType.XML);
  }

  @Test
  void shouldReturnJsonEnumForJsonAsString() {

    assertThat(MessageType.getMessageType("json")).isEqualTo(MessageType.JSON);
    assertThat(MessageType.getMessageType("JSON")).isEqualTo(MessageType.JSON);
    assertThat(MessageType.getMessageType("jSoN")).isEqualTo(MessageType.JSON);
    assertThat(MessageType.getMessageType("JsOn")).isEqualTo(MessageType.JSON);
  }

  @Test
  void shouldReturnJsonAsStandardCase() {
    assertThat(MessageType.getMessageType("foobar")).isEqualTo(MessageType.JSON);
  }
}
