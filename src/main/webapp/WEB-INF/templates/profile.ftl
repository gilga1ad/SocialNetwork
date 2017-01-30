<#assign form=JspTaglibs["http://www.springframework.org/tags/form"]/>
<#assign security=JspTaglibs["http://www.springframework.org/security/tags"]/>
<#include "page-template.ftl"/>

<#macro m_body>
    <div class="row">
        <div class="col-md-4">
            <br><img src="/resources/img/${user.photo!"no-avatar.png"}" class="img-responsive" width="300">
        </div>
        <div class="col-md-8">
            <h3 align="center">${user.firstName} ${user.lastName}</h3><br>
            <table width="100%">
                <#if user.birthday.day??>
                    <tr>
                        <td><p class="text-muted">День рождения:</p></td>
                        <td><p class="text-muted">${user.birthday.day} ${user.birthday.month} ${user.birthday.year?c}</p></td>
                    </tr>
                </#if>
                <#if user.sex??>
                    <tr>
                        <td><p class="text-muted">Пол:</p></td>
                        <td><p class="text-muted">${user.sex}</p></td>
                    </tr>
                </#if>
                <#if user.address.country??>
                    <#if user.address.country != "">
                        <tr>
                            <td><p class="text-muted">Страна:</p></td>
                            <td><p class="text-muted">${user.address.country}</p></td>
                        </tr>
                    </#if>
                </#if>
                <#if user.address.hometown??>
                    <#if user.address.hometown != "">
                        <tr>
                            <td><p class="text-muted">Родной город:</p></td>
                            <td><p class="text-muted">${user.address.hometown}</p></td>
                        </tr>
                    </#if>
                </#if>
                <#if user.relationshipStatus??>
                    <tr>
                        <td><p class="text-muted">Отношения:</p></td>
                        <td><p class="text-muted">${user.relationshipStatus}</p></td>
                    </tr>
                </#if>
            </table>
        </div>
    </div>
    <div class="row">
        <div class="col-md-4">
            <a href="/${user.id}/edit">Редактировать профиль</a>
        </div>
        <div class="col-md-8">
            <@form.form action="/posts/add" method="post" onsubmit="return empty_form()" modelAttribute="postForm">
                <div class="form-group">
                    <@form.textarea path="text" cssClass="form-control" id="msg"/>
                </div>
                <div class="col-md-2 col-md-offset-10">
                    <button type="submit" class="btn btn-default btn-xs">Save</button>
                </div>
            </@form.form>

            <#list user.posts as post>
                <div class="post">
                    <small>${post.date}</small>
                    <p>${post.text}</p>
                    <@security.authentication property="principal.user.id" var="user_id"/>
                    <@security.authorize access="${(post.user?? && user_id == user.id)?c}">
                        <a href="/posts/${post.id?c}/delete" class="btn btn-danger btn-xs delete-post">Удалить</a>
                    </@security.authorize>

                </div>
            <#else>
                <p>Нет записей</p>
            </#list>
        </div>
    </div>
</#macro>

<@main title="Моя страница" customScripts=["/resources/js/empty_form.js", "/resources/js/posts.js"]/>