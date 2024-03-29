# Konik ZUGFeRD Library

> **Note**
> This project reached its EOL. The Konik e-invoicing library was/is used by many ERP and DMS systems, at it high more than 100k companies used Konik.

[![Join the chat at https://gitter.im/konik-io/konik](https://badges.gitter.im/Join%20Chat.svg)](https://gitter.im/konik-io/konik?utm_source=badge&utm_medium=badge&utm_campaign=pr-badge&utm_content=badge)

Is an easy to use open source implementation of the ZUGFeRD data model including various enhancements. 

## Features 
 - Easy and understandable API to create and read ZUGFeRD compliant invoices.
 - Extensive documentation with examples. See [konik.io/docs](http://konik.io/docs)
 - XML schema and semantic invoice validation.
 - Validation of invoices against ZUGFeRD profiles.
 - Validation of invoices against specific country invoice regulations.
 - Attaching or extracting XMLs from PDFs.
 - Multiple PDF Carriages from different vendors (Currently iText and PDFBox). Choose your favorite or use any other of your choice.

## Modules 

Quick overview of the different modules.

 - ```konik``` Contains the ZUGFeRD data model. 
 - ```harness``` API connecting the Konik library to a PDF-Carriage.
 - ```itext-carriage```	The PDF provider iText which can be used together with the Konik library.
 - ```pdfbox-carriage```	The PDF provider which can be used together with the Konik library.
 - ```distribution``` Zip distribution package. For those who are not using maven.
 - ```project``` content related to the project like Scripts, Formatting rules, dictionary.  (Not a Maven module). 

## Documentation  

http://konik.io/docs





## License

All code is licensed under the [AGPL](LICENCE.md), v3 or later.

