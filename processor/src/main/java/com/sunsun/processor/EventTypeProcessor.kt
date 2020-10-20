package com.sunsun.processor

import com.squareup.kotlinpoet.*
import javax.annotation.processing.*
import javax.lang.model.element.TypeElement
import javax.lang.model.util.Elements
import javax.lang.model.util.Types
import com.squareup.kotlinpoet.ParameterizedTypeName.Companion.parameterizedBy
import com.sunsun.annotation.MyEventType
import javax.lang.model.element.VariableElement


/**
 * {事件类型注解处理类}
 *
 */

class EventTypeProcessor : AbstractProcessor() {
    private var filer: Filer? = null
    private var elements: Elements? = null
    private var types: Types? = null
    private var messager: Messager? = null

    override fun init(p0: ProcessingEnvironment?) {
        super.init(p0)
        filer = p0?.filer
        elements = p0?.elementUtils
        types = p0?.typeUtils
        messager = p0?.messager
    }

    override fun getSupportedAnnotationTypes(): MutableSet<String> {
        return mutableSetOf(MyEventType::class.java.canonicalName)
    }

    override fun process(annotations: MutableSet<out TypeElement>?, roundEnv: RoundEnvironment?): Boolean {
        val eventTypeMap = PropertySpec
                .builder("eventTypeMap",
                        HashMap::class.asClassName().parameterizedBy(Pair::class.asClassName().parameterizedBy(String::class.asClassName(), String::class.asClassName()),
                                Boolean::class.asClassName()))
                .mutable()
                .initializer("HashMap<Pair<String, String>, Boolean>()")
                .build()

        val initFun = FunSpec.builder("initMap")


        val set = roundEnv?.getElementsAnnotatedWith(MyEventType::class.java)
        set?.let {
            for (element in set) {
                if (element is VariableElement) {
                    val annotation = element.getAnnotation(MyEventType::class.java)
                    initFun.addStatement("eventTypeMap[Pair(\"${annotation.type}\", \"${element.constantValue}\")] = true")
                }

            }
        }

        val eventTypeMapObject = TypeSpec
                .objectBuilder("EventTypeMap")
                .addProperty(eventTypeMap)
                .addFunction(initFun.build())
                .addInitializerBlock(CodeBlock.builder().add("initMap()").build())
                .build()

        val file = FileSpec.builder("pp.product.credit", "EventTypeMap")
                .addType(eventTypeMapObject)
                .build()

        try {
            file.writeTo(filer!!)
        } catch (ex: Exception) {

        }

        return false
    }
}

