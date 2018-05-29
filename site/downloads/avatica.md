---
layout: page
title: Avatica Downloads
permalink: /downloads/avatica.html
---

<!--
{% comment %}
Licensed to the Apache Software Foundation (ASF) under one or more
contributor license agreements.  See the NOTICE file distributed with
this work for additional information regarding copyright ownership.
The ASF licenses this file to you under the Apache License, Version 2.0
(the "License"); you may not use this file except in compliance with
the License.  You may obtain a copy of the License at

http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
{% endcomment %}
-->

Avatica is released as a source artifact, and also through Maven and Docker Hub.

# Source releases

Release          | Date       | Commit   | Download
:--------------- | :--------- | :------- | :-------
{% for post in site.categories.release %}{% comment %}
{% endcomment %}{% if post.component != "avatica" %}{% comment %}
{% endcomment %}{% continue %}{% comment %}
{% endcomment %}{% endif %}{% comment %}
{% endcomment %}{% if post.fullVersion %}{% comment %}
{% endcomment %}{% assign v = post.fullVersion %}{% comment %}
{% endcomment %}{% else %}{% comment %}
{% endcomment %}{% capture v %}apache-calcite-avatica-{{ post.version }}{% endcapture %}{% comment %}
{% endcomment %}{% endif %}{% comment %}
{% endcomment %}{% if forloop.index0 < 1 %}{% comment %}
{% endcomment %}{% capture p %}http://www.apache.org/dyn/closer.lua?filename=calcite/{{ v }}{% endcapture %}{% comment %}
{% endcomment %}{% assign q = "&action=download" %}{% comment %}
{% endcomment %}{% assign d = "https://www.apache.org/dist" %}{% comment %}
{% endcomment %}{% else %}{% comment %}
{% endcomment %}{% capture p %}http://archive.apache.org/dist/calcite/{{ v }}{% endcapture %}{% comment %}
{% endcomment %}{% assign q = "" %}{% comment %}
{% endcomment %}{% assign d = "https://archive.apache.org/dist" %}{% comment %}
{% endcomment %}{% endif %}{% comment %}
{% endcomment %}{% capture d1 %}{{ post.date | date: "%F"}}{% endcapture %}{% comment %}
{% endcomment %}{% capture d2 %}2017-05-01{% endcapture %}{% comment %}
{% endcomment %}{% capture d3 %}2018-03-01{% endcapture %}{% comment %}
{% endcomment %}{% capture d4 %}2018-06-01{% endcapture %}{% comment %}
{% endcomment %}{% if d1 > d3 %}{% comment %}
{% endcomment %}{% assign digest = "sha256" %}{% comment %}
{% endcomment %}{% elsif d1 > d2 %}{% comment %}
{% endcomment %}{% assign digest = "mds" %}{% comment %}
{% endcomment %}{% else %}{% comment %}
{% endcomment %}{% assign digest = "md5" %}{% comment %}
{% endcomment %}{% endif %}{% comment %}
{% endcomment %}<a href="{{ site.baseurl }}/docs/history.html#{{ post.tag }}">{{ post.version }}</a>{% comment %}
{% endcomment %} | {{ post.date | date_to_string }}{% comment %}
{% endcomment %} | <a href="https://github.com/apache/calcite-avatica/commit/{{ post.sha }}">{{ post.sha }}</a>{% comment %}
{% endcomment %} | <a href="{{ p }}/{{ v }}-src.tar.gz{{ q }}">tar</a>{% comment %}
{% endcomment %} (<a href="{{ d }}/calcite/{{ v }}/{{ v }}-src.tar.gz.{{ digest }}">{{ digest }}</a>{% comment %}
{% endcomment %} <a href="{{ d }}/calcite/{{ v }}/{{ v }}-src.tar.gz.asc">pgp</a>){% comment %}
{% endcomment %}{% if d1 < d4 %}{% comment %}
{% endcomment %} {% raw %}<br>{% endraw %}{% comment %}
{% endcomment %} <a href="{{ p }}/{{ v }}-src.zip{{ q }}">zip</a>{% comment %}
{% endcomment %} (<a href="{{ d }}/calcite/{{ v }}/{{ v }}-src.zip.{{ digest }}">{{ digest }}</a>{% comment %}
{% endcomment %} <a href="{{ d }}/calcite/{{ v }}/{{ v }}-src.zip.asc">pgp</a>){% comment %}
{% endcomment %}{% endif %}{% comment %}
{% endcomment %}
{% endfor %}

Choose a source distribution in either *tar* or *zip* format,
and [verify](http://www.apache.org/dyn/closer.cgi#verify)
using the corresponding *pgp* signature (using the committer file in
[KEYS](http://www.apache.org/dist/calcite/KEYS)).
If you cannot do that, use the *sha256* hash file (*md5* in older
releases) to check that the download has completed OK.

For fast downloads, current source distributions are hosted on mirror servers;
older source distributions are in the
[archive](http://archive.apache.org/dist/calcite/).
If a download from a mirror fails, retry, and the second download will likely
succeed.

For security, hash and signature files are always hosted at
[Apache](https://www.apache.org/dist).

# Maven artifacts

Add the following to the dependencies section of your `pom.xml` file:

{% for post in site.categories.release limit:1 %}
{% assign current_release = post %}
{% endfor %}

{% highlight xml %}
<dependencies>
  <dependency>
    <groupId>org.apache.calcite.avatica</groupId>
    <artifactId>avatica</artifactId>
    <version>{{ current_release.version }}</version>
  </dependency>
  <dependency>
    <groupId>org.apache.calcite.avatica</groupId>
    <artifactId>avatica-server</artifactId>
    <version>{{ current_release.version }}</version>
  </dependency>
</dependencies>
{% endhighlight %}

As of Apache Calcite Avatica 1.9.0, the following un-shaded client artifact is also available:

{% highlight xml %}
<dependencies>
  <dependency>
    <groupId>org.apache.calcite.avatica</groupId>
    <artifactId>avatica-core</artifactId>
    <version>{{ current_release.version }}</version>
  </dependency>
</dependencies>
{% endhighlight %}

# Docker images

From release 1.10.0 onwards, Docker images for Avatica Server are available at
[Docker Hub](https://hub.docker.com/r/apache/calcite-avatica).
