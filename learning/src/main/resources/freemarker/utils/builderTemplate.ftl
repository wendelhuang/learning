public class ${target}Builder {
    private ${target} ${target?uncap_first};

    public ${target}Builder() {
        ${target?uncap_first} = new ${target}();
    }

    <#list fields as f>
    public ${target}Builder set${f.name?cap_first}(${f.getType().toString()?keep_after_last(".")} ${f.name}) {
        ${target?uncap_first}.set${f.name?cap_first}(${f.name});
        return this;
    }

    </#list>

    public ${target} build() {
        return ${target?uncap_first};
    }
}