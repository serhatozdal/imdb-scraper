# serhatozdal/imdb-scraper

Pure Java and Multithread Imdb Scraper Api for getting movies and persons.

[![](https://jitpack.io/v/serhatozdal/imdb-scraper.svg)](https://jitpack.io/#serhatozdal/imdb-scraper)
[![GitHub license](https://img.shields.io/github/license/serhatozdal/imdb-scraper.svg)](https://github.com/serhatozdal/imdb-scraper/blob/master/LICENSE)

Installation
=======

###Maven
Step 1. Add the JitPack repository to your build file
```xml
<repositories>
    <repository>
        <id>jitpack.io</id>
        <url>https://jitpack.io</url>
    </repository>
</repositories>
```

Step 2. Add the dependency
```xml
<dependency>
    <groupId>com.github.serhatozdal</groupId>
    <artifactId>imdb-scraper</artifactId>
    <version>1.0</version>
</dependency>
```

###Gradle
Add it in your root build.gradle at the end of repositories:
```
allprojects {
    repositories {
        ...
        maven { url 'https://jitpack.io' }
    }
}
```

Add the dependency
```
dependencies {
	        implementation 'com.github.serhatozdal:imdb-scraper:1.0'
	}
```

Usage
=======

##Movie Examples
####Simple Example
```java
Scraper scraper = new MediaScraper();
Media media = (Media) scraper.findById("tt0232500");
if (media.isFound()) {
    System.out.println("Imdb Id            : " + media.getId());
    System.out.println("Content Type       : " + media.getContentType());
    ......
    System.out.println("Poster URL         : " + media.getPoster());
    System.out.println("Poster Large URL   : " + media.getPosterLarge());
```

####Download Posters
```java
Scraper scraper = new MediaScraper();
scraper.downloadPoster(true);
Media media = (Media) scraper.findById("tt0232500");
if (media.isFound()) {
    // Base64 Strings of posters
    System.out.println("Poster URL         : " + media.getPoster());
    System.out.println("Poster Large URL   : " + media.getPosterLarge());
    ......
```

####Exception Handler
```java
Scraper scraper = new MediaScraper();
scraper.downloadPoster(true);
// custom exception handler for threads
scraper.setExceptionHandler((t, e) -> e.printStackTrace());
Media media = (Media) scraper.findById("tt0232500");
if (media.isFound()) {
    ......
```

##Person Example
```java
Scraper scraper = new PersonScraper();
scraper.downloadPoster(true);
scraper.setExceptionHandler((t, e) -> e.printStackTrace());
Person person = (Person) scraper.findById("nm0908094");
if (person.isFound()) {
    System.out.println("Imdb Id          : " + person.getId());
    System.out.println("Birth Name       : " + person.getBirthName());
    ....
```

See test folder to full examples