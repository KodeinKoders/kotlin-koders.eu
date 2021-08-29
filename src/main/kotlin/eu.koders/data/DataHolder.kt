package eu.koders.data

import kotlin.properties.ReadOnlyProperty
import kotlin.reflect.KProperty

data class Data<T : Any>(val id: String, val data: T) {
    override fun equals(other: Any?): Boolean =
            other is Data<*>
        &&  this.id == other.id
        &&  this.data::class == other.data::class

    override fun hashCode(): Int = (31 * id.hashCode()) + data::class.hashCode()
}

abstract class DataHolder<T : Any>(private val parent: DataHolder<in T>? = null) {

    private val map: MutableMap<String, Data<T>> = HashMap()

    operator fun T.provideDelegate(thisRef: DataHolder<T>, property: KProperty<*>): ReadOnlyProperty<DataHolder<T>, Data<T>> {
        val data = Data(property.name, this)
        map[property.name] = data
        @Suppress("UNCHECKED_CAST")
        if (parent != null) (parent.map as MutableMap<String, Data<in T>>)[property.name] = data
        return ReadOnlyProperty { _, _ -> data }
    }

//    operator fun T.getValue(thisRef: DataHolder<T>, property: KProperty<*>): Data<T> {
//        val data = Data(property.name, this)
//        map[property.name] = data
//        @Suppress("UNCHECKED_CAST")
//        if (parent != null) (parent.map as MutableMap<String, Data<in T>>)[property.name] = data
//        return data
//    }

    operator fun get(id: String): Data<T>? = map[id]

    val all: Collection<Data<T>> get() = map.values
}
