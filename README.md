# Konik 

is a easy to use open source implementation of the ZUGFeRD data model including various enhancements. 

## Features 
 - Easy and understandable API to create and read invoices.
 - Extensive documentation with examples.
 - Logical invoice validation done with JSR303
 - Validation of invoices against ZUGFeRD profiles.
 - Validation of invoices against specific country invoice regulations.
 - Easy way of invoice attaching or extracting from PDFs.
 - Multiple PDF Carriages from different vendors. Choose your favorite.

## Modules 

Quick overview of the different modules.

 - ```konik``` Contains the ZUGFeRD data model. 
 - ```harness``` API connecting the the Konik library to a PDF-Carriage.
 - ```itext-carriage```	The PDF provider iText which can be used together with the Konik library.
  - ```pdfbox-carriage```	The PDF provider which can be used together with the Konik library.
 - ```distribution``` Zip distribution package. For those who are not using maven.
 - ```project``` content related to the project like Scripts, Formatting rules, dictionary.  (Not a Maven module). 
 

For more information please visit http://konik.io

Fancy project badges

[![Build Status](http://ci.konik.io/job/konik/badge/icon)](http://ci.konik.io/job/konik/)

[![Dependency Status](https://www.versioneye.com/user/projects/54175d6769b273246a000151/badge.svg?style=flat)](https://www.versioneye.com/user/projects/54175d6769b273246a000151)
