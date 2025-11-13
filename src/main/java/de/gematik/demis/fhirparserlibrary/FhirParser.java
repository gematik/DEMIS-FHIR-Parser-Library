package de.gematik.demis.fhirparserlibrary;

/*-
 * #%L
 * fhir-parser-library
 * %%
 * Copyright (C) 2025 gematik GmbH
 * %%
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
 *
 * *******
 *
 * For additional notes and disclaimer from gematik and in case of changes by gematik,
 * find details in the "Readme" file.
 * #L%
 */

import ca.uhn.fhir.context.FhirContext;
import ca.uhn.fhir.parser.IParser;
import java.util.Objects;
import org.hl7.fhir.instance.model.api.IBaseResource;
import org.hl7.fhir.r4.model.Bundle;
import org.hl7.fhir.r4.model.Parameters;

public class FhirParser {

  public static final String UNSUPPORTED_RESOURCE_BUNDLE = "Unsupported resource bundle";

  private final IParser xmlParser;
  private final IParser jsonParser;

  public FhirParser(FhirContext fhirContext) {
    this.xmlParser = fhirContext.newXmlParser();
    this.jsonParser = fhirContext.newJsonParser();
  }

  public Bundle parseBundleOrParameter(String content, String messageType) {
    return parseBundleOrParameter(content, MessageType.getMessageType(messageType));
  }

  public Bundle parseBundleOrParameter(String content, MessageType messageType)
      throws ParsingException {
    IBaseResource resource = getParser(messageType).parseResource(content);

    if (resource instanceof Parameters) {
      var parameters = (Parameters) resource;
      return (Bundle) parameters.getParameterFirstRep().getResource();
    } else if (resource instanceof Bundle) {
      return (Bundle) resource;
    }
    throw new ParsingException(UNSUPPORTED_RESOURCE_BUNDLE);
  }

  public IBaseResource parseFromJson(String content) {
    return jsonParser.parseResource(content);
  }

  public IBaseResource parseFromXml(String content) {
    return xmlParser.parseResource(content);
  }

  public String encode(IBaseResource resource, String messageType) {
    return getParser(MessageType.getMessageType(messageType)).encodeResourceToString(resource);
  }

  public String encode(IBaseResource resource, MessageType messageType) {
    return getParser(messageType).encodeResourceToString(resource);
  }

  public String encodeToJson(IBaseResource resource) {
    return jsonParser.encodeResourceToString(resource);
  }

  public String encodeToXml(IBaseResource resource) {
    return xmlParser.encodeResourceToString(resource);
  }

  private IParser getParser(MessageType messageType) {
    Objects.requireNonNull(messageType, "require NonNull mediaType");
    if (messageType.equals(MessageType.XML)) {
      return xmlParser;
    } else {
      return jsonParser;
    }
  }
}
