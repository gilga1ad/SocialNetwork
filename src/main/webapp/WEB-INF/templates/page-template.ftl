<#macro main title="Main page" customStyles=[] customScripts=[]>
<!DOCTYPE html>
<html>
<head>
    <title>${title}</title>
    <link rel="stylesheet" type="text/css" href="/resources/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="/resources/css/main.css">

    <script src="/resources/js/jquery-3.1.1.min.js"></script>

    <#list customStyles as style>
        <link rel="stylesheet" type="text/css" href="${style}">
    </#list>
    <#list customScripts as script>
        <script src="${script}"></script>
    </#list>
</head>
<body>
    <#include "header.ftl"/>
<div class="container">
    <div class="row">
        <div class="col-md-8 col-md-push-3 page-form">
            <@m_body/>
        </div>
    </div>
</div>


</body>
</html>
</#macro>