<html>
<head>
    <title>Chirp! Chirp!</title>
</head>

<body>
<ul>
    <li>App version: <g:meta name="app.version"></g:meta></li>
    <li>Grails version: <g:meta name="app.grails.version"></g:meta></li>
    <li>Groovy version: ${org.codehaus.groovy.runtime.InvokerHelper.getVersion()}</li>
    <li>JVM version: ${System.getProperty('java.version')}</li>
</ul>
</body>
</html>
