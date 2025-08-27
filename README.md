<img align="right" width="250" height="47" src="media/Gematik_Logo_Flag.png"/> <br/>

[![Quality Gate Status](https://sonar.prod.ccs.gematik.solutions/api/project_badges/measure?project=de.gematik.demis%3Afhir-parser-library&metric=alert_status&token=c91558e8e32879962ecfeab0e044f90e1ae1d1aa)](https://sonar.prod.ccs.gematik.solutions/dashboard?id=de.gematik.demis%3Afhir-parser-library) [![Vulnerabilities](https://sonar.prod.ccs.gematik.solutions/api/project_badges/measure?project=de.gematik.demis%3Afhir-parser-library&metric=vulnerabilities&token=c91558e8e32879962ecfeab0e044f90e1ae1d1aa)](https://sonar.prod.ccs.gematik.solutions/dashboard?id=de.gematik.demis%3Afhir-parser-library) [![Bugs](https://sonar.prod.ccs.gematik.solutions/api/project_badges/measure?project=de.gematik.demis%3Afhir-parser-library&metric=bugs&token=c91558e8e32879962ecfeab0e044f90e1ae1d1aa)](https://sonar.prod.ccs.gematik.solutions/dashboard?id=de.gematik.demis%3Afhir-parser-library) [![Code Smells](https://sonar.prod.ccs.gematik.solutions/api/project_badges/measure?project=de.gematik.demis%3Afhir-parser-library&metric=code_smells&token=c91558e8e32879962ecfeab0e044f90e1ae1d1aa)](https://sonar.prod.ccs.gematik.solutions/dashboard?id=de.gematik.demis%3Afhir-parser-library) [![Lines of Code](https://sonar.prod.ccs.gematik.solutions/api/project_badges/measure?project=de.gematik.demis%3Afhir-parser-library&metric=ncloc&token=c91558e8e32879962ecfeab0e044f90e1ae1d1aa)](https://sonar.prod.ccs.gematik.solutions/dashboard?id=de.gematik.demis%3Afhir-parser-library) [![Coverage](https://sonar.prod.ccs.gematik.solutions/api/project_badges/measure?project=de.gematik.demis%3Afhir-parser-library&metric=coverage&token=c91558e8e32879962ecfeab0e044f90e1ae1d1aa)](https://sonar.prod.ccs.gematik.solutions/dashboard?id=de.gematik.demis%3Afhir-parser-library)

# fhir-parser-library

<details>
  <summary>Table of Contents</summary>
  <ol>
    <li>
      <a href="#about-the-project">About The Project</a>
       <ul>
        <li><a href="#usage">Usage</a></li>
        <li><a href="#release-notes">Release Notes</a></li>
      </ul>
	</li>
    <li><a href="#contributing">Contributing</a></li>
    <li><a href="#security-policy">Security Policy</a></li>
    <li><a href="#license">License</a></li>
    <li><a href="#contact">Contact</a></li>
  </ol>
</details>

## About The Project

This library provides necessary dependencies to work with HAPI FHIR classes and a simple parser FHIR notifications in json or xml.  


### Usage

```xml
<dependency>  
   <groupId>de.gematik.demis</groupId>  
   <artifactId>fhir-parser-library</artifactId>  
   <version>X.Y.Z</version>  
</dependency>
```

Create an FhirParser Object and parse/encode Strings/HAPI-Objects with XML-files:

```java 
FhirParser fhirParserServiceForR4 = new FhirParser();
Bundle bundle = fhirParserService.parseBundleOrParameter(minimalBundleString, XML);
String content = fhirParserService.encode(bundle1, XML);
 ```   

Hint: you can create a service or a bean to hold the FhirParser object!

### Release Notes
See [ReleaseNotes](ReleaseNotes.md) for all information regarding the (newest) releases.

## Contributing
If you want to contribute, please check our [CONTRIBUTING.md](.github/CONTRIBUTING.md).

## Security Policy
If you want to see the security policy, please check our [SECURITY.md](.github/SECURITY.md).

## License

Copyright 2022-2025 gematik GmbH

EUROPEAN UNION PUBLIC LICENCE v. 1.2

EUPL © the European Union 2007, 2016

See the [LICENSE](./LICENSE.md) for the specific language governing permissions and limitations under the License

## Additional Notes and Disclaimer from gematik GmbH

1. Copyright notice: Each published work result is accompanied by an explicit statement of the license conditions for use. These are regularly typical conditions in connection with open source or free software. Programs described/provided/linked here are free software, unless otherwise stated.
2. Permission notice: Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
    1. The copyright notice (Item 1) and the permission notice (Item 2) shall be included in all copies or substantial portions of the Software.
    2. The software is provided "as is" without warranty of any kind, either express or implied, including, but not limited to, the warranties of fitness for a particular purpose, merchantability, and/or non-infringement. The authors or copyright holders shall not be liable in any manner whatsoever for any damages or other claims arising from, out of or in connection with the software or the use or other dealings with the software, whether in an action of contract, tort, or otherwise.
    3. We take open source license compliance very seriously. We are always striving to achieve compliance at all times and to improve our processes. If you find any issues or have any suggestions or comments, or if you see any other ways in which we can improve, please reach out to: ospo@gematik.de
3. Please note: Parts of this code may have been generated using AI-supported technology. Please take this into account, especially when troubleshooting, for security analyses and possible adjustments.

## Contact
E-Mail to [DEMIS Entwicklung](mailto:demis-entwicklung@gematik.de?subject=[GitHub]%20fhir-parser-library)