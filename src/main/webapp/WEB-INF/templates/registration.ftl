<#assign form=JspTaglibs["http://www.springframework.org/tags/form"]/>

<#include "main-template.ftl"/>

<#macro m_body>
    <div class="col-md-4 col-md-offset-4 login-form">
        <h1>Регистрация</h1>
        <@form.form action="/registration" method="post" modelAttribute="form">
                <div class="form-group">
                    <@form.label path="email">Email</@form.label>
                    <@form.input path="email" cssClass="form-control"/>
                    <@form.errors path="email"/>
                </div>
                <div class="form-group">
                    <@form.label path="firstName">Имя</@form.label>
                    <@form.input path="firstName" cssClass="form-control"/>
                    <@form.errors path="firstName"/>
                </div>
                <div class="form-group">
                    <@form.label path="lastName">Фамилия</@form.label>
                    <@form.input path="lastName" cssClass="form-control"/>
                    <@form.errors path="lastName"/>
                </div>
                <div class="form-group">
                    <@form.label path="password">Пароль</@form.label>
                    <@form.password path="password" cssClass="form-control" id="password"/>
                    <@form.errors path="password"/>
                </div>
            <button type="submit" class="btn btn-default">Зарегистрироваться</button>
            <a href="/login" class="btn btn-default">Войти</a>
        </@form.form>
    </div>
</#macro>

<@main title="Логин"/>