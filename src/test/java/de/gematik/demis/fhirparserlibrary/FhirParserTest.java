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
 * #L%
 */

import static de.gematik.demis.fhirparserlibrary.FhirParser.UNSUPPORTED_RESOURCE_BUNDLE;
import static de.gematik.demis.fhirparserlibrary.MessageType.JSON;
import static de.gematik.demis.fhirparserlibrary.MessageType.XML;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import ca.uhn.fhir.context.FhirContext;
import org.hl7.fhir.instance.model.api.IBaseResource;
import org.hl7.fhir.r4.model.Bundle;
import org.hl7.fhir.r4.model.OperationOutcome;
import org.hl7.fhir.r4.model.Parameters;
import org.junit.jupiter.api.Test;

class FhirParserTest {

  private final FhirParser fhirParserService = new FhirParser(FhirContext.forR4());

  @Test
  void shouldParseFhirXMLString() throws ParsingException {
    String minimalBundleString = "<Bundle xmlns=\"http://hl7.org/fhir\"><id value=\"1\"/></Bundle>";

    Bundle bundle = fhirParserService.parseBundleOrParameter(minimalBundleString, XML);

    assertThat(bundle.getId()).isEqualTo("Bundle/1");
  }

  @Test
  void shouldParseFhirXMLStringWithStringInput() throws ParsingException {
    String minimalBundleString = "<Bundle xmlns=\"http://hl7.org/fhir\"><id value=\"1\"/></Bundle>";

    Bundle bundle = fhirParserService.parseBundleOrParameter(minimalBundleString, "xml");
    Bundle bundle1 = fhirParserService.parseBundleOrParameter(minimalBundleString, "xml");
    Bundle bundle2 = fhirParserService.parseBundleOrParameter(minimalBundleString, "XML");
    Bundle bundle3 = fhirParserService.parseBundleOrParameter(minimalBundleString, "XmL");

    assertThat(bundle.getId()).isEqualTo("Bundle/1");
    assertThat(bundle1.getId()).isEqualTo("Bundle/1");
    assertThat(bundle2.getId()).isEqualTo("Bundle/1");
    assertThat(bundle3.getId()).isEqualTo("Bundle/1");
  }

  @Test
  void shouldParseFhirJsonString() throws ParsingException {
    String minimalBundleString = "{\"resourceType\":\"Bundle\",\"id\":\"1\"}";

    Bundle bundle = fhirParserService.parseBundleOrParameter(minimalBundleString, JSON);

    assertThat(bundle.getId()).isEqualTo("Bundle/1");
  }

  @Test
  void shouldParseFhirJsonStringWithStringInput() throws ParsingException {
    String minimalBundleString = "{\"resourceType\":\"Bundle\",\"id\":\"1\"}";

    Bundle bundle = fhirParserService.parseBundleOrParameter(minimalBundleString, "json");
    Bundle bundle1 = fhirParserService.parseBundleOrParameter(minimalBundleString, "json");
    Bundle bundle2 = fhirParserService.parseBundleOrParameter(minimalBundleString, "JSON");
    Bundle bundle3 = fhirParserService.parseBundleOrParameter(minimalBundleString, "jSoN");

    assertThat(bundle.getId()).isEqualTo("Bundle/1");
    assertThat(bundle1.getId()).isEqualTo("Bundle/1");
    assertThat(bundle2.getId()).isEqualTo("Bundle/1");
    assertThat(bundle3.getId()).isEqualTo("Bundle/1");
  }

  @Test
  void shouldEncodeToXml() throws ParsingException {

    Bundle bundle1 = new Bundle();
    bundle1.setId("1");

    String actualXml = fhirParserService.encode(bundle1, XML);

    String minimalBundleString =
        "<Bundle xmlns=\"http://hl7.org/fhir\"><id value=\"1\"></id></Bundle>";

    assertThat(actualXml).isEqualTo(minimalBundleString);
  }

  @Test
  void shouldEncodeToXmlFromParameters() throws ParsingException {
    Bundle bundle1 = new Bundle();
    bundle1.setId("1");

    Parameters.ParametersParameterComponent t = new Parameters.ParametersParameterComponent();
    t.setResource(bundle1);

    Parameters parameters = new Parameters();
    parameters.addParameter(t);

    String actualXml = fhirParserService.encode(parameters, XML);

    String minimalBundleString =
        "<Parameters xmlns=\"http://hl7.org/fhir\"><parameter><resource><Bundle xmlns=\"http://hl7.org/fhir\"><id value=\"1\"></id></Bundle></resource></parameter></Parameters>";

    assertThat(actualXml).isEqualTo(minimalBundleString);
  }

  @Test
  void shouldEncodeToXmlFromParametersWithStringInput() throws ParsingException {
    Bundle bundle1 = new Bundle();
    bundle1.setId("1");

    Parameters.ParametersParameterComponent t = new Parameters.ParametersParameterComponent();
    t.setResource(bundle1);

    Parameters parameters = new Parameters();
    parameters.addParameter(t);

    String actualXml = fhirParserService.encode(parameters, "XML");

    String minimalBundleString =
        "<Parameters xmlns=\"http://hl7.org/fhir\"><parameter><resource><Bundle xmlns=\"http://hl7.org/fhir\"><id value=\"1\"></id></Bundle></resource></parameter></Parameters>";

    assertThat(actualXml).isEqualTo(minimalBundleString);
  }

  @Test
  void shouldEncodeToJsonFromParameters() throws ParsingException {
    Bundle bundle1 = new Bundle();
    bundle1.setId("1");

    Parameters.ParametersParameterComponent t = new Parameters.ParametersParameterComponent();
    t.setResource(bundle1);

    Parameters parameters = new Parameters();
    parameters.addParameter(t);

    String actualJson = fhirParserService.encode(parameters, JSON);

    String minimalBundleString =
        "{\"resourceType\":\"Parameters\",\"parameter\":[{\"resource\":{\"resourceType\":\"Bundle\",\"id\":\"1\"}}]}";

    assertThat(actualJson).isEqualTo(minimalBundleString);
  }

  @Test
  void shouldEncodeToJsonFromParametersWithStringInput() throws ParsingException {
    Bundle bundle1 = new Bundle();
    bundle1.setId("1");

    Parameters.ParametersParameterComponent t = new Parameters.ParametersParameterComponent();
    t.setResource(bundle1);

    Parameters parameters = new Parameters();
    parameters.addParameter(t);

    String actualJson = fhirParserService.encode(parameters, "JSON");

    String minimalBundleString =
        "{\"resourceType\":\"Parameters\",\"parameter\":[{\"resource\":{\"resourceType\":\"Bundle\",\"id\":\"1\"}}]}";

    assertThat(actualJson).isEqualTo(minimalBundleString);
  }

  @Test
  void shouldParseToBundleFromParametersXml() throws ParsingException {
    String minimalParameterString =
        "<Parameters xmlns=\"http://hl7.org/fhir\"><parameter><resource><Bundle xmlns=\"http://hl7.org/fhir\"><id value=\"1\"></id></Bundle></resource></parameter></Parameters>";

    Bundle bundle = fhirParserService.parseBundleOrParameter(minimalParameterString, XML);

    assertThat(bundle.getId()).isEqualTo("Bundle/1");
  }

  @Test
  void shouldParseToBundleFromParametersJson() throws ParsingException {
    String minimalParameterString =
        "{\"resourceType\":\"Parameters\",\"parameter\":[{\"resource\":{\"resourceType\":\"Bundle\",\"id\":\"1\"}}]}";

    Bundle bundle = fhirParserService.parseBundleOrParameter(minimalParameterString, JSON);

    assertThat(bundle.getId()).isEqualTo("Bundle/1");
  }

  @Test
  void shouldEncodeJson() throws ParsingException {

    Bundle bundle1 = new Bundle();
    bundle1.setId("1");

    String actualJson = fhirParserService.encode(bundle1, JSON);

    String minimalBundleString = "{\"resourceType\":\"Bundle\",\"id\":\"1\"}";
    assertThat(actualJson).isEqualTo(minimalBundleString);
  }

  @Test
  void shouldThrowExceptionForNoBundle() {
    String minimalBundleString =
        "<Patient xmlns=\"http://hl7.org/fhir\"><id value=\"1\"/></Patient>";

    assertThatThrownBy(() -> fhirParserService.parseBundleOrParameter(minimalBundleString, XML))
        .isInstanceOf(ParsingException.class)
        .hasMessage(UNSUPPORTED_RESOURCE_BUNDLE);
  }

  @Test
  void shouldParseFromJsonBundle() {
    String minimalBundleString = "{\"resourceType\":\"Bundle\",\"id\":\"1\"}";
    IBaseResource bundle = fhirParserService.parseFromJson(minimalBundleString);

    assertThat(((Bundle) bundle).getId()).isEqualTo("Bundle/1");
  }

  @Test
  void shouldParseFromXmlBundle() {
    String minimalBundleString = "<Bundle><id value=\"1\"></id></Bundle>";
    IBaseResource bundle = fhirParserService.parseFromXml(minimalBundleString);

    assertThat(((Bundle) bundle).getId()).isEqualTo("Bundle/1");
  }

  @Test
  void shouldEncodeToJson() {
    Bundle bundle = new Bundle();
    bundle.setId("1");

    String encoded = fhirParserService.encodeToJson(bundle);

    assertThat(encoded).contains("{", "}").doesNotContain("<", ">");
  }

  @Test
  void shouldEncodeToXML() {
    Bundle bundle = new Bundle();
    bundle.setId("1");

    String encoded = fhirParserService.encodeToXml(bundle);

    assertThat(encoded).doesNotContain("{", "}").contains("<", ">");
  }

  @Test
  void shouldParseFromJsonOperationOutcome() {
    String minimalBundleString =
        "{\n"
            + "  \"resourceType\": \"OperationOutcome\",\n"
            + "  \"issue\": [\n"
            + "    {\n"
            + "      \"severity\": \"information\",\n"
            + "      \"code\": \"processing\",\n"
            + "      \"diagnostics\": \"Dieses Element stimmt mit keinem bekannten Slice defined in the profile https://demis.rki.de/fhir/StructureDefinition/ReportBundle überein.\",\n"
            + "      \"location\": [\n"
            + "        \"Bundle.entry[1]\",\n"
            + "        \"Line 81, Col 10\"\n"
            + "      ]\n"
            + "    }\n"
            + "  ]\n"
            + "}";
    IBaseResource operationOutcome = fhirParserService.parseFromJson(minimalBundleString);

    assertThat(((OperationOutcome) operationOutcome).getIssue()).hasSize(1);
    assertThat(((OperationOutcome) operationOutcome).getIssue().get(0).getSeverity().getDisplay())
        .isEqualTo("Information");
    assertThat(((OperationOutcome) operationOutcome).getIssue().get(0).getCode().getDisplay())
        .isEqualTo("Processing Failure");
  }
}
