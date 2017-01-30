<#assign security=JspTaglibs["http://www.springframework.org/security/tags"]/>

<#--<@security.authorize access="hasAnyRole('ROLE_USER')">-->
    <#--<@security.authentication property="principal.user.firstName" var="username"/>-->
<#--</@security.authorize>-->

<header>
    <div class="col-md-2 col-md-offset-10">
        <a href="/logout">Выход</a>
    </div>
</header>