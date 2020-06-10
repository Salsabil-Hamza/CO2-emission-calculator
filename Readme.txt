Java IntelliJ Idea was chosen for implementing the CO2_Calculator. Whereas, Maven framework is the
dependency management tool selected for continuous integration and deployment. Accordingly, the apache CLI
version 1.4 is the library that handles parsing command line arguments, which can be entered through cmd,
PowerShell or simply by clicking on edit configurations tab and filling in the program arguments box.
The uploaded code includes "pom.xml" file where all the relevant dependencies are located. For this task,
the apache CLI library was added to the pre-existing dependencies, more precisely:

<dependency>
          <groupId>commons-cli</groupId>
          <artifactId>commons-cli</artifactId>
          <version>1.4</version>
</dependency>