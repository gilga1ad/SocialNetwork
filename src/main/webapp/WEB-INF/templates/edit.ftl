<#assign form=JspTaglibs["http://www.springframework.org/tags/form"]/>

<#include "page-template.ftl"/>

<#macro m_body>
<h4>Редактировать профиль</h4>
    <@form.form action="/${userUpdateForm.id}/save" method="post" modelAttribute="userUpdateForm" enctype="multipart/form-data">
    <div class="form-group">
        <@form.label path="firstName">Имя</@form.label>
        <@form.input path="firstName" cssClass="form-control"/>
        <@form.errors path="firstName"/>
    <#--<div class="col-sm-8"><@spring.formInput "form.firstName" "class='form-control'"/></div>-->
    <#--<@spring.showErrors "<br>"/>-->
    </div>
    <div class="form-group">
        <@form.label path="lastName">Фамилия</@form.label>
        <@form.input path="lastName" cssClass="form-control"/>
        <@form.errors path="lastName"/>
    </div>
    <div class="form-group">
        <@form.label path="sex">Пол</@form.label>
        <@form.select size="1" path="sex" cssClass="form-control">
            <@form.option value=""></@form.option>
            <@form.option value="MALE">Male</@form.option>
            <@form.option value="FEMALE">Female</@form.option>
        </@form.select>
        <@form.errors path="sex"/>
    </div>
    <div class="form-group">
        <@form.label path="relationshipStatus">Отношения</@form.label>
        <@form.select size="1" path="relationshipStatus" cssClass="form-control">
            <@form.option value=""></@form.option>
            <@form.option value="SINGLE">Single</@form.option>
            <@form.option value="INARELATIONSHIP">In a relationship</@form.option>
            <@form.option value="MARRIED">Married</@form.option>
            <@form.option value="INLOVE">In love</@form.option>
        </@form.select>
        <@form.errors path="relationshipStatus"/>
    </div>
    <div class="form-group">
        <@form.label path="country" >Страна</@form.label>
        <@form.select size="1" path="country" cssClass="form-control">
            <@form.option value=""></@form.option>
            <@form.option value="Russia">Russia</@form.option>
            <@form.option value="China">China</@form.option>
            <@form.option value="USA">USA</@form.option>
            <@form.option value="Germany">Germany</@form.option>
            <@form.option value="United Kingdom">United Kingdom</@form.option>
            <@form.option value="Canada">Canada</@form.option>
            <@form.option value="France">France</@form.option>
        </@form.select>
        <@form.errors path="country"/>
    </div>
    <div class="form-group">
        <@form.label path="hometown">Родной город</@form.label>
        <@form.input path="hometown" cssClass="form-control"/>
        <@form.errors path="hometown"/>
    </div>
    <div class="form-group">
        <label>День рождения</label>
        <@form.errors path="day"/>
        <@form.errors path="year"/>
    </div>
    <div class="col-md-3">
        <div class="form-group">
            <@form.select size="1" path="day" cssClass="form-control">
                        <#list 1..31 as i>
                <@form.option value = i>${i}</@form.option>
            </#list>
                    </@form.select>
        </div>
    </div>
    <div class="col-md-6">
        <div class="form-group">
            <@form.select size="1" path="month" cssClass="form-control">
                <@form.option value="JANUARY">января</@form.option>
                <@form.option value="FEBRUARY">февраля</@form.option>
                <@form.option value="MARCH">марта</@form.option>
                <@form.option value="APRIL">апреля</@form.option>
                <@form.option value="MAY">мая</@form.option>
                <@form.option value="JUNE">июня</@form.option>
                <@form.option value="JULY">июля</@form.option>
                <@form.option value="AUGUST">августа</@form.option>
                <@form.option value="SEPTEMBER">сентября</@form.option>
                <@form.option value="OCTOBER">октября</@form.option>
                <@form.option value="NOVEMBER">ноября</@form.option>
                <@form.option value="DECEMBER">декабря</@form.option>
            </@form.select>
        </div>
    </div>
    <div class="col-md-3">
        <div class="form-group">
            <@form.select size="1" path="year" cssClass="form-control">
                        <#list 2017..1900 as i>
                <@form.option value = i>${i}</@form.option>
            </#list>
                    </@form.select>
        </div>
    </div>
    <div class="form-group">
        <label>Profile image</label>
        <input type="file" name="profilePhoto" accept="image/jpeg,image/png,image/gif"/>
    </div>
    <button type="submit" class="btn btn-default">Save</button>
    </@form.form>
</#macro>

<@main title="Редактировать"/>