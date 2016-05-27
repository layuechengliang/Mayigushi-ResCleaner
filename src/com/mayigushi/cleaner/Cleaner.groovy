package com.mayigushi.cleaner

/**
 * @author tangzhifei on 16/5/26.
 */
class Cleaner {

    /** 白名单 */
    def static whiteList = []

    /** 白名单文件 */
    def static WHITE_LIST_FILE = "src/whitelist.txt"

    /** lint分析类型 */
    def static PROBLEM_CLASS_UNUSED_RESOURCES = "Unused resources"

    /** 工程所在路径 */
    def static PROJECT_DIR = "/Users/tangzhifei/Desktop/Cleaner"

    /** lint分析后得到的xml文件名,请替换 */
    def static UNUSED_RESOURCES_FILE = "src/AndroidLintUnusedResources.xml"

    static {
        new File(WHITE_LIST_FILE).eachLine { line ->
            whiteList.add(line)
        }
    }

    static main(args) {
        def xml = new XmlParser().parse(UNUSED_RESOURCES_FILE);
        def problems = xml.problem;
        problems.each {
            def originalFilePath = it.file.text();
            def fileName = originalFilePath.substring(originalFilePath.lastIndexOf("/") + 1);
            def finalFilePath = originalFilePath.substring(originalFilePath.lastIndexOf("\$") + 1)
            def problem_class = it.problem_class.text();
            if (PROBLEM_CLASS_UNUSED_RESOURCES.equals(problem_class) && !whiteList.contains(fileName)) {
                def command = "rm " + PROJECT_DIR + finalFilePath;
                println "${command}"
                command.execute();
            }
        }
    }

}
