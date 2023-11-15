<img align="right" width="250" height="47" src="../media/Gematik_Logo_Flag.png"/> <br/>

[![Quality Gate Status](https://sonar.prod.ccs.gematik.solutions/api/project_badges/measure?project=de.gematik.demis%3Afhir-parser-library&metric=alert_status&token=c91558e8e32879962ecfeab0e044f90e1ae1d1aa)](https://sonar.prod.ccs.gematik.solutions/dashboard?id=de.gematik.demis%3Afhir-parser-library) [![Vulnerabilities](https://sonar.prod.ccs.gematik.solutions/api/project_badges/measure?project=de.gematik.demis%3Afhir-parser-library&metric=vulnerabilities&token=c91558e8e32879962ecfeab0e044f90e1ae1d1aa)](https://sonar.prod.ccs.gematik.solutions/dashboard?id=de.gematik.demis%3Afhir-parser-library) [![Bugs](https://sonar.prod.ccs.gematik.solutions/api/project_badges/measure?project=de.gematik.demis%3Afhir-parser-library&metric=bugs&token=c91558e8e32879962ecfeab0e044f90e1ae1d1aa)](https://sonar.prod.ccs.gematik.solutions/dashboard?id=de.gematik.demis%3Afhir-parser-library) [![Code Smells](https://sonar.prod.ccs.gematik.solutions/api/project_badges/measure?project=de.gematik.demis%3Afhir-parser-library&metric=code_smells&token=c91558e8e32879962ecfeab0e044f90e1ae1d1aa)](https://sonar.prod.ccs.gematik.solutions/dashboard?id=de.gematik.demis%3Afhir-parser-library) [![Lines of Code](https://sonar.prod.ccs.gematik.solutions/api/project_badges/measure?project=de.gematik.demis%3Afhir-parser-library&metric=ncloc&token=c91558e8e32879962ecfeab0e044f90e1ae1d1aa)](https://sonar.prod.ccs.gematik.solutions/dashboard?id=de.gematik.demis%3Afhir-parser-library) [![Coverage](https://sonar.prod.ccs.gematik.solutions/api/project_badges/measure?project=de.gematik.demis%3Afhir-parser-library&metric=coverage&token=c91558e8e32879962ecfeab0e044f90e1ae1d1aa)](https://sonar.prod.ccs.gematik.solutions/dashboard?id=de.gematik.demis%3Afhir-parser-library)

# fhir-parser-library

<details>
  <summary>Table of Contents</summary>
  <ol>
    <li>
      <a href="#about-the-project">About The Project</a>
       <ul>
        <li><a href="#quality-gate">Quality Gates</a></li>
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

### Quality Gate

[![Quality gate](https://sonar.prod.ccs.gematik.solutions/api/project_badges/quality_gate?project=de.gematik.demis%3Afhir-parser-library&token=c91558e8e32879962ecfeab0e044f90e1ae1d1aa)](https://sonar.prod.ccs.gematik.solutions/dashboard?id=de.gematik.demis%3Afhir-parser-library)

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

See [ReleaseNotes](../ReleaseNotes.md) for all information regarding the (newest) releases.

## Contributing

If you want to contribute, please check our [CONTRIBUTING.md](CONTRIBUTING.md).

## Security Policy

If you want to see the security policy, please check our [SECURITY.md](SECURITY.md).

## License

EUROPEAN UNION PUBLIC LICENCE v. 1.2

EUPL © the European Union 2007, 2016

Copyright (c) 2023 gematik GmbH

See [LICENSE](../LICENSE.md).

## Contact

E-Mail to [DEMIS Entwicklung](mailto:demis-entwicklung@gematik.de?subject=[GitHub]%20Validation-Service)